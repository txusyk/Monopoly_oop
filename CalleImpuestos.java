package org.pmoo.monopoly;

public class CalleImpuestos extends Calle{

	int multaPequena = 50;
	int multaGrande = 200;

	public CalleImpuestos(String pNombre, int pPos){
		super(pNombre,pPos);
	}
	
	public void realizarOperacion(Jugador pJugador){
		System.out.println("Has caido en "+this.getNombre()+". De tipo: Impuestos. En la posicion "+this.getPosicion());
		if (super.pos == 4){
				pJugador.modificarSaldo(multaPequena,"paga");
				System.out.println("Has pagado 50€ de impuestos");
		}
		if (super.pos == 38){
				pJugador.modificarSaldo(multaGrande,"paga");
				System.out.println("Has pagado 200€ de impuestos");
		}
	}
	
	/*
	 * Muestra la informacion de la calle por pantalla
	 */
	public void imprimirInfoCalle(){
		System.out.print(this.getNombre()+". De tipo 'Calle de Impuestos'. En la posicion "+this.pos+"\n");
	}
}


