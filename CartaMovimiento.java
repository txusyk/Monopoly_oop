package org.pmoo.monopoly;

public class CartaMovimiento extends Carta{
	
	private int posDestino;

	public CartaMovimiento( int pPosDestino, String pEnunciado){
		super(pEnunciado);
		this.posDestino = pPosDestino;
	}

	public void activarCarta(Jugador pJugador){
		System.out.println(pJugador.getNombre()+": "+super.getEnunciado());
		pJugador.moverJugador(posDestino);
		Calle cAux = Tablero.getMiTablero().buscarCallePorPos(posDestino);
		cAux.realizarOperacion(pJugador);
	}
}
