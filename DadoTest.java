package org.pmoo.monopoly;

import static org.junit.Assert.*;

import org.junit.Test;

public class DadoTest {


	@Test
	public void testGetMiDado() {
		assertNotNull(Dado.getMiDado());
	}

	@Test
	public void testObtenerDados() {
		System.out.println("Comprobamos que se obtienen valores entre 1 y 12");
		System.out.println(Dado.getMiDado().obtenerDados());
		System.out.println(Dado.getMiDado().obtenerDados());
		System.out.println(Dado.getMiDado().obtenerDados());
	}

	@Test
	public void testGetSiEsDobles() {
		System.out.println("Comprobamos si al sacar dobles es consciente de ello: ");
		int numDobles = 0;
		while (numDobles < 2){
			System.out.println(Dado.getMiDado().obtenerDados());
			System.out.println(Dado.getMiDado().getSiEsDobles());
			if (Dado.getMiDado().getSiEsDobles()){
				numDobles++;
			}
		}

	}

}
