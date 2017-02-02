package org.pmoo.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class TableroTest {

	@After
	public void tearDown() throws Exception {
		Tablero.getMiTablero().resetear();
	}

	@Test
	public void testGetMiTablero() {
		System.out.println("Test getMiTablero(): Comprueba si el tablero que se devuelve es null");
		assertNotNull(Tablero.getMiTablero());
	}

	@Test
	public void testAnadirCasillaTablero() {
		System.out.println("\nTest añadirCasillaTablero(): Comprueba que se añaden correctamente las calles");
		System.out.println("\n\t-Prueba 1: La calle no esta aun añadida. No mostrara informacion.");
		assertNull(Tablero.getMiTablero().buscarCallePorPos(01));
		System.out.println("\n\t-Prueba 2: Hay una calle de prueba. Esta es su informacion: ");
		Calle cAux = new CalleEstaciones("EstacionPrueba", 01, 200);
		Tablero.getMiTablero().anadirCasillaTablero(cAux);
		System.out.print("\t\t");cAux.imprimirInfoCalle();
		assertNotNull(Tablero.getMiTablero().buscarCallePorPos(01));
	}

	@Test
	public void testBuscarCallePorPos(){
		System.out.println("\nTest buscarCallePorPos(): Devuelve la calle de una posicion, en caso de no encontrarse devuelve null");
		System.out.println("\n\t-Prueba 1: La calle no esta aun añadida. No mostrara informacion");
		assertNull(Tablero.getMiTablero().buscarCallePorPos(01));
		System.out.println("\n\t-Prueba 2: Hay una calle de prueba. Esta es su informacion: ");
		Calle cAux = new CalleEstaciones("EstacionPrueba", 01, 200);
		Tablero.getMiTablero().anadirCasillaTablero(cAux);
		System.out.print("\t\t");cAux.imprimirInfoCalle();
		assertNotNull(Tablero.getMiTablero().buscarCallePorPos(01));
		assertEquals("EstacionPrueba",Tablero.getMiTablero().buscarCallePorPos(01).getNombre());
		System.out.println("\n\t-Prueba 3: Hay una calle de prueba. La sobreescribimos. Esta es su informacion: ");
		cAux = new CalleEstaciones("EstacionPrueba2", 02, 200);
		Tablero.getMiTablero().anadirCasillaTablero(cAux);
		System.out.print("\t\t");cAux.imprimirInfoCalle();
		assertNotNull(Tablero.getMiTablero().buscarCallePorPos(01));
	}

}
