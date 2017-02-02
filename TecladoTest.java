package org.pmoo.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TecladoTest {


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTeclado() {
	}


	@Test
	public void testRecogerInt() {
		int auxI;
		System.out.println("Debería recoger correctamente el dato introducido por el usuario, y si el dato no es valido, loopear hasta que lo sea.");
		System.out.println("Introduce un numero: ");
		auxI=Teclado.getMiTeclado().recogerInt();
		System.out.println("El numero que has introducido es: "+auxI);
	}

	@Test
	public void testRecogerString() {
		String auxS=null;
		System.out.println("Debería recoger correctamente el dato introducido por el usuario, y si el dato no es valido, loopear hasta que lo sea.");
		System.out.println("Introduce un string: ");
		auxS= Teclado.getMiTeclado().recogerString();
		System.out.println("Has introducido: "+auxS);
	}


	@Test
	public void testRecogerSiOno() {
		boolean auxS;
		System.out.println("Debería recoger correctamente el dato introducido por el usuario, y si el dato no es valido, loopear hasta que lo sea.");
		System.out.println("Introduce SI/NO: ");
		auxS=Teclado.getMiTeclado().recogerSiOno();
		System.out.println("En caso de que hayas puesto 'si', saldra 'true', y en caso contrario 'false'--> "+auxS);
	}

}
