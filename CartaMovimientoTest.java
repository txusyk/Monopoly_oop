package org.pmoo.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CartaMovimientoTest {
	
	CartaMovimiento cAux1,cAux2;
	Jugador jAux;
	@Before
	public void setUp() throws Exception {
		cAux1 = new CartaMovimiento(0, "Prueba: A la salida");
		cAux2 = new CartaMovimiento(10, "Prueba: Visitas la carcel");
		jAux = new Jugador("Patxi", 01);
	}

	@After
	public void tearDown() throws Exception {
		cAux1 = null;
		cAux2 = null;
	}

	@Test
	public void testCartaMovimiento() {
		assertNotNull(cAux1);
	}
	
	@Test
	public void testActivarCarta() {
		assertEquals(0, jAux.getPos());
		System.out.println("El jugador de prueba activa una carta para moverse a la carcel (pos 10)");
		cAux2.activarCarta(jAux);
		assertEquals(jAux.getPos(), 10);
		cAux1.activarCarta(jAux);
		assertEquals(jAux.getPos(), 0);

		
	}
}
