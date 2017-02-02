package org.pmoo.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaJugadoresTest {

	Jugador j1,j2;

	@Before
	public void setUp() throws Exception {
		ListaJugadores.getMiListaJugadores().resetear();
		j1 = new Jugador("Josu", 01);
		j2 = new Jugador("David", 02);
		ListaJugadores.getMiListaJugadores().anadirJugador(j1);
		ListaJugadores.getMiListaJugadores().anadirJugador(j2);
	}

	@After
	public void tearDown() throws Exception {
		j1 = null;
		j2 = null;
		ListaJugadores.getMiListaJugadores().resetear();
	}

	@Test
	public void testGetMiListaJugadores() {
		System.out.println("Comprobamos que la lista no es vacia y se inicializa OK");
		assertNotNull(ListaJugadores.getMiListaJugadores());
	}

	@Test
	public void testAnadirJugador() {
		Jugador j3 = new Jugador("jPrueba", 03);
		System.out.println("La lista contiene "+ListaJugadores.getMiListaJugadores().getTamano()+" jugadores. Se intenta añadir otro mas, sus datos son: ");
		int tamanoInicial = ListaJugadores.getMiListaJugadores().getTamano();
		System.out.println("Sus datos son: ");
		j3.imprimirInfo();
		ListaJugadores.getMiListaJugadores().anadirJugador(j3);
		assertNotEquals(tamanoInicial, ListaJugadores.getMiListaJugadores().getTamano());
		assertNotNull(ListaJugadores.getMiListaJugadores().buscarJugadorPorId(j3.getId()));
		System.out.println("Intentamos añadir el mismo jugador de nuevo");
		j3.imprimirInfo();
		ListaJugadores.getMiListaJugadores().anadirJugador(j3);
		System.out.println("El tamaño sigue siendo: "+ListaJugadores.getMiListaJugadores().getTamano());
		assertEquals(tamanoInicial+1, ListaJugadores.getMiListaJugadores().getTamano());
	}

	@Test
	public void testEliminarJugador() {
		System.out.println("Comprobamos que el jugador se encuentra añadido: ");
		Jugador j4 = new Jugador("jPrueba", 04);
		j4.imprimirInfo();
		ListaJugadores.getMiListaJugadores().anadirJugador(j4);
		assertNotNull(ListaJugadores.getMiListaJugadores().buscarJugadorPorId(j4.getId()));
		ListaJugadores.getMiListaJugadores().eliminarJugador(j4);
		assertNull(ListaJugadores.getMiListaJugadores().buscarJugadorPorId(j4.getId()));
	}

	@Test
	public void testGetTamano() {
		System.out.println("El tamaño deberia ser 3");
		System.out.println(ListaJugadores.getMiListaJugadores().getTamano());
		System.out.println("Añadimos otro jugador. El tamaño deberia ser 4.");
		Jugador j4 = new Jugador("jPrueba",04);
		j4.imprimirInfo();
		ListaJugadores.getMiListaJugadores().anadirJugador(j4);
		System.out.println(ListaJugadores.getMiListaJugadores().getTamano());
	}

	@Test
	public void testBuscarJugadorPorId() {
		System.out.println("Buscamos uno de los jugadores añadidos anteriormente");
		System.out.println("En caso de encontrarse imprime su informacion: ");
		ListaJugadores.getMiListaJugadores().buscarJugadorPorId(02).imprimirInfo();
		assertNotNull(ListaJugadores.getMiListaJugadores().buscarJugadorPorId(02));
	}


	@Test
	public void testBuscarPropietarioDeCalle() {
		System.out.println("Comprobamos si el propietario es el cliente actual: ");
		Jugador j5 = new Jugador("jPrueba", 05);
		ListaJugadores.getMiListaJugadores().anadirJugador(j5);
		CalleEstaciones cE = new CalleEstaciones("EstacionPrueba", 5, 200);
		cE.realizarOperacion(j5);
		assertNotNull(ListaJugadores.getMiListaJugadores().buscarPropietarioDeCalle("EstacionPrueba"));
	}
}
