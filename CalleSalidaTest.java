package org.pmoo.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalleSalidaTest {

	CalleSalida auxC;
	Jugador auxJ;
	
	@Before
	public void setUp() throws Exception {
		auxC= new CalleSalida("CallePrueba", 0);
		auxJ= new Jugador("JugPrueba", 1);
	}

	@After
	public void tearDown() throws Exception {
		auxC=null;
		auxJ=null;
	}

	@Test
	public void testRealizarOperacion() {
		System.out.println("Debería setear el parking a false, y el jugador debería cobrar 200€.");
		auxC.realizarOperacion(auxJ);
		assertFalse(auxJ.getSiParking());
		assertEquals(5200, auxJ.getSaldo());
	}

	@Test
	public void testImprimirInfoCalle() {
		System.out.println("Debería mostrar informacion de la calle.");
		auxC.imprimirInfoCalle();
	}

	@Test
	public void testCalleSalida() {
		assertNotNull(auxC);
	}

}
