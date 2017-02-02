package org.pmoo.monopoly;

import java.util.ArrayList;
import java.util.Random;

public class ListaCartas {
	
	private ArrayList<Carta> listaC;
	private static ListaCartas miListaCartas;
	
	private ListaCartas(){
		this.listaC = new ArrayList<Carta>();
	}
	
	public static ListaCartas getMiListaCartas(){
		if (miListaCartas == null){
			miListaCartas = new ListaCartas();
		}
		return miListaCartas;
	}
	
	/*
	 * Busca una carta aleatoria en base al tamaño de la lista
	 */
	public Carta buscarCartaAleatoria(){
		Random rand = new Random();
		int index = rand.nextInt(this.listaC.size()-1);
		return this.listaC.get(index);
	}
	
	/*
	 * La carta que se recibe como parametro es añadida a la lista
	 */
	public void anadirCarta(Carta pCarta){
			ListaCartas.getMiListaCartas().listaC.add(pCarta);
	}
	
	/*
	 * Indica el numero de cartas que contiene la lista
	 */
	public int cuantasCartas(){
		return this.listaC.size();
	}
	
	/*
	 * Borra la lista de cartas
	 */
	public void resetear(){
		this.listaC.clear();
	}
	
}
