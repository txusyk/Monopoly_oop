package org.pmoo.monopoly;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaJugadores {

	private ArrayList<Jugador> lJugadores;
	private static ListaJugadores miListaJugadores;

	private ListaJugadores(){
		this.lJugadores = new ArrayList<Jugador>();
	}

	public static ListaJugadores getMiListaJugadores(){
		if (miListaJugadores == null){
			miListaJugadores = new ListaJugadores();
		}
		return miListaJugadores;
	}

	private Iterator<Jugador> getIterator(){
		return this.lJugadores.iterator();
	}

	/*
	 * Devuelve un booleano que indica si el jugador se encuentra añadido
	 */
	private boolean esta(Jugador pJugador){
		Iterator<Jugador> itr = this.getIterator();
		Jugador auxJug;
		boolean enc = false;
		while (itr.hasNext() && !enc){
			auxJug = itr.next();
			if (auxJug.getNombre() == pJugador.getNombre()){
				enc = true;
			}
		}
		return enc;
	}

	/*
	 * En caso de no estar ya añadido. Añade el jugador que se recibe como parametro.
	 */
	public void anadirJugador(Jugador pJugador){
		if (this.esta(pJugador)){
			System.out.println("El jugador"+pJugador.getNombre()+" ya se encuentra añadido");
		}
		else{
			this.lJugadores.add(pJugador);
		}
	}

	/*
	 * Comprueba si existe el jugador que se recibe como parametro. Si existe lo elimina.
	 */
	public void eliminarJugador(Jugador pJugador){
		if (this.esta(pJugador)){
			pJugador.getLProp().liberarPropiedadesDeJugador(pJugador);
			this.lJugadores.remove(pJugador);
		}
		else{
			System.out.println("El jugador "+pJugador.getNombre()+" no existe");
		}
	}
	
	/*
	 * Devuelve el tamaño de la lista de Jugadores
	 */
	public int getTamano(){
		return this.lJugadores.size();
	}
	
	/*
	 * Devuelve al jugador cuyo ID se recibe (si existe). En caso contrario devuelve null.
	 */
	public Jugador buscarJugadorPorId(int pId){
		Iterator<Jugador> itr = this.getIterator();
		Jugador auxJug = null;
		boolean enc = false;
		while(itr.hasNext() && !enc){
			auxJug = itr.next();
			if (auxJug.getId() == pId){
				enc = true;
			}
		}
		if(!enc){
			auxJug = null;
		}
		return auxJug;
	}
	
	/*
	 * Se recibe un nombre de calle. En caso de que no este en venta, devuelve a su propietario.
	 */
	public Jugador buscarPropietarioDeCalle(String pNombreCalle){
		Iterator<Jugador> itr = this.getIterator();
		Jugador auxJug = null;
		boolean enc = false;
		while (itr.hasNext() && !enc){
			auxJug = itr.next();
			if (auxJug.getLProp().buscarCallePorNombre(pNombreCalle) != null){
				enc = true;
			}
		}
		if(!enc){
			auxJug = null;
			System.out.println("No se ha encontrado la calle.");
		}
		return auxJug;
	}
	
	public void modificarIdJugadores(int pId){
		Iterator<Jugador> itr = this.getIterator();
		Jugador auxJug = null;
		while(itr.hasNext()){
			auxJug = itr.next();
			if(auxJug.getId()>pId){
				auxJug.ajustarId();
			}
		}
	}
	
	/*
	 * Eliminamos la lista de jugadores
	 */
	public void resetear(){
		this.lJugadores.clear();
	}
}