package org.pmoo.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CartaSaldoTest {
	
	CartaSaldo cAux1,cAux2;
	Jugador jAux;
	@Before
	public void setUp() throws Exception {
		cAux1 = new CartaSaldo(10, "paga", "Paga 10");
		cAux2 = new CartaSaldo(10, "cobra", "Cobra 10");
		jAux = new Jugador("Patxi", 01);
	}

	@After
	public void tearDown() throws Exception {
		cAux1 = null;
		cAux2 = null;
	}

	@Test
	public void testCartaSaldo() {
		assertNotNull(cAux1);
	}
	
	@Test
	public void testActivarCarta() {
		assertEquals(5000, jAux.getSaldo());
		System.out.println("El jugador: "+jAux.getNombre()+". Activa la carta: ");
		cAux1.activarCarta(jAux);
		assertNotEquals(jAux.getSaldo(), 5000);
	}
}
