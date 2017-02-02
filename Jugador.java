package org.pmoo.monopoly;

import java.util.Map;

public class Jugador {

	private String nombre;
	private int id;
	private ListaCalles lProp = new ListaCalles();
	private int pos = 0;
	private int dineroTotal = 5000;
	private boolean esParking = false;
	private boolean estaBancarrota = false;

	public Jugador(String pNombre, int pId){
		this.nombre = pNombre;
		this.id = pId;
	}

	public String getNombre(){
		return this.nombre;
	}

	public int getId(){
		return this.id;
	}

	public ListaCalles getLProp(){
		return this.lProp;
	}

	public int getPos(){
		return this.pos;
	}

	public int getSaldo(){
		return this.dineroTotal;
	}

	public boolean getSiParking(){
		return this.esParking;
	}

	public void setSiParking(boolean pSiParking){
		this.esParking = pSiParking;
	}

	public boolean esBancarrota(){
		return this.estaBancarrota;
	}

	/*
	 * Ajusta el ID del jugador actual para que cuadre al eliminar a otro jugador
	 * anterior a el en la lista
	 */
	public void ajustarId(){
		this.id--;
	}

	/* Pre: Recibe la posicion final (posEsta+dado)
	 * Actualiza la posicion del jugador. En caso de pasar de la ultima casilla
	 * realiza las operaciones de paso por salida
	 */
	public void actualizarPosicion(int pPosicion){
		if ((pPosicion)>39){
			this.pos = pPosicion-40;
			this.esParking = false;
			this.dineroTotal+=200;
			System.out.println("Has pasado por la casilla de salida. Cobras 200€ y en caso de que fueras Parking Gratuito, pierdes esa habilidad.");
		}
		else{
			this.pos = pPosicion;
		}
	}
	
	/*
	 * Mueve al jugador a una posicion determinada
	 */
	public void moverJugador(int pPos){
		this.pos = pPos;	
	}

	/*
	 * Cobra o paga  en base al parametro que recibe. En caso de no tener dinero suficiente
	 * llamara al metodo hipotecar
	 */
	public void modificarSaldo(int pDinero,String pPagaOcobra){
		if (pPagaOcobra == "paga"){
			while((this.dineroTotal-pDinero)<0 && !this.estaBancarrota){
				System.out.println(this.getNombre()+": No puedes quedarte en negativo");
				System.out.println("No tienes dinero suficiente para pagar");
				this.hipotecar();
			}
			if((this.dineroTotal-pDinero)>0){
				this.dineroTotal = this.dineroTotal-pDinero;
				System.out.println("Saldo total de "+this.getNombre()+": "+this.dineroTotal+"€");
			}
		}
		else if (pPagaOcobra == "cobra"){
			this.dineroTotal = this.dineroTotal+pDinero;
			System.out.println("Saldo total de "+this.getNombre()+": "+this.dineroTotal+"€");
		}
	}

	/*
	 * Realiza todas las operaciones pertinentes al turno del jugador acctual
	 */
	public void jugarTurno(){
		System.out.println();
		System.out.println("............................................");
		System.out.println("\t-----ES TURNO DE: "+this.nombre+"------");
		System.out.println("............................................");
		System.out.println();

		System.out.println(this.getNombre()+": Estas en la posicion: "+this.pos+". Tienes: "+this.getSaldo()+"€.\n");

		System.out.println("Elige una de las siguientes opciones: ");
		System.out.println("\t1) Tirar Dados");
		System.out.println("\t2) Mostar las propiedades actuales");
		System.out.println("\t3) Hipotecar propiedades");

		int opc = Teclado.getMiTeclado().recogerInt();

		while (opc!=1){
			if (opc == 2){
				this.getLProp().imprimirCalles();
				System.out.println("Elige una de las siguientes opciones: ");
				System.out.println("\t1) Tirar Dados");
				System.out.println("\t2) Mostar las propiedades actuales");
				System.out.println("\t3) Hipotecar propiedades");
				opc = Teclado.getMiTeclado().recogerInt();
			}
			else if (opc == 3){
				this.hipotecar();
				System.out.println("Elige una de las siguientes opciones: ");
				System.out.println("\t1) Tirar Dados");
				System.out.println("\t2) Mostar las propiedades actuales");
				System.out.println("\t3) Hipotecar propiedades");
				opc = Teclado.getMiTeclado().recogerInt();
			}
		}
		if (Condena.getMiCondena().esta(this)){
			Calle auxC = Tablero.getMiTablero().buscarCallePorPos(10);
			auxC.realizarOperacion(this);
		}
		else{
			int resulDado = Dado.getMiDado().obtenerDados();
			this.actualizarPosicion(this.getPos()+resulDado);
			Calle auxC = Tablero.getMiTablero().buscarCallePorPos(this.getPos());
			auxC.realizarOperacion(this);
			if (Dado.getMiDado().getSiEsDobles()){
				if(Dado.getMiDado().getNumDobles() < 3){
					System.out.println("\nVuelves a tirar. Llevas : "+Dado.getMiDado().getNumDobles()+" tiradas seguidas sacando dobles");
					this.jugarTurno();
					/*resulDado = Dado.getMiDado().obtenerDados();
					this.actualizarPosicion(this.getPos()+resulDado);
					auxC = Tablero.getMiTablero().buscarCallePorPos(this.getPos());
					auxC.realizarOperacion(this);*/
				}
				else{
					System.out.println("\nHas tirado 3 veces seguidas dobles. Seras enviado a la carcel");
					this.actualizarPosicion(30);
					Tablero.getMiTablero().buscarCallePorPos(30).realizarOperacion(this);
				}
				/*if (Dado.getMiDado().getSiEsDobles() && Dado.getMiDado().getNumDobles() == 3){
					System.out.println("\nHas tirado 3 veces seguidas dobles. Seras enviado a la carcel");
					this.actualizarPosicion(30);
					Tablero.getMiTablero().buscarCallePorPos(30).realizarOperacion(this);*/
				
			}
		}	
	}

	/*
	 * En caso de no tener suficiente dinero para pagar. Ofrece la posibilidad de 
	 * hipotecar propiedades (se imprime una lista de las suyas) para poder continuar
	 * jugando. En caso de que rechace la opcion. Se le declara en bancarrota.
	 */
	public void hipotecar(){
		System.out.println("¿Quieres hipotecar alguna propiedad para conseguir dinero?(SI/NO)");
		boolean siOno = Teclado.getMiTeclado().recogerSiOno();
		if(siOno){
			System.out.println("Estas son tus propiedades:");
			Map<Integer,String> lc = this.getLProp().imprimirCalles();
			if (this.getLProp().esVacia()){
				System.out.println("No se puede hipotecar. No tienes calles en propiedad\n");
			}
			else{
				System.out.println("Selecciona la calle que quieras hipotecar (Introduce el numero entre las opciones):");
				int auxI = Teclado.getMiTeclado().recogerInt();
				Calle auxC=this.getLProp().buscarCallePorNombre(lc.get(auxI));
				if (auxC instanceof CalleEstandar){
					this.dineroTotal += ((CalleEstandar) auxC).getPrecio();
				}
				if (auxC instanceof CalleEstaciones){
					this.dineroTotal += ((CalleEstaciones) auxC).getPrecio();
				}
				if (auxC instanceof CalleServicios){
					this.dineroTotal += ((CalleServicios) auxC).getPrecio();
				}
				this.getLProp().eliminarCalle(auxC);
			}
		}
		else if(!siOno && this.dineroTotal<=0){
			this.estaBancarrota = true;
			System.out.println("El jugador: "+this.getNombre()+". Ha sido declarado en bancarrota");
		}
	}

	/*
	 * Imprimir la informacion del jugador por pantalla
	 */
	public void imprimirInfo(){
		System.out.println("ID: "+this.id+". Nombre: "+this.nombre+". Su saldo es: "+this.dineroTotal+". Y se encuentra en la posicion :"+this.pos);
	}
}

