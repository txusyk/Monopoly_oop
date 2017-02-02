package org.pmoo.monopoly;

public class CartaSaldo extends Carta{

	private int saldoMod;
	private String pagaOcobra;

	public CartaSaldo(int pSaldoMod, String pPagaOcobra, String pEnunciado){
		super(pEnunciado);
		this.saldoMod = pSaldoMod;
		this.pagaOcobra = pPagaOcobra;
	}

	public void activarCarta(Jugador pJugador){
		System.out.println(pJugador.getNombre()+": "+super.getEnunciado());
		if (pagaOcobra.equalsIgnoreCase("paga")){
			pJugador.modificarSaldo(this.saldoMod,"paga");
		}
		else{
			pJugador.modificarSaldo(this.saldoMod,"cobra");
		}
	}
}
