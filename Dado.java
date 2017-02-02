package org.pmoo.monopoly;

import java.util.Random;

public class Dado {

	private boolean dobles = false;
	private static Dado miDado;
	private int contDadosDobles = 0;

	public static Dado getMiDado(){
		if(miDado == null){
			miDado = new Dado();
		}
		return miDado;
	}
	/* 
	 * Genera dos numeros entre 1 y 6. Los suma y devuelve el resultado. 
	 */
	public int obtenerDados(){
		Random rand = new Random();
		int cara1 = 1+rand.nextInt(6); //genera un numero entre 1 y 6
		int cara2 = 1+rand.nextInt(6);
		int resulDado = cara1+cara2; //obtiene el valor total de los dados

		System.out.println("Lanzando los dados... ");
		System.out.println();
		System.out.println("Has sacado: "+resulDado);

		if (cara1 == cara2){
			this.contDadosDobles++;
			this.dobles = true;
			System.out.println("Has sacado dobles!!! Podras volver a tirar");
		}
		else{
			this.dobles = false;
			this.contDadosDobles = 0;
		}
		return resulDado; //envia el valor de los dos dados
	}

	/*
	 * Devuelve si la ultima tirada han sido dobles
	 */
	public boolean getSiEsDobles(){
		this.getNumDobles();
		return this.dobles;

	}

	public int getNumDobles(){
		if (this.contDadosDobles == 3){
			this.contDadosDobles = 0;
			return 3;
		}
		else{
			return this.contDadosDobles;

		}
	}
}
