package org.pmoo.monopoly;

import java.io.FileReader;

public class JugarPartida {

	private static JugarPartida miJugarPartida;

	private JugarPartida(){
	}

	public static JugarPartida getMiJugarPartida(){
		if(miJugarPartida==null){
			miJugarPartida=new JugarPartida();
		}
		return miJugarPartida;
	}

	public boolean jugarMonopoly(FileReader f){
		CargarFicheros.getCargarFicheros().cargarFichero(f);
		System.out.println("\n\t\t-----------------------------------");
		System.out.println("\t\t\t---Tablero Cargado---");
		System.out.println("\t\t------------------------------------\n");
		boolean salir = false;
		do{//while(!salir); //fin while
			System.out.println("Indica un numero de jugadores entre 2 y 6 (0 para salir):\n");
			int opc = Teclado.getMiTeclado().recogerInt();
			if (opc == 0){
				salir = true;
			}
			else{
				if(opc>1 && opc<7){
					for(int i=1; i<=opc ; i++){ 
						Jugador auxJug;
						System.out.println("Introduce un nombre para el jugador");
						String nombreJug = Teclado.getMiTeclado().recogerString();
						if (nombreJug.isEmpty()){
							while (nombreJug.isEmpty()){
								System.out.println("Introduce un nombre valido");
								nombreJug = Teclado.getMiTeclado().recogerString();
							}
						}
						auxJug = new Jugador(nombreJug,i);
						ListaJugadores.getMiListaJugadores().anadirJugador(auxJug);
					}
					System.out.println("-----------------------------------");
					System.out.println("--------COMIENZA LA PARTIDA--------");
					System.out.println("-----------------------------------");
					boolean jugarPartida = true;
					while(jugarPartida){
						for(int i=1;i<=ListaJugadores.getMiListaJugadores().getTamano();i++){
							if(ListaJugadores.getMiListaJugadores().buscarJugadorPorId(i) != null){
								ListaJugadores.getMiListaJugadores().buscarJugadorPorId(i).jugarTurno();
								if (ListaJugadores.getMiListaJugadores().buscarJugadorPorId(i).esBancarrota()){
									ListaJugadores.getMiListaJugadores().buscarJugadorPorId(i).getLProp().liberarPropiedadesDeJugador(ListaJugadores.getMiListaJugadores().buscarJugadorPorId(i));
									ListaJugadores.getMiListaJugadores().eliminarJugador(ListaJugadores.getMiListaJugadores().buscarJugadorPorId(i));
									ListaJugadores.getMiListaJugadores().modificarIdJugadores(i);
								}
								if (ListaJugadores.getMiListaJugadores().getTamano() == 1){
									System.out.println("Has ganado!! Tus rivales estan en bancarrota");
									jugarPartida = false;
									salir = true;
								}
								if (Dado.getMiDado().getSiEsDobles() && Dado.getMiDado().getNumDobles() < 3){
									while(Dado.getMiDado().getSiEsDobles() && Dado.getMiDado().getNumDobles() < 3){
										ListaJugadores.getMiListaJugadores().buscarJugadorPorId(i).jugarTurno();
									}
								}
								else if(Dado.getMiDado().getSiEsDobles() && Dado.getMiDado().getNumDobles() == 3){
									CalleCarcel auxC = (CalleCarcel)Tablero.getMiTablero().buscarCallePorPos(10);
									System.out.println("Has sacado 3 veces seguidas dobles. Vas a la carcel.");
									auxC.realizarOperacion(ListaJugadores.getMiListaJugadores().buscarJugadorPorId(i));
								}
							}
						}
					}
				}
			}
		}while(!salir);
		return true;
	}
}