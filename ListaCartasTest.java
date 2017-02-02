package org.pmoo.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaCartasTest {
	
	CartaSaldo pCarta0,pCarta1;
	
	@Before
	public void setUp() {
		pCarta0 = new CartaSaldo(100,"paga", "Carta de prueba");
		pCarta1 = new CartaSaldo(100,"paga", "Carta de prueba");
		
	}

	@After
	public void tearDown() throws Exception {
		ListaCartas.getMiListaCartas().resetear();
	}

	@Test
	public void testGetMiListaCartas() {
		assertNotNull(ListaCartas.getMiListaCartas());
	}

	@Test
	public void testBuscarCartaAleatoria() {
		ListaCartas.getMiListaCartas().anadirCarta(pCarta0);
		ListaCartas.getMiListaCartas().anadirCarta(pCarta1);
		assertNotNull(ListaCartas.getMiListaCartas().buscarCartaAleatoria());
	}

	@Test
	public void testAnadirCarta() {
		int tamanoInicial = ListaCartas.getMiListaCartas().cuantasCartas();
		CartaSaldo pCarta = new CartaSaldo(100,"paga", "Carta de prueba");
		ListaCartas.getMiListaCartas().anadirCarta(pCarta);
		assertNotEquals(ListaCartas.getMiListaCartas().cuantasCartas(), tamanoInicial);
	}

}
