package org.pmoo.monopoly;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalleTest {
	
	Calle auxC;
	Calle auxC2;
	FileReader f;
	Jugador auxJ;

	@Before
	public void setUp() throws Exception {
		try {
			f= new FileReader("googolopoly.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		CargarFicheros.getCargarFicheros().cargarFichero(f);
		auxC= Tablero.getMiTablero().buscarCallePorPos(3);
		auxC2= Tablero.getMiTablero().buscarCallePorPos(5);
	}

	@After
	public void tearDown() throws Exception {
		f= null;
		auxC= null;
		auxC2= null;
	}

	@Test
	public void testCalle() {
		assertNotNull(auxC);
		assertNotNull(auxC2);
	}

	@Test
	public void testGetNombre() {
		System.out.println("Debería mostrar por pantalla el nombre de las calles: "+auxC.nombre+", "+auxC2.nombre);
		
	}

	@Test
	public void testGetPosicion() {
		
		assertEquals(3, auxC.pos);
		assertEquals(5, auxC2.pos);
	}

	@Test
	public void testImprimirInfoCalle() {
		System.out.println("Debería imprimir informacion sobre las calles: ");
		auxC.imprimirInfoCalle();
		auxC2.imprimirInfoCalle();
	}

	@Test
	public void testRealizarOperacion() {
		System.out.println("Debería realizar la operacion de ambas calles: ");
		System.out.println("Realizamos la operacion con la 1a calle.");
		auxC.realizarOperacion(auxJ);
		System.out.println("Realizamos la operacion con la 2a calle.");
		auxC2.realizarOperacion(auxJ);
	}

}
