package org.pmoo.monopoly;

public abstract class Calle {
	
	protected String nombre;
	protected int pos;

	public Calle(String pNombre, int pPos){
		this.nombre = pNombre;
		this.pos = pPos;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getPosicion(){
		return this.pos;
	}
	
	/*
	 * Llama al metodo de los hijos que realizara la operacion correspondiente.
	 * Pagar o comprar el alquiler.
	 */
	public abstract void realizarOperacion(Jugador pJugador);
	
	/*
	 * Llama al metodo de los hijos que imprimira la informacion de la calle
	 * por pantalla
	 */
	public abstract void imprimirInfoCalle();
}
