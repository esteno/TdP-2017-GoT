package logica;

import mapa.*;
import objetos.*;
import objetos.GameObjectGrafico;
import defensa.*;
import gui.*;


public class Juego {
	
	private Puntaje puntaje;
	private Mapa mapa;
	private gui gui;
	private DefensaCuerpo j; // jugador
	
	public Juego(int alto, int ancho) {
		puntaje = new Puntaje();
		mapa = new Mapa(alto, ancho);
	}
	
	public GameObjectGrafico[][] getCeldasGraficas() {
		return mapa.getGraficos();
	}
	
	public void agregarJugador()
	{
	      //mapa.getGraficos()
	}

}
