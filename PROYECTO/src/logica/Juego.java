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
	
	private DefensaFactory fabricaDefensa; 
	
	public Juego(int alto, int ancho) {
		puntaje = new Puntaje();
		mapa = new Mapa(alto, ancho);
		fabricaDefensa = new DefensaFactory();
	}
	
	public Defensa construirDefensa() {
		return fabricaDefensa.construirDefensa();
	}
	
	public GameObjectGrafico[][] getCeldasGraficas() {
		return mapa.getGraficos();
	}
	
	public void agregarJugador()
	{
	      //mapa.getGraficos()
	}

}
