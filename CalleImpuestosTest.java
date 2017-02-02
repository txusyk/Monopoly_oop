package org.pmoo.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalleImpuestosTest {

	CalleImpuestos auxC;
	Jugador auxJ;
	
	@Before
	public void setUp() throws Exception {
		auxC= new CalleImpuestos("CallePrueba", 4);
		auxJ= new Jugador("JugadorPrueba", 1);
	}

	@After
	public void tearDown() throws Exception {
		auxC= null;
		auxJ= null;
	}

	@Test
	public void testRealizarOperacion() {
		System.out.println("Movemos a JugadorPrueba a la casilla 4 para que tenga que pagar los impuestos.");
		auxJ.actualizarPosicion(4);
		auxC.realizarOperacion(auxJ);		
	}

	@Test
	public void testImprimirInfoCalle() {
		System.out.println("Debería imprimir la informacion de la calle.");
		auxC.imprimirInfoCalle();
	}

	@Test
	public void testCalleImpuestos() {
		assertNotNull(auxC);
	}

}
