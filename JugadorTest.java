package org.pmoo.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JugadorTest {

	Jugador jAux1, jAux2;
	
	@Before
	public void setUp() throws Exception {
		jAux1 = new Jugador("jPrueba1", 01);
	}

	@After
	public void tearDown() throws Exception {
		jAux1 = null;
	}

	@Test
	public void testJugador() {
		System.out.println("\nTest jugador(): Comprobamos que el jugador que hemos creado no es null");
		assertNotNull(jAux1);
	}

	@Test
	public void testGetNombre() {
		System.out.println("\nTest getNombre(): Comprobamos que el nombre es 'jPrueba1'");
		assertEquals("jPrueba1", jAux1.getNombre());
		System.out.println("\nImprimimos la informacion del usuario: ");
		jAux1.imprimirInfo();
	}

	@Test
	public void testGetId() {
		System.out.println("\nTest getId(): Comprobamos que el id es '01'");
		assertEquals("01", jAux1.getId());
		System.out.println("\nImprimimos la informacion del usuario: ");
		jAux1.imprimirInfo();
	}

	@Test
	public void testGetLProp() {
		System.out.println("\nTest getLProp(): Comprobamos que la lista de propiedades no es null");
		assertNotNull(jAux1.getLProp());
	}

	@Test
	public void testGetPos() {
		System.out.println("\nTest getPos(): Comprobamos que devuelve la posicion correctamente");
		assertEquals(0,jAux1.getPos());
		System.out.println("Deberia ser 5000€. Y es: "+jAux1.getPos());
	}

	@Test
	public void testGetSaldo() {
		System.out.println("\nTest getSaldo(): Comprobamps que devuelve correctamente el saldo del jugador");
		assertEquals(5000,jAux1.getSaldo());
		System.out.println("Deberia ser 5000€. Y es: "+jAux1.getSaldo()+"€");
	}

	@Test
	public void testModificarSaldo() {
		System.out.println("\nTest modificarSaldo(): Modifica el saldo (resta o suma) en funcion del string que se le indica");
		System.out.println("\tSu saldo inicial es: "+jAux1.getSaldo()+"€");
		System.out.println("\n\t-Prueba 1: Restamos 100. Quedan 4900€");
		System.out.print("\t\t");jAux1.modificarSaldo(100, "paga");
		assertEquals(4900,jAux1.getSaldo());
		System.out.println("\n\t-Prueba 2: Sumamos 200. Quedan 5100€");
		System.out.print("\t\t");jAux1.modificarSaldo(200, "cobra");
		assertEquals(5100,jAux1.getSaldo());
		
	}

	@Test
	public void testActualizarPosicion() {
		System.out.println("\nTest actualizarPosicion: Comprobamos que actualiza correctamente la posicion del jugador");
		System.out.println("\tSu posicion inicial es: "+jAux1.getPos());
		System.out.println("\n\t-Prueba 1: Movemos a una posicion valida y comprobamos");
		jAux1.actualizarPosicion(10);
		assertEquals(10, jAux1.getPos());
		System.out.println("\t\tSu posicion es: "+jAux1.getPos());
		System.out.println("\n\t-Prueba 2: Movemos a una posicion no valida (42, que deberia ser 2) y comprobamos");
		jAux1.actualizarPosicion(42);
		assertEquals(2, jAux1.getPos());
		System.out.println("\t\tSu posicion es: "+jAux1.getPos());

		
	}

	@Test
	public void testGetSiParking() {
		System.out.println("\nTest getSiParking(): Comprobamos si esta en parking gratuito");
		System.out.println("\n\t-Prueba 1: Deberia de indicar que es falso, dado que esta en la posicion 0");
		assertFalse(jAux1.getSiParking());
		System.out.println("\t\tEs o no parking: "+jAux1.getSiParking());
		System.out.println("\n\t-Prueba 2: Deberia de indicar que es verdadero, dado que esta en la posicion de parking");
		jAux1.actualizarPosicion(20);
		CalleParking auxC = new CalleParking("Parking", 20);
		Tablero.getMiTablero().anadirCasillaTablero(auxC);
		System.out.print("\t");auxC.realizarOperacion(jAux1);
		assertTrue(jAux1.getSiParking());
		System.out.println("\t\tEs o no parking: "+jAux1.getSiParking());
		System.out.println("\n\t-Prueba 3: Deberia de indicar que es verdadero, dado que ha caido en parking.Posicion 22.");
		jAux1.actualizarPosicion(30);
		assertTrue(jAux1.getSiParking());
		System.out.println("\t\tEs o no parking: "+jAux1.getSiParking());
		System.out.println("\n\t-Prueba 4: Deberia de indicar que es falso, dado que ha caido en parking anteriormente, pero ahora ha pasado por la salida");
		jAux1.actualizarPosicion(39+12);
		assertFalse(jAux1.getSiParking());
		System.out.println("\t\tEs o no parking: "+jAux1.getSiParking());
	}

	@Test
	public void testSetSiParking() {
		System.out.println("\nTest setSiParking(): Comprueba si es capaz de cambiar el estado del flag");
		System.out.println("\n\tPrueba 1: Deberia mostrar FALSE => "+jAux1.getSiParking());
		assertFalse(jAux1.getSiParking());
		jAux1.setSiParking(true);
		System.out.println("\n\tPrueba 2: Deberia mostrar TRUE => "+jAux1.getSiParking());
		assertTrue(jAux1.getSiParking());

	}

	@Test
	public void testEsBancarrota() {
		System.out.println("\nTest esBancarrota(): Comprueba si recibe correctamente el flag");
		System.out.println("\n\t Prueba 1: Deberia mostrar FALSE => "+jAux1.esBancarrota());
		assertFalse(jAux1.esBancarrota());
		System.out.println("\n\t Prueba 2: Tienes 5000 y debes pagar 6000. Te niegas a hipotecar.Deberia mostrar TRUE => "+jAux1.esBancarrota());
		jAux1.modificarSaldo(6000, "paga");
		assertTrue(jAux1.esBancarrota());
	}

	@Test
	public void testJugarTurno() {
		fail("Not yet implemented");
	}

	@Test
	public void testHipotecar() {
		fail("Not yet implemented");
	}

	@Test
	public void testImprimirInfo() {
		System.out.println("\nTest imprimirInfo(): Comprueba que se imprime correctamente la informacion del usuario");
		System.out.println("\t");jAux1.imprimirInfo();
	}

}
