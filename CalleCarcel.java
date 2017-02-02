package org.pmoo.monopoly;

public class CalleCarcel extends Calle {

	public CalleCarcel(String pNombre, int pPos){
		super(pNombre,pPos);
	}

	@Override
	public void realizarOperacion(Jugador pJugador) {
		boolean recienEntrado = false;
		if ((pJugador.getPos() == 10) && (!Condena.getMiCondena().esta(pJugador))){
			System.out.println("Estas de visita en la carcel. En la posicion 10.");
		}
		else{
			if (pJugador.getPos() == 30){
				System.out.println("Has caido en la carcel. Seras enviado desde la posicion 30 a la 10");
				pJugador.actualizarPosicion(10);
				Condena.getMiCondena().condenar(pJugador);
				System.out.println("Te quedan "+Condena.getMiCondena().getTurnosRestantes(pJugador)+" turnos en la carcel");
				recienEntrado=true;
			}
			if ((pJugador.getPos() ==10 && Condena.getMiCondena().esta(pJugador)) && !recienEntrado){
				Condena.getMiCondena().condenar(pJugador);
			}
		}
	}
	
	public void imprimirInfoCalle(){
		System.out.print(this.getNombre()+". De tipo 'Calle Carcel'. En la posicion "+this.pos+"\n");
	}
}


