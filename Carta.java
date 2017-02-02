package org.pmoo.monopoly;

public abstract class Carta {
	
	private String enunciado;
	
	public Carta(String pEnunciado){
		this.enunciado = pEnunciado;
	}
	
	public abstract void activarCarta(Jugador pJugador);
	
	protected String getEnunciado(){
		return this.enunciado;
	}
}
