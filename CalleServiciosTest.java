package org.pmoo.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalleServiciosTest {
	
	CalleServicios auxC;
	Jugador auxJ;
	Jugador auxJ2;

	@Before
	public void setUp() throws Exception {
		auxJ= new Jugador("JugadorPrueba", 1);
		auxJ2= new Jugador("JugadorPrueba2", 2);
		auxC= new CalleServicios("CallePrueba", 12, 200);
	}

	@After
	public void tearDown() throws Exception {
		auxJ= null;
		auxC= null;
	}
	
	@Test
	public void testImprimirInfoCalle() {
		System.out.println("Debería imprimir informacion de la calle: ");
		auxC.imprimirInfoCalle();
	}

	@Test
	public void testCalleServicios() {
		assertNotNull(auxC);
	}

	@Test
	public void testGetPrecio() {
		assertNotNull(auxC.getPrecio());
	}

	@Test
	public void testLiberarPropiedad() {
		ListaJugadores.getMiListaJugadores().anadirJugador(auxJ);
		Tablero.getMiTablero().anadirCasillaTablero(auxC);
		auxJ.actualizarPosicion(12);
		auxC.realizarOperacion(auxJ);
		System.out.println("Debería ponernos el booleano enVenta a false.");
		auxC.liberarPropiedad(auxJ);
	}

	@Test
	public void testRealizarOperacion() {
		ListaJugadores.getMiListaJugadores().anadirJugador(auxJ);
		ListaJugadores.getMiListaJugadores().anadirJugador(auxJ2);
		Tablero.getMiTablero().anadirCasillaTablero(auxC);
		System.out.println("Ejecutamos la casilla, y hacemos que la compre el primer jugador, para comprobar que se compra bien,"
				+ " y después, comprobar que el 2o jugador cae en esa casilla y realiza correctamente el pago.");
		auxJ.actualizarPosicion(12);
		auxC.realizarOperacion(auxJ);
		auxJ2.actualizarPosicion(12);
		auxC.realizarOperacion(auxJ2);
		
	}

}
