package org.pmoo.monopoly;

public class CalleSalida extends Calle {
	
	public CalleSalida(String pNombre, int pPos){
		super(pNombre,pPos);
	}
	
	/*
	 * Paga 200€ al jugador y fija su parking gratuito a false
	 */
	public void realizarOperacion(Jugador pJugador){
		System.out.println("Has caido en "+this.getNombre()+". De tipo: Salida. En la posicion "+this.getPosicion());
		pJugador.setSiParking(false);
		pJugador.modificarSaldo(200,"cobra");
	}
	
	/*
	 * Muestra la informacion de la calle por pantalla
	 */
	public void imprimirInfoCalle(){
		System.out.print(this.getNombre()+". De tipo 'Salida'. En la posicion "+this.pos+"\n");

	}
}
