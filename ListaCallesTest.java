package org.pmoo.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaCallesTest {

	ListaCalles lC;
	CalleEstandar c1;
	CalleEstaciones c2;

	@Before
	public void setUp() throws Exception {
		lC = new ListaCalles();
		c1 = new CalleEstandar("CalleEstandar", 01, 100,"LILA", 10);
		c2 = new CalleEstaciones("CalleEstaciones", 02, 100);
		lC.anadirCalle(c1);
		lC.anadirCalle(c2);
	}

	@After
	public void tearDown() throws Exception {
		lC.resetear();
	}

	@Test
	public void testListaCalles() {
		assertNotNull(lC);
	}

	@Test
	public void testBuscarCallePorNombre() {
		String nombre;
		System.out.println("\nIntenta encontrar una calle existente =>");
		nombre = "CalleEstandar";
		assertNotNull(lC.buscarCallePorNombre(nombre));
		lC.buscarCallePorNombre("CalleEstandar").imprimirInfoCalle();
		System.out.println("\nIntenta encontrar una calle inexistente =>");
		nombre = "CallePrueba";
		assertNull(lC.buscarCallePorNombre(nombre));
	}

	@Test
	public void testAnadirCalle() {
		System.out.println("\nTratamos de añadir una calle ya existente =>");
		c1 = new CalleEstandar("CalleEstandar", 01, 100,"LILA" ,10);
		lC.anadirCalle(c1);
		assertNotNull(lC.buscarCallePorNombre(c1.getNombre()));
		System.out.println("\nTratamos de añadir una calle que no esta ya añadida => ");
		c1 = new CalleEstandar("CalleEstandar2", 02, 100,"LILA", 10);
		lC.anadirCalle(c1);
	}

	@Test
	public void testEliminarCalle() {
		System.out.println("\nTratamos de eliminar una calle existente =>");
		CalleEstandar cE = (CalleEstandar) lC.buscarCallePorNombre("CalleEstandar");
		lC.eliminarCalle(cE);
		System.out.println("\nIntentamos eliminar una calle inexistente =>");
		CalleServicios cS= new CalleServicios("Prueba", 03, 300);
		lC.eliminarCalle(cS);
	}

	@Test
	public void testObtenerNumeroCallesPorTipo() {
		System.out.println("\nHay una estacion añadida, deberia indicarse asi =>");
		assertEquals(1,lC.obtenerNumeroCallesPorTipo("estacion"));
		System.out.println("Numero total de calles, Estacion : "+lC.obtenerNumeroCallesPorTipo("estacion"));
		System.out.println("\nAñadimos otra estacion y comprobamos el total por tipo =>");
		System.out.println("Numero total de calles, Estacion : "+lC.obtenerNumeroCallesPorTipo("estacion"));
		c2 = new CalleEstaciones("CalleEstaciones2", 03, 100);
		lC.anadirCalle(c2);
		System.out.println("Numero total de calles, Estacion : "+lC.obtenerNumeroCallesPorTipo("estacion"));
		assertEquals(2,lC.obtenerNumeroCallesPorTipo("estacion"));
		assertEquals(0, lC.obtenerNumeroCallesPorTipo("servicios"));

	}

	@Test
	public void testImprimirCalles() {
		System.out.println("\nComprobamos que se imprime correctamente la informacion =>");
		c1.imprimirInfoCalle();
	}

}
