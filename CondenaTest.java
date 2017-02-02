package org.pmoo.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CondenaTest {

	Jugador jAux1,jAux2;
	
	@Before
	public void setUp() throws Exception {
		jAux1 = new Jugador("Prueba1", 01);
		jAux2 = new Jugador("Prueba2", 02);
	}

	@After
	public void tearDown() throws Exception {
		jAux1 = null;
		jAux2 = null;
		Condena.getMiCondena().resetear();
	}

	@Test
	public void testGetMiCondena() {
		System.out.println("Test getMiCondena() => Comprobamos que la lista no es null");
		assertNotNull(Condena.getMiCondena());
	}

	@Test
	public void testEsta() {
		System.out.println("\nTest testEsta() => Comprobamos que es capaz de gestionar si un preso esta o no en la lista");
		System.out.println("\n\t-Caso 1: El preso jAux1 no esta en la lista\n");
		assertFalse(Condena.getMiCondena().esta(jAux1));
		System.out.println("\n\t-Caso 2: El preso se encuentra añadido en la lista\n");
		jAux1.actualizarPosicion(10);
		Condena.getMiCondena().condenar(jAux1);
		if (!Dado.getMiDado().getSiEsDobles()){
			assertTrue(Condena.getMiCondena().esta(jAux1));
		}
		else{
			assertFalse(Condena.getMiCondena().esta(jAux1));
		}
	}

	@Test
	public void testGetTurnosRestantes() {
		System.out.println("\nTest tesGetTurnosRestantes() => Comprobamos que es capaz de gestionar si un preso esta o no en la lista");
		System.out.println("\n-Caso 1: El preso jAux1 no esta en la lista");
		assertFalse(Condena.getMiCondena().esta(jAux1));
		assertEquals(0,Condena.getMiCondena().getTurnosRestantes(jAux1));
		System.out.println("\n\t-Caso 2: El preso se encuentra añadido en la lista\n");
		jAux1.actualizarPosicion(10);
		Condena.getMiCondena().condenar(jAux1);
		if (!Dado.getMiDado().getSiEsDobles()){
			assertTrue(Condena.getMiCondena().esta(jAux1));
			assertEquals(3, Condena.getMiCondena().getTurnosRestantes(jAux1));
		}
		else{
			assertFalse(Condena.getMiCondena().esta(jAux1));
			assertEquals(0,Condena.getMiCondena().getTurnosRestantes(jAux1));
		}
	}

	@Test
	public void testCondenar() {
		System.out.println("\nTest Condenar() => Comprobamos que es capaz de gestionar la condena de un preso");
		System.out.println("\n\t-Caso 1: El preso jAux1 no esta en la lista");
		assertFalse(Condena.getMiCondena().esta(jAux1));
		assertEquals(0,Condena.getMiCondena().getTurnosRestantes(jAux1));
		System.out.println("\n\t-Caso 2: El preso se encuentra añadido en la lista (Acaba de caer ) \n");
		jAux1.actualizarPosicion(10);
		Condena.getMiCondena().condenar(jAux1);
		if (Dado.getMiDado().getNumDobles() <3){
			assertTrue(Condena.getMiCondena().esta(jAux1));
			assertEquals(3, Condena.getMiCondena().getTurnosRestantes(jAux1));
		}
		else if((Dado.getMiDado().getSiEsDobles()) && (Dado.getMiDado().getNumDobles() == 3 )){
			assertFalse(Condena.getMiCondena().esta(jAux1));
			
		}
		System.out.println("\nCaso 2.1 : El preso se encuentra añadido en la lista (Primer turno) ");
		Condena.getMiCondena().condenar(jAux1);
		if (!Dado.getMiDado().getSiEsDobles()){
			assertTrue(Condena.getMiCondena().esta(jAux1));
			assertEquals(2, Condena.getMiCondena().getTurnosRestantes(jAux1));
		}
		else if((Dado.getMiDado().getSiEsDobles()) && (Dado.getMiDado().getNumDobles() == 3 )){
			assertFalse(Condena.getMiCondena().esta(jAux1));
			
		}
		else{
			assertTrue(Dado.getMiDado().getNumDobles()<3);
			assertFalse(Condena.getMiCondena().esta(jAux1));
			assertEquals(0,Condena.getMiCondena().getTurnosRestantes(jAux1));
		}
		System.out.println("\nCaso 2.2 : El preso se encuentra añadido en la lista (Segundo turno) ");
		Condena.getMiCondena().condenar(jAux1);
		if (!Dado.getMiDado().getSiEsDobles()){
			assertTrue(Condena.getMiCondena().esta(jAux1));
			assertEquals(1, Condena.getMiCondena().getTurnosRestantes(jAux1));
		}
		else if((Dado.getMiDado().getSiEsDobles()) && (Dado.getMiDado().getNumDobles() == 3 )){
			assertFalse(Condena.getMiCondena().esta(jAux1));
			
		}
		else{
			assertTrue(Dado.getMiDado().getNumDobles()<3);
			assertFalse(Condena.getMiCondena().esta(jAux1));
			assertEquals(0,Condena.getMiCondena().getTurnosRestantes(jAux1));
		}
		System.out.println("\nCaso 2.3 : El preso se encuentra añadido en la lista (Tercer turno) ");
		Condena.getMiCondena().condenar(jAux1);
		if (!Dado.getMiDado().getSiEsDobles()){
			assertTrue(Condena.getMiCondena().esta(jAux1));
			assertEquals(0, Condena.getMiCondena().getTurnosRestantes(jAux1));
		}
		else if((Dado.getMiDado().getSiEsDobles()) && (Dado.getMiDado().getNumDobles() == 3 )){
			assertFalse(Condena.getMiCondena().esta(jAux1));
			
		}
		else{
			assertTrue(Dado.getMiDado().getNumDobles()<3);
			assertFalse(Condena.getMiCondena().esta(jAux1));
			assertEquals(0,Condena.getMiCondena().getTurnosRestantes(jAux1));
		}
		System.out.println("\nCaso 2.3 : El preso se encuentra añadido en la lista (Salida de carcel) ");
		Condena.getMiCondena().condenar(jAux1);
		if (!Dado.getMiDado().getSiEsDobles()){
			assertTrue(Condena.getMiCondena().esta(jAux1));
			assertEquals(0, Condena.getMiCondena().getTurnosRestantes(jAux1));
		}
		else if((Dado.getMiDado().getSiEsDobles()) && (Dado.getMiDado().getNumDobles() == 3 )){
			assertFalse(Condena.getMiCondena().esta(jAux1));
			
		}
		else{
			assertTrue(Dado.getMiDado().getNumDobles()<3);
			assertFalse(Condena.getMiCondena().esta(jAux1));
			assertEquals(0,Condena.getMiCondena().getTurnosRestantes(jAux1));
		}
	}

}
