package org.pmoo.monopoly;

import java.io.FileReader;
import java.util.Scanner;

public class CargarFicheros {

	private static CargarFicheros miCargarFicheros = new CargarFicheros();

	public static CargarFicheros getCargarFicheros(){
		return miCargarFicheros;
	}
	
	/*
	 * Pre: Tenemos un fichero que queremos leer
	 * Post: Inicializamos el tablero con las casillas que cargamos. Inicializamos 
	 * la lista de cartas con las cartas que tenemos en el fichero.
	 * Return: Devolvemos una lista con todas las propiedes del tablero
	 */
	public ListaCalles cargarFichero(FileReader pFichero){
		Scanner sc = new Scanner(pFichero);
		ListaCalles lProp = new ListaCalles();
		String arrayElementos[];
		while (sc.hasNext()){
			String linea1 = sc.nextLine();
			String linea2;
			if (linea1.equals("CalleSalida")){
				//salida,0		
				linea2 =sc.nextLine();
				arrayElementos = linea2.split(",");
				Calle cSalida = new CalleSalida(arrayElementos[0],Integer.parseInt(arrayElementos[1]));
				Tablero.getMiTablero().anadirCasillaTablero(cSalida); 
			}
			if (linea1.equals("CalleServicios")){
				//Keyboard,12,150,
				linea2 = sc.nextLine();
				arrayElementos = linea2.split(",");
				CalleServicios cServ = new CalleServicios(arrayElementos[0],Integer.parseInt(arrayElementos[1]),Integer.parseInt(arrayElementos[2]));
				//enviamos el nombre, posicion, precio
				Tablero.getMiTablero().anadirCasillaTablero(cServ);
				lProp.anadirCalle(cServ);
			}
			if (linea1.equals("CalleEstandar")){
				//Sonic,6,100,AZUL,10
				linea2 = sc.nextLine();
				arrayElementos = linea2.split(",");
				CalleEstandar cE = new CalleEstandar(arrayElementos[0],Integer.parseInt(arrayElementos[1]),Integer.parseInt(arrayElementos[2]),arrayElementos[3],Integer.parseInt(arrayElementos[4]));
				//enviamos el nombre, posicion, precio,tipo,alquiler
				Tablero.getMiTablero().anadirCasillaTablero(cE);
				lProp.anadirCalle(cE); 
			}
			if (linea1.equals("CalleImpuestos")){
				//Insert Coin,38,
				linea2 = sc.nextLine();
				arrayElementos = linea2.split(",");
				CalleImpuestos cI = new CalleImpuestos(arrayElementos[0],Integer.parseInt(arrayElementos[1]));
				//enviamos el nombre, posicion, 
				Tablero.getMiTablero().anadirCasillaTablero(cI);
				//System.out.println("Añadido: "+cI.getNombre()+" . En la posicion :"+cI.getPosicion());

			}
			if(linea1.equals("CalleCarcel")){
				//carcel,10
				linea2 = sc.nextLine();
				arrayElementos = linea2.split(",");
				CalleCarcel cC = new CalleCarcel(arrayElementos[0],Integer.parseInt(arrayElementos[1]));
				//enviamos el nombre, posicion, 
				Tablero.getMiTablero().anadirCasillaTablero(cC);
				//System.out.println("Añadido: "+cC.getNombre()+" . En la posicion :"+cC.getPosicion());

			}
			if(linea1.equalsIgnoreCase("CalleEstaciones")){
				//Commodore 64,5,200
				linea2 = sc.nextLine();
				arrayElementos = linea2.split(",");
				CalleEstaciones cEstacion= new CalleEstaciones(arrayElementos[0],Integer.parseInt(arrayElementos[1]),Integer.parseInt(arrayElementos[2]));
				//enviamos el nombre, posicion, precio
				Tablero.getMiTablero().anadirCasillaTablero(cEstacion);
				//System.out.println("Añadido: "+cEstacion.getNombre()+" . En la posicion :"+cEstacion.getPosicion());

			}
			if (linea1.equalsIgnoreCase("CalleCarta")){
				//Cofre del tesoro,2
				linea2 = sc.nextLine();
				arrayElementos = linea2.split(",");
				CalleCartas cCartas = new CalleCartas(arrayElementos[0],Integer.parseInt(arrayElementos[1]));
				Tablero.getMiTablero().anadirCasillaTablero(cCartas);
				//System.out.println("Añadido: "+cCartas.getNombre()+" . En la posicion :"+cCartas.getPosicion());

			}
			if (linea1.equalsIgnoreCase("CalleParking")){
				//Coin Return,20
				linea2 = sc.nextLine();
				arrayElementos = linea2.split(",");
				CalleParking cParking = new CalleParking(arrayElementos[0],Integer.parseInt(arrayElementos[1]));
				Tablero.getMiTablero().anadirCasillaTablero(cParking);
				//System.out.println("Añadido: "+cParking.getNombre()+" . En la posicion :"+cParking.getPosicion());

			}
			if (linea1.equalsIgnoreCase("CartaSaldo")){
				//120,cobra, Recibes la paga extra de navidad
				linea2 = sc.nextLine();
				arrayElementos = linea2.split(",");
				CartaSaldo cSaldo = new CartaSaldo(Integer.parseInt(arrayElementos[0]),arrayElementos[1],arrayElementos[2]);
				//enviamos el dinero a modificar, si cobra o paga y el eunciado
				ListaCartas.getMiListaCartas().anadirCarta(cSaldo);
				//System.out.println("Añadida carta: "+cSaldo.getEnunciado());

			}
			if (linea1.equalsIgnoreCase("CartaMovimiento")){
				//30, Ve a la carcel. En caso de pasar por la calle de salida no cobras.
				linea2 = sc.nextLine();
				arrayElementos = linea2.split(",");
				CartaMovimiento cMov = new CartaMovimiento(Integer.parseInt(arrayElementos[0]),arrayElementos[1]);
				ListaCartas.getMiListaCartas().anadirCarta(cMov);
				//System.out.println("Añadida carta: "+cMov.getEnunciado());
			}
		}
		sc.close();
		return lProp;
	}
}
