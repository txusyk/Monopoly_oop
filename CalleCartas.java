package org.pmoo.monopoly;


public class CalleCartas extends Calle{
	
	public CalleCartas(String pNombre, int pPos){
		super(pNombre,pPos);
	}
	
	/*
	 * Roba una carta y la activa para el jugador que recibe como parametro
	 */
	public void realizarOperacion(Jugador pJugador){
		System.out.println("Has caido en "+this.getNombre()+". De tipo: Suerte. En la posicion "+this.getPosicion());
		System.out.println("Robas una carta. Veamos tu suerte:");
		ListaCartas.getMiListaCartas().buscarCartaAleatoria().activarCarta(pJugador);
	}
	
	/*
	 * Imprime la informacion de la calle por pantalla
	 */
	public void imprimirInfoCalle(){
		System.out.print(this.getNombre()+". De tipo 'Calle de Suerte'. En la posicion "+this.pos+"\n");
	}
}