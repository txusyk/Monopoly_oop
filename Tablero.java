package org.pmoo.monopoly;

public class Tablero {
	
	private Calle[] tablero;
	private static Tablero miTablero;
	
	private Tablero(){
		this.tablero = new Calle[40];
	}
	
	public static Tablero getMiTablero(){
		if (miTablero == null){
			miTablero = new Tablero();
		}
		return miTablero;
	}
	
	/*
	 * Añade la casilla que se recibe como parametro en la posicion que contiene
	 */
	public void anadirCasillaTablero(Calle pCalle){
		System.out.print("\t");pCalle.imprimirInfoCalle();
		System.out.print("\n");
		this.tablero[pCalle.pos] = pCalle;
	}
	
	/*
	 * Devuelve una calle por la posicion en la que se encuentra
	 */
	public Calle buscarCallePorPos(int pPos){
		return tablero[pPos];
	}
	
	/*
	 * Borra el tablero
	 */
	public void resetear(){
		this.tablero = new Calle[40];
	}
}
