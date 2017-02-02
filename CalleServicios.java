package org.pmoo.monopoly;

import java.util.Random;

public class CalleServicios extends Calle{

	private int precio;
	private boolean enVenta=true;

	public CalleServicios(String pNombre, int pPos, int pPrecio){
		super(pNombre, pPos);
		this.precio = pPrecio; 
	}
	
	
	/*
	 * Obtiene el valor que guarda la variable precio
	 */
	public int getPrecio(){
		return this.precio;
	}

	/*
	 * Comprueba si la calle tiene dueño, si es asi le paga el alquiler.
	 * En caso contrario ofrece al jugador la posibilidad de comprar la calle.
	 */
	@Override
	public void realizarOperacion(Jugador pJugador){
		System.out.println("Te encuentras en la posición "+this.getPosicion()+". Has caido en una calle de tipo: Servicios.");
		System.out.println();System.out.print(this.getNombre()+". De tipo 'Calle de Servicios'. En la posicion "+this.pos);
		if(!enVenta){
			Jugador jugDueno = ListaJugadores.getMiListaJugadores().buscarPropietarioDeCalle(this.nombre);
			
			if( jugDueno.getNombre().equalsIgnoreCase(pJugador.getNombre())){
				System.out.println(" .Eres el dueño de la calle. No pagas alquiler.");
			}
			else{
				int numeroCallesServicios=jugDueno.getLProp().obtenerNumeroCallesPorTipo("Servicios");
				double auxCobro=0.4*numeroCallesServicios*Dado.getMiDado().obtenerDados();
				
				Random rand = new Random();
				int cara1 = 1+rand.nextInt(6); //genera un numero entre 1 y 6
				int cara2 = 1+rand.nextInt(6);
				int resulDado = cara1+cara2;
				
				int cobro=(int)auxCobro*resulDado;
				
				System.out.print(" .Esta calle pertenece a: "+jugDueno.getNombre()+". Debes pagarle: "+cobro+"€. Dado que tiene "+numeroCallesServicios+" servicios y al lanzar los dados de nuevo has obtenido: "+resulDado+".\n");
				if (!pJugador.getSiParking()){
					pJugador.modificarSaldo(cobro, "paga");
					jugDueno.modificarSaldo(cobro, "cobra");
				}
				else{
					System.out.println(" Este turno tienes la habilidad de Parking Gratuito. No pagas el alquiler");
				}
			}

		}
		else{
			System.out.print(", no tiene dueño. Su precio es: "+this.precio+"€");
			System.out.println("¿Deseas comprar la propiedad?");
			boolean siOno = Teclado.getMiTeclado().recogerSiOno();

			if(siOno){
				pJugador.getLProp().anadirCalle(Tablero.getMiTablero().buscarCallePorPos(pJugador.getPos()));
				System.out.println("Has comprado la calle!!!");
				pJugador.modificarSaldo(this.precio, "paga");
				this.enVenta = false;
			}
			else{
				System.out.println("No has comprado la propiedad");
			}
		}
	}

	/*
	 * En caso de que el jugador que se reciba como parametro sea el dueño de la calle
	 * la libera 
	 */
	public void liberarPropiedad(Jugador pJugador){
		if (!this.enVenta){
			if (pJugador.getLProp().buscarCallePorNombre(this.nombre) != null){
				this.enVenta = true;
			}
		}
	}
	
	/*
	 * Fija la propiedad con el estado booleano que se recibe como parametro
	 */
	public void setEnVenta(boolean pEnVenta){
		this.enVenta = pEnVenta;
	}

	/*
	 * Imprime por pantalla la informacion de la calle
	 */
	public void imprimirInfoCalle(){
		System.out.print(this.getNombre()+". De tipo 'Calle de Servicios'. En la posicion "+this.pos+"\n");

	}

}
