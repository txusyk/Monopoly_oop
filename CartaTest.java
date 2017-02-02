package org.pmoo.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CartaTest {

	CartaSaldo cS;
	CartaMovimiento cM;
	Jugador jAux;

	@Before
	public void setUp() throws Exception {
		cS = new CartaSaldo(100, "paga", "Pagas 10");
		cM = new CartaMovimiento(10, "Te mueves a la posicion 10");
		jAux = new Jugador("jPrueba", 01);

	}

	@After
	public void tearDown() throws Exception {
		cS = null;
		cM = null;
		jAux = null;
	}

	@Test
	public void testCarta() {
		assertNotNull(cS);
		assertNotNull(cM);
	}

	@Test
	public void testActivarCarta() {
		System.out.println("Comprobamos que esta en la salida =>");
		assertEquals(0, jAux.getPos());
		System.out.println("Comprobamos que se mueve a la posicion 10 =>");
		cM.activarCarta(jAux);
		assertEquals(10, jAux.getPos());
		System.out.println("Comprobamos que el saldo es 5000 =>");
		assertEquals(5000, jAux.getSaldo());
		System.out.println("Comprobamos que tras activar la carta se ve reducido en 100 =>");
		cS.activarCarta(jAux);
		assertEquals(4900, jAux.getSaldo());
	}

	@Test
	public void testGetEnunciado() {
		System.out.println("Comprobamos que se imprime el enunciado=>");
		String auxS = cS.getEnunciado();
		System.out.println(auxS);
	}

}
