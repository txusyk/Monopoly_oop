package org.pmoo.monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ListaCalles {

	private ArrayList<Calle> listaC;

	public ListaCalles(){
		this.listaC = new ArrayList<Calle>();
	}

	private Iterator<Calle> getIterator(){
		return this.listaC.iterator();
	}

	/*
	 * Recibe un nombre de calle. Devuelve la calle o null en caso de no encontrarse.
	 */
	public Calle buscarCallePorNombre(String pNombreCalle){
		Iterator<Calle> itr = this.getIterator();
		Calle auxC = null;
		boolean enc = false;

		while (itr.hasNext() && !enc){
			auxC = itr.next();
			if (auxC.getNombre() == pNombreCalle){
				enc = true;
			}
		}
		if (!enc){
			auxC = null;
			//System.out.println("No existe la calle "+pNombreCalle);
		}
		return auxC;
	}

	/*
	 * Recibe una calle. Indica si esta o no.
	 */
	private boolean esta(Calle pCalle){
		Iterator<Calle> itr = this.getIterator();
		Calle auxC = null;
		boolean enc = false;

		while (itr.hasNext() && !enc){
			auxC = itr.next();
			if (auxC.getNombre() == pCalle.getNombre()){
				enc = true;
			}
		}
		return enc;
	}

	/*
	 * Añade la calle que se recibe como parametro siempre y cuando no exista previamente
	 */
	public void anadirCalle(Calle pCalle){
		if (!this.esta(pCalle)){
			this.listaC.add(pCalle);
		}
		else{
			System.out.println("La calle ya esta en esta lista");
		}
	}
	/*
	 * Eliminar la calle que se recibe como parametro. Si no existe se indica por pantalla.
	 */
	public void eliminarCalle(Calle pCalle){
		if (this.esta(pCalle)){
			System.out.println("Se ha eliminado: ");
			if (pCalle instanceof CalleEstandar){
				((CalleEstandar) pCalle).setEnVenta(false);
			}
			else if(pCalle instanceof CalleEstaciones){
				((CalleEstaciones) pCalle).setEnVenta(false);	
			}
			else if(pCalle instanceof CalleServicios){
				((CalleServicios) pCalle).setEnVenta(false);
			}	
			this.listaC.remove(pCalle);
			pCalle.imprimirInfoCalle();
		}
		else{
			System.out.println("La calle no esta en la lista");
		}
	}
	/*
	 * Indica el numero de Estaciones/Servicios que se poseen
	 */
	public int obtenerNumeroCallesPorTipo(String tipo){
		Calle auxC=null;
		Iterator<Calle> itr=this.getIterator();
		int numeroCallesEstacion=0;
		int numeroCallesServicios=0;
		int numeroTotal = 0;

		while(itr.hasNext()){
			auxC=itr.next();
			if(tipo.equalsIgnoreCase("Estacion")){
				if(auxC instanceof CalleEstaciones){
					numeroCallesEstacion++;
				}
			}
			else if(tipo.equalsIgnoreCase("Servicios")){
				if(auxC instanceof CalleServicios){
					numeroCallesServicios++;
				}
			}
		}
		if(tipo.equalsIgnoreCase("Estacion")){
			numeroTotal = numeroCallesEstacion;
		}
		else if (tipo.equalsIgnoreCase("Servicios")){
			numeroTotal = numeroCallesServicios;
		}
		return numeroTotal;
	} 
	
	public int obtenerNumeroCallesPorColor(String pColor){
		Calle auxC=null;
		Iterator<Calle> itr=this.getIterator();
		int numeroTotal = 0;
		while (itr.hasNext()){
			auxC = itr.next();
			if (auxC instanceof CalleEstandar){
				if (((CalleEstandar) auxC).getTipo().equalsIgnoreCase(pColor)){
					numeroTotal++;
				}
			}	
		}
		return numeroTotal;
	}
	
	public boolean esVacia(){
		return this.listaC.isEmpty();
	}


	/*
	 * Imprime todas las calles que forman la lista
	 */
	public Map<Integer,String> imprimirCalles(){
		Iterator <Calle> itr= this.getIterator();
		Calle auxC;
		int i=1;
		Map<Integer,String> lc = new HashMap<Integer,String>();
		System.out.println("----------------------------------------------------");
		while(itr.hasNext()){
			auxC=itr.next();
			System.out.print(i+") ");auxC.imprimirInfoCalle();System.out.println();
			lc.put(i,auxC.nombre);
			i++;
		}
		if (lc.isEmpty()){
			System.out.println("No hay ninguna calle");
		}
		System.out.println("----------------------------------------------------");
		return lc;
	}

	/*
	 * Cuando un jugador va a dejar la partida, previa a su salida. Sus propiedades
	 * vuelven a quedar a la venta, sin propietario.
	 */
	public void liberarPropiedadesDeJugador(Jugador pJugador){
		Iterator<Calle> itr = pJugador.getLProp().getIterator();
		Calle auxC;
		while(itr.hasNext()){
			auxC = itr.next();
			if (auxC instanceof CalleEstandar){
				((CalleEstandar) auxC).liberarPropiedad(pJugador);
			}
			else if(auxC instanceof CalleEstaciones){
				((CalleEstaciones) auxC).liberarPropiedad(pJugador);			
			}
			else if(auxC instanceof CalleServicios){
				((CalleServicios) auxC).liberarPropiedad(pJugador);
			}	
		}
	}

	/*
	 * Resetea la lista de calles
	 */
	public void resetear(){
		this.listaC.clear();
	}

}
