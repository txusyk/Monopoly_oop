package org.pmoo.monopoly;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalleCartasTest {
	
	CalleCartas auxC;
	Jugador auxJ;

	@Before
	public void setUp() throws Exception {
		auxC= new CalleCartas("CallePrueba", 44);
		auxJ= new Jugador("Tunsteno", 1);
	}

	@After
	public void tearDown() throws Exception {
		auxC=null;
		auxJ=null;
	}

	@Test
	public void testImprimirInfoCalle() {
		System.out.println("Debería mostrar informacion de la calle: ");
		auxC.imprimirInfoCalle();
	}

	@Test
	public void testRealizarOperacion() {
		System.out.println("Debería obtener una carta y realizar su operacion: ");
		FileReader f=null;
		try {
			f = new FileReader("monopolyGaming.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CargarFicheros.getCargarFicheros().cargarFichero(f);
		auxC.realizarOperacion(auxJ);
	}

	@Test
	public void testCalleCartas() {
		assertNotNull(auxC);
		assertNotNull(auxJ);
	}

}
