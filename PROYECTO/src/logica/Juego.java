package logica;

import mapa.*;
import objetos.GameObjectGrafico;

public class Juego {
	
	private Puntaje puntaje;
	private Mapa mapa;
	
	public Juego(int alto, int ancho) {
		puntaje = new Puntaje();
		mapa = new Mapa(alto, ancho);
	}
	
	public GameObjectGrafico[][] getCeldasGraficas() {
		return mapa.getGraficos();
	}
	

}
