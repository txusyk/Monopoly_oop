package org.pmoo.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalleParkingTest {

	CalleParking auxC;
	Jugador auxJ;
	
	@Before
	public void setUp() throws Exception {
		auxC= new CalleParking("CallePrueba", 20);
		auxJ= new Jugador("JugadorPrueba", 1);
	}

	@After
	public void tearDown() throws Exception {
		auxC= null;
		auxJ= null;
	}

	@Test
	public void testRealizarOperacion() {
		System.out.println("Debería setear el booleano 'parking' del jugador a true.");
		auxC.realizarOperacion(auxJ);
		System.out.println("Booleano 'parking de jugador: "+auxJ.getSiParking());
	}

	@Test
	public void testImprimirInfoCalle() {
		System.out.println("Debería imprimir informacion sobre la calle.");
		auxC.imprimirInfoCalle();
	}

	@Test
	public void testCalleParking() {
		assertNotNull(auxC);
	}

}
