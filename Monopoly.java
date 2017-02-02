package org.pmoo.monopoly;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Monopoly {

	private static Monopoly miMonopoly = new Monopoly();

	private Monopoly(){

	}

	public static Monopoly getMiMonopoly(){
		return miMonopoly;
	}

	public static void main(String[] args) throws FileNotFoundException{
		boolean salir = false;

		System.out.println("Bienvenido al Monopoly!");
		System.out.println("A continuacion se te indicaran las pautas para jugar");
		System.out.println("Existen 3 tipos de calles que se pueden comprar. Las estaciones, las propiedades estandar y las calles de servicios.");
		System.out.println("Asi mismo existen: calles de impuestos, suerte, carcel, visita de carcel, parking y salida");
		System.out.println("\t-A la venta: ");
		System.out.println("\t\t-Propiedades: Son calles estandar. Existen por colores. Todas tienen un valor predeterminado de renta. Puede modificarse, añadiendo casas (hasta un maximo de 5 por calle) en caso de tener las 2/3 propiedades del color correspondiente. Siendo el alquiler final el producto del alquiler inicial por el numero de casas que tiene dicha calle");
		System.out.println("\t\t-Estaciones: Son 4 propiedades. Su renta se calcula: 50*n. Donde 'n' son el numero de propiedades de este tipo");
		System.out.println("\t\t-Servicios: 2 propiedades. Su renta se calcula: 0,4*n*m. Donde 'n' son el numero de propiedades de este tipo. Y donde 'm' es el valor de lanzar el dado de nuevo");
		System.out.println("\t-Calles no adquiribles (neutrales): ");
		System.out.println("\t\t-Impuestos: Al caer tendras que pagar una cantidad fija");
		System.out.println("\t\t-Suerte: Al caer robaras una carta. Podra ser de saldo o de movimiento, modificando respectavamente dichos valores en el juego");
		System.out.println("\t\t-Visita/Carcel: Posiciones 10 y 30. En la 10 solo de visita si caes directamente. La 30 te retendra preso hasta que pagues o saques dobles (3 turnos)");
		System.out.println("\t\t-Parking Gratuito: Posicion 20. Al caer no tendras que pagar los alquileres a tus rivales (hasta pasar por la calle de salida)");
		System.out.println("\t\t-Salida: Cobras 200 por pasar");

		do{//while(!salir); //fin while
			System.out.println("\n----------------MENU---------------------\n");
			System.out.println("1) Monopoly 'Retro Gaming'");
			System.out.println("2) Monopoly 'Zombie Edition'");
			System.out.println("3) Monopoly 'Google'");
			System.out.println("4) Monopoly 'Juego de Tronos'");
			System.out.println("5) Modo Editor (Solo desarrolladores)");
			System.out.println("6) Salir");
			System.out.println();
			System.out.println("Indica una de estas opciones: ");

			int opc = Teclado.getMiTeclado().recogerInt();

			if (opc > 0 && opc < 9){
				FileReader f = null;
				if (opc == 1){
					System.out.println("\t\t---------------------------------");
					System.out.println("\t\t\tCargando tablero");
					System.out.println("\t\t---------------------------------\n");
					try { //abrir fichero
						f=new FileReader("monopolyGaming.txt");
					}catch (FileNotFoundException e1){
						System.out.println("No se ha encontrado el fichero que hace de tablero. Se volvera a lanzar una instancia del juego");
						System.out.println("------------------------------------------------------------------------------------------------");
						main(args);
					}	
					salir = JugarPartida.getMiJugarPartida().jugarMonopoly(f);

				}
				else if (opc == 2){
					System.out.println("Cargando tablero...\n");
					try { //abrir fichero
						f=new FileReader("zombopoly.txt");

					}catch (FileNotFoundException e1) {
						System.out.println("No se ha encontrado el fichero que hace de tablero. Se volvera a lanzar una instancia del juego");
						System.out.println("------------------------------------------------------------------------------------------------");
						main(args);
					}	
					salir = JugarPartida.getMiJugarPartida().jugarMonopoly(f);
				}
				else if (opc == 3){
					System.out.println("Cargando tablero... \n");
					try { //abrir fichero
						f=new FileReader("googolopoly.txt");

					}catch (FileNotFoundException e1) {
						System.out.println("No se ha encontrado el fichero que hace de tablero. Se volvera a lanzar una instancia del juego");
						System.out.println("------------------------------------------------------------------------------------------------");
						main(args);
					}	
					salir = JugarPartida.getMiJugarPartida().jugarMonopoly(f);
				}
				else if (opc == 4){
					System.out.println("Cargando tablero... \n");
					try { //abrir fichero
						f=new FileReader("tableroTronos.txt");

					}catch (FileNotFoundException e1) {
						System.out.println(e1.getMessage());
					}	
					CargarFicheros.getCargarFicheros().cargarFichero(f);
				}
				else if (opc == 5){
					System.out.println("Bienvenido al editor de mapas \n");
					System.out.println("Podras editar tu propio tablero de Monopoly. Comenzando desde la primera, fija las posiciones para las calles. Se establecen por defecto los siguientes valores");
					System.out.println("\t-La casilla de salida esta en la posicion 0");
					System.out.println("\t-La calle de carcel/visita esta en la posicion 10");
					System.out.println("\t-La calle de carcel esta en la posicion 30");
					int i=1;
					CalleSalida auxC = new CalleSalida("Salida", 0);
					CalleCarcel auxCarcel = new CalleCarcel("Carcel", 10);
					CalleCarcel auxCarcel2 = new CalleCarcel("Carcel", 30);
					Tablero.getMiTablero().anadirCasillaTablero(auxC);
					Tablero.getMiTablero().anadirCasillaTablero(auxCarcel);
					Tablero.getMiTablero().anadirCasillaTablero(auxCarcel2);

					while(i<40){
						if (i!= 10 && i!=30){
							System.out.println("Elige un tipo de calle: ");
							System.out.println("1) Calle de Impuestos");
							System.out.println("2) Calle de Suerte");
							System.out.println("3) Calle Parking Gratuito");
							System.out.println("4) Calle Servicios");
							System.out.println("5) Calle de tipo Propiedad");
							System.out.println("6) Calle de tipo Estacion");
							int opcTablero = Teclado.getMiTeclado().recogerInt();
							if (opcTablero == 1){
								System.out.println("Introduce un nombre para la calle");
								String nombreCalle = Teclado.getMiTeclado().recogerString();
								CalleImpuestos auxI = new CalleImpuestos(nombreCalle, i);
								Tablero.getMiTablero().anadirCasillaTablero(auxI);
							}
							else if(opcTablero == 2){
								System.out.println("Introduce un nombre para la calle");
								String nombreCalle = Teclado.getMiTeclado().recogerString();
								CalleCartas auxCar = new CalleCartas(nombreCalle, i);
								Tablero.getMiTablero().anadirCasillaTablero(auxCar);
								boolean salirBucle = false;
								while(ListaCartas.getMiListaCartas().cuantasCartas() < 10 && !salirBucle){
									System.out.println("Debe haber al menos 6 cartas");
									System.out.println("1) Carta Movimiento");
									System.out.println("2) Carta Saldo");
									System.out.println("3) Salir");
									int opcAux = Teclado.getMiTeclado().recogerInt();
									if (opcAux == 1){
										System.out.println("Indica una posicion a la que mover al jugador cuando se active la carta");
										int pos = Teclado.getMiTeclado().recogerInt(); 
										System.out.println("Escribe un pequeño enunciado que resuma la accion de la carta");
										String enun = Teclado.getMiTeclado().recogerString();
										CartaMovimiento auxCm = new CartaMovimiento(pos, enun);
										ListaCartas.getMiListaCartas().anadirCarta(auxCm);
										System.out.println("Actualmente hay :"+ListaCartas.getMiListaCartas().cuantasCartas());
									}
									else if (opcAux ==2 ){
										System.out.println("Indica una cantidad a sumar o restar sobre el saldo del jugador");
										int saldo = Teclado.getMiTeclado().recogerInt(); 
										System.out.println("Indica si el jugador cobrará o pagara esa cantidad. Escribe 'paga' o 'cobra', respectivamente");
										String pagaOcobra = Teclado.getMiTeclado().recogerString();
										System.out.println("Escribe un pequeño enunciado que resuma la accion de la carta");
										String enun = Teclado.getMiTeclado().recogerString();
										CartaSaldo auxcS = new CartaSaldo(saldo, pagaOcobra, enun);
										ListaCartas.getMiListaCartas().anadirCarta(auxcS);
										System.out.println("Actualmente hay :"+ListaCartas.getMiListaCartas().cuantasCartas());

									}
									else if (opcAux == 3){
										if (ListaCartas.getMiListaCartas().cuantasCartas()>=6){
											System.out.println("Saliendo...");
											salir = true;
										}
										else{
											System.out.println("Añade mas cartas. No hay suficientes");
										}
									}
									else{
										System.out.println("Opcion incorrecta");
									}
								}
							}
							else if (opcTablero==3){
								System.out.println("Indica un nombre para el Parking Gratuito");
								String nombre = Teclado.getMiTeclado().recogerString();
								CalleParking cP = new CalleParking(nombre, i);
								Tablero.getMiTablero().anadirCasillaTablero(cP);
							}
							else if (opcTablero==4){
								System.out.println("Indica un nombre para la Calle Servicios actual");
								String nombre = Teclado.getMiTeclado().recogerString();
								System.out.println("Indica un precio para esta propiedad");
								int precio = Teclado.getMiTeclado().recogerInt();
								CalleServicios cServ= new CalleServicios(nombre, i, precio);
								Tablero.getMiTablero().anadirCasillaTablero(cServ);
							}
							else if(opcTablero ==5){
								System.out.println("Indica un nombre para la Calle de tipo Propiedad actual");
								String nombre = Teclado.getMiTeclado().recogerString();
								System.out.println("Indica un precio para esta propiedad");
								int precio = Teclado.getMiTeclado().recogerInt();
								System.out.println("Indica un tipo que caracterice a esta propiedad");
								String tipo = Teclado.getMiTeclado().recogerString();
								System.out.println("Indica un precio de alquiler para la propiedad");
								int cobro = Teclado.getMiTeclado().recogerInt();
								CalleEstandar cE = new CalleEstandar(nombre, i, precio, tipo, cobro);
								Tablero.getMiTablero().anadirCasillaTablero(cE);
							}
							else if(opcTablero ==6){
								System.out.println("Indica un nombre para la Calle Estacion Actual");
								String nombre = Teclado.getMiTeclado().recogerString();
								System.out.println("Indica un precio para esta propiedad");
								int precio = Teclado.getMiTeclado().recogerInt();
								CalleEstaciones cEs = new CalleEstaciones(nombre, i, precio);
								Tablero.getMiTablero().anadirCasillaTablero(cEs);
							}
							else{
								System.out.println("Opcion incorrecta. Introduce un numero valido.");
							}
						}
						i++;
					}
				}
				else if (opc == 6) {
					salir = true;
					System.out.println("Saliendo... \n");
				}
			}

		}while(!salir);
	}
}
