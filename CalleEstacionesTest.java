package org.pmoo.monopoly;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalleEstacionesTest {

	Jugador auxJ1;
	Jugador auxJ2;
	CalleEstaciones auxC;
	FileReader f;
	
	@Before
	public void setUp() throws Exception {
		auxC=new CalleEstaciones("ANDROID MOBILE PLATFORM", 5, 200);
		auxJ1= new Jugador("JugadorPruebas", 1);
		auxJ2= new Jugador("JugadorPruebas", 2);
		try {
			f= new FileReader("googolopoly.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@After
	public void tearDown() throws Exception {
		auxC=null;
		auxJ1=null;
		auxJ2=null;
	}

	@Test
	public void testImprimirInfoCalle() {
		System.out.println("Deberia mostrar iformacion de la calle: ");
		auxC.imprimirInfoCalle();
	}

	@Test
	public void testRealizarOperacion() {
		System.out.println("Añadimos la calle de prueba a la lista de propiedades del Jugador 1.");
		auxJ1.getLProp().anadirCalle(auxC);
		System.out.println("El propietario de CallePrueba es: "+ListaJugadores.getMiListaJugadores().buscarPropietarioDeCalle(auxC.nombre));
		System.out.println("Ahora movemos al 2o jugador a la misma casilla, para saber si efectua correctamente el pago por posesion.");
		auxJ2.actualizarPosicion(5);
		auxC.realizarOperacion(auxJ2);	
		
	}
}
