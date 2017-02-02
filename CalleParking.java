package org.pmoo.monopoly;

public class CalleParking extends Calle{
	
	public CalleParking(String pNombre, int pPos){
		super(pNombre,pPos);
	}
	
	/*
	 * Fija el parking gratuito del jugador a true
	 */
	public void realizarOperacion(Jugador pJugador){
		System.out.println(pJugador.getNombre()+" Has caido en "+this.getNombre()+". De tipo: Parking Gratuito. En la posicion "+this.getPosicion());
		System.out.println("Felicidades!! Hasta que no pases por la casilla de salida no pagas alquileres");
		pJugador.setSiParking(true);
	}
	
	/*
	 * Imprime informacion de la calle por pantalla
	 */
	public void imprimirInfoCalle(){
		System.out.print(this.getNombre()+". De tipo 'Calle de Parking Gratuito'. En la posicion "+this.pos+"\n");
	}

}
