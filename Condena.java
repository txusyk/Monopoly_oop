package org.pmoo.monopoly;

import java.util.HashMap;
import java.util.Map;

public class Condena {

	private static Condena miCondena;

	private Map<String,Integer> lPresos;

	private Condena(){
		this.lPresos = new HashMap<String,Integer>();
	}

	public static Condena getMiCondena(){
		if(miCondena==null){
			miCondena=new Condena();
		}
		return miCondena;
	}
	
	/*
	 * Se devuelve un true en caso de encontarse en la ListaPresos
	 */
	public boolean esta(Jugador pJugador){
		boolean enc=false;
		if (lPresos.get(pJugador.getNombre()) != null){
			enc = true;
		}
		return enc;
	}
	
	/*
	 * Obtiene los turnos restantes preso del jugador que se recibe como parametro
	 */
	public int getTurnosRestantes(Jugador pJugador){
		int turnosRestantes = 0;
		if(this.esta(pJugador)){
			turnosRestantes = lPresos.get(pJugador.getNombre());
		}
		else{
			System.out.println("El jugador no esta en la carcel");
		}
		return turnosRestantes;
	}
	
	/*
	 * Recibe un jugador que o bien esta de visita, ha caido
	 * en la calle 30 de carcel o bien esta dentro del turno anterior.
	 */
	public void condenar(Jugador pJugador){
		boolean recienEntra = false;
		if (!this.esta(pJugador) && !recienEntra){
			recienEntra = true;
			lPresos.put(pJugador.getNombre(), 3);
			System.out.println(pJugador.getNombre()+": Ahora estas preso en la carcel");
		}
		if (!recienEntra){
			System.out.println("¿Quieres pagar antes para salir de la carcel?");
			boolean siOno = Teclado.getMiTeclado().recogerSiOno();
			int resulDados = Dado.getMiDado().obtenerDados();
			if (siOno){
				this.pagarCarcel(pJugador);
				pJugador.actualizarPosicion(pJugador.getPos()+resulDados);
			}
			else if (this.esta(pJugador) && recienEntra == false){
				if(this.getTurnosRestantes(pJugador)>0){
					if (Dado.getMiDado().getSiEsDobles()){ // si ha obtenido dobles
						lPresos.remove(pJugador.getNombre());
						System.out.println("Sales de la carcel, sin pagar, dado que has obtenido dobles");
						pJugador.actualizarPosicion(pJugador.getPos()+resulDados);
						Tablero.getMiTablero().buscarCallePorPos(pJugador.getPos()).realizarOperacion(pJugador);
					}
					else {
						lPresos.replace(pJugador.getNombre(), lPresos.get(pJugador.getNombre())-1);
						System.out.println("Al jugador: "+pJugador.getNombre()+" le quedan : "+lPresos.get(pJugador.getNombre())+" turnos preso.");
					}
				}
				else{
					System.out.println("No te quedan turnos en la carcel. Debes de pagar una multa de 50€");
					this.pagarCarcel(pJugador);
					pJugador.actualizarPosicion(pJugador.getPos()+resulDados);
					Tablero.getMiTablero().buscarCallePorPos(pJugador.getPos()).realizarOperacion(pJugador);
				}	
			}
		}
	}



	/*
	 * Recibe un jugador y hace que pague la salida de la carcel. 
	 * 					Le elimina de la lista de condenados.		
	 */
	private void pagarCarcel(Jugador pJugador){
		if (this.esta(pJugador)){
			if((pJugador.getSaldo()-50)>0){
				System.out.println("Pagas 50€ para salir de la carcel.");
				pJugador.modificarSaldo(50,"paga");
				lPresos.remove(pJugador.getNombre());
			}
			else{
				pJugador.hipotecar();
				pJugador.modificarSaldo(50,"paga");
				lPresos.remove(pJugador.getNombre()); //desde el gestor de turnos habra que gestionar la tirada del dado si se paga directamente	
			}
		}
	}
	
	/*
	 * Resetea la lista a nada
	 */
	public void resetear(){
		this.lPresos.clear();
	}
}
