package logica;

import mapa.*;
import objetos.*;
import objetos.GameObjectGrafico;
import gui.*;


public class Juego {
	
	private Puntaje puntaje;
	private Mapa mapa;
	private gui gui;
	private GameObject j;
	
	public Juego(int alto, int ancho) {
		puntaje = new Puntaje();
		mapa = new Mapa(alto, ancho);
	}
	
	public GameObjectGrafico[][] getCeldasGraficas() {
		return mapa.getGraficos();
	}
	
	public void agregarJugador()
	{
		
	}

}
