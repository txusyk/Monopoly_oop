package org.pmoo.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalleEstandarTest {

	CalleEstandar calleE;
	Jugador auxJ,auxJ2;
	
	@Before
	public void setUp() throws Exception {
		calleE = new CalleEstandar("CallePrueba", 2, 120,"LILA", 60);
		auxJ= new Jugador("JugadorPrueba", 1);
		auxJ2= new Jugador("JugadorPrueba2", 2);
	}

	@After
	public void tearDown() throws Exception {
		calleE=null;
		auxJ=null;
	}

	@Test
	public void testRealizarOperacion() {
		ListaJugadores.getMiListaJugadores().anadirJugador(auxJ);
		ListaJugadores.getMiListaJugadores().anadirJugador(auxJ2);
		Tablero.getMiTablero().anadirCasillaTablero(calleE);
		Calle auxC = Tablero.getMiTablero().buscarCallePorPos(2);
		auxJ.actualizarPosicion(2);
		auxC.realizarOperacion(auxJ);
		auxJ2.actualizarPosicion(2);
		auxC.realizarOperacion(auxJ2);
		
	}

	@Test
	public void testImprimirInfoCalle() {
		System.out.println("Deberia imprimir informacion sobre la calle.");
		calleE.imprimirInfoCalle();
	}

	@Test
	public void testCalleEstandar() {
		assertNotNull(calleE);
	}

	@Test
	public void testGetPrecio() {
		assertNotNull(calleE.getPrecio());
	}

	@Test
	public void testLiberarPropiedad() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEnVenta() {
		fail("Not yet implemented");
	}

}
