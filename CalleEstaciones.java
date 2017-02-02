package org.pmoo.monopoly;

public class CalleEstaciones extends Calle{

	private int precio;
	private boolean enVenta = true;

	public CalleEstaciones(String pNombre,int pPos,int pPrecio){
		super(pNombre,pPos);
		this.precio = pPrecio;
	}
	
	public boolean getEstaEnVenta(){
		return this.enVenta;
	}
	
	public int getPrecio(){
		return this.precio;
	}

	public void realizarOperacion(Jugador pJugador){
		System.out.println("Te encuentra en la posición "+this.getPosicion()+". Has caido en una calle de tipo: Estacion.");
		System.out.println();System.out.print(this.getNombre()+". De tipo 'Estacion'. En la posicion "+this.pos);
		if(!enVenta){
			Jugador jugDueno = ListaJugadores.getMiListaJugadores().buscarPropietarioDeCalle(Tablero.getMiTablero().buscarCallePorPos(pJugador.getPos()).getNombre());
			int numeroCallesEstacion=jugDueno.getLProp().obtenerNumeroCallesPorTipo("Estacion");
			int cobro = 50*numeroCallesEstacion;
			if( jugDueno.getNombre().equalsIgnoreCase(pJugador.getNombre())){
				System.out.println(" .Eres el dueño de la calle. No pagas alquiler.");
			}
			else{
				System.out.println(" .Esta calle pertenece a: "+jugDueno.getNombre()+". Debes pagarle: "+cobro+"€. Dado que tiene "+numeroCallesEstacion+" estaciones.\n");
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
				pJugador.modificarSaldo(this.precio, "paga");
				System.out.println("Saldo modificado");
				this.enVenta = false;
			}
			else{
				System.out.println("No has comprado la calle");
			}
		}
	}
	
	public void liberarPropiedad(Jugador pJugador){
		if (!this.enVenta){
			if (pJugador.getLProp().buscarCallePorNombre(this.nombre) != null){
				this.enVenta = true;
			}
		}
	}
	
	public void setEnVenta(boolean pEnVenta){
		this.enVenta = pEnVenta;
	}
	
	public void imprimirInfoCalle(){
		System.out.print(this.getNombre()+". De tipo 'Estacion'. En la posicion "+this.pos+"\n");
	}
	

}
