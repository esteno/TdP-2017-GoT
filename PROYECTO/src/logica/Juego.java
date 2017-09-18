package logica;

import mapa.*;
import objetos.*;
import objetos.GameObjectGrafico;
import celdas.Celda;
import defensa.*;
import enemigos.Enemigo;
import gui.*;


public class Juego {
	
	private Puntaje puntaje;
	private Mapa mapa;
	private Gui gui;
	
	private DefensaFactory fabricaDefensa;
	private FabricaDeOleadas fabricaDeOleadas;
	
	public Juego(Gui gui, int alto, int ancho) {
		this.gui = gui;
		puntaje = new Puntaje();
		mapa = new Mapa(alto, ancho);
		fabricaDeOleadas = new FabricaDeOleadas(this, ancho);
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
	
	public void agregarEnemigo(Enemigo enemigo, int pos) {
		Celda celda = mapa.agregarEnemigo(enemigo, pos);
		gui.agregarEnemigo(celda, enemigo.getGrafico());
	}
	
	public void crearEnemigo() {
		fabricaDeOleadas.generarEnemigo();
	}

}
