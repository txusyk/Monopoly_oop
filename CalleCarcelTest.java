package org.pmoo.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalleCarcelTest {
	
	CalleCarcel calleC;
	Jugador auxJ;
	
	@Before
	public void setUp() throws Exception {
		calleC= new CalleCarcel("CalleCarcel", 10);
		auxJ= new Jugador("JugadorPrueba", 1);
	}

	@After
	public void tearDown() throws Exception {
		calleC= null;
	}

	@Test
	public void testImprimirInfoCalle() {
		System.out.println("...Debería poner: CalleCarcel y posicion 10. Y pone:...");
		calleC.imprimirInfoCalle();
	}

	@Test
	public void testRealizarOperacion() {
		auxJ.actualizarPosicion(10);
		if(Condena.getMiCondena().esta(auxJ)){
			System.out.println("No deberia estar xd");
		}
		assertFalse(Condena.getMiCondena().esta(auxJ));
		System.out.println("...Debería informar de que estas de visita...");
		calleC.realizarOperacion(auxJ);
		System.out.println("...Llevamos al jugador a la posicion 30, y realizamos la operacion de la casilla...");
		auxJ.actualizarPosicion(30);
		System.out.println("...Debería informarnos de que nos llevará a la casilla 10...");
		calleC.realizarOperacion(auxJ);
		System.out.println("...Ahora comprobamos como funcionaría una vez sepa la casilla que ya estabamos en la carcel...");
		calleC.realizarOperacion(auxJ);
				
	}

	@Test
	public void testCalleCarcel() {
		assertNotNull(calleC);
	}

	@Test
	public void testGetNombre() {
		assertNotNull(calleC.nombre);
	}

	@Test
	public void testGetPosicion() {
		assertNotNull(calleC.getPosicion());
	}

}
