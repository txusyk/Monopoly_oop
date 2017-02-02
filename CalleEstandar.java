package org.pmoo.monopoly;

public class CalleEstandar extends Calle {

	private int precio;
	private int cobro;
	private String tipo;
	private int casas = 1;
	private boolean enVenta=true;

	public CalleEstandar(String pNombre,int pPos,int pPrecio,String pTipo, int pCobro){ 
		super(pNombre,pPos);
		this.precio = pPrecio;
		this.cobro = pCobro;
		this.tipo = pTipo;
	}

	public int getPrecio(){
		return this.precio;
	}
	
	public String getTipo(){
		return this.tipo;
	}

	public void realizarOperacion(Jugador pJugador){
		System.out.println("Te encuentra en la posición "+this.getPosicion()+". Has caido en una calle de tipo: Propiedad.");
		System.out.println();System.out.print(this.getNombre()+". De tipo 'Propiedad'. En la posicion "+this.pos);
		if(!enVenta){
			Jugador jugDueno = ListaJugadores.getMiListaJugadores().buscarPropietarioDeCalle(Tablero.getMiTablero().buscarCallePorPos(pJugador.getPos()).getNombre());
			if( jugDueno.getNombre().equalsIgnoreCase(pJugador.getNombre())){
				System.out.println(" .Eres el dueño de la calle. No pagas alquiler.");
				System.out.println("Tienes: "+jugDueno.getLProp().obtenerNumeroCallesPorColor(this.tipo)+" calles de este color. ¿Deseas edificar?");
				System.out.println("El precio por edificar es de 50€ por casa. Lo que cobraras ahora sera: el precio de cobro inicial por el numero de casas que tengas en la propiedad");
				boolean siOno = Teclado.getMiTeclado().recogerSiOno();
				if (jugDueno.getLProp().obtenerNumeroCallesPorColor(this.tipo) == 3){
					if (this.casas <5 && siOno){
						jugDueno.modificarSaldo(50, "paga");
						this.casas++;
						System.out.println("Se ha añadido una nueva casa a la propiedad, actualmente tienes: "+this.casas);
					}
				}
				else if ((jugDueno.getLProp().obtenerNumeroCallesPorColor(this.tipo) == 2)){
					if (this.tipo.equalsIgnoreCase("VIOLETA") || this.tipo.equalsIgnoreCase("LILA")){
						if (this.casas <5 && siOno){
							jugDueno.modificarSaldo(50, "paga");
							this.casas++;
							System.out.println("Se ha añadido una nueva casa a la propiedad, actualmente tienes: "+this.casas);
						}
					}
					else{
						System.out.println("Debes tener todas las propiedades para poder edificar");
					}
				}
				else if (!siOno){
					System.out.println("Has decidido no edificar");
				}
				else{
					System.out.println("Debes tener todas las propiedades de un tipo para poder edificar sobre el");

				}
			}
			else{
				System.out.print(" .Esta calle pertenece a: "+jugDueno.getNombre()+". Debes pagarle: "+this.cobro+"€.");
				if (!pJugador.getSiParking()){
					pJugador.modificarSaldo(this.cobro*this.casas,"paga");
					jugDueno.modificarSaldo(this.cobro*this.casas,"cobra");
				}
				else{
					System.out.println(" Este turno tienes la habilidad de Parking Gratuito. No pagas el alquiler");
				}
			}
		}
		else{
			System.out.print(", no tiene dueño. Su precio es: "+this.precio+"€\n");
			System.out.println("¿Deseas comprar la propiedad?");
			boolean siOno = Teclado.getMiTeclado().recogerSiOno();
			if(siOno){
				pJugador.getLProp().anadirCalle(Tablero.getMiTablero().buscarCallePorPos(pJugador.getPos()));
				System.out.println("Has comprado la calle!!!");
				pJugador.modificarSaldo(this.precio, "paga");
				this.enVenta = false; 
			}
			else{
				System.out.println("No has comprado la calle");
			}
		}
	}

	public void liberarPropiedad(Jugador pJugador){
		if (!this.enVenta){
			if (pJugador.getLProp().buscarCallePorNombre(this.nombre) != null){
				this.enVenta = true;
			}
		}
	}

	public void setEnVenta(boolean pEnVenta){
		this.enVenta = pEnVenta;
	}

	public void imprimirInfoCalle(){
		System.out.print(this.getNombre()+", de color "+this.tipo+". De tipo 'Propiedad'. En la posicion "+this.pos+"\n");
	}
}
