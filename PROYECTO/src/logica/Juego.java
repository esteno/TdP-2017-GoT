package logica;

import mapa.*;
import objetos.*;
import objetos.GameObjectGrafico;
import celdas.Celda;
import defensa.*;
import enemigos.Enemigo;
import gui.*;


public class Juego implements Runnable {
	
	private Puntaje puntaje;
	private Mapa mapa;
	
	private Gui gui;
	
	private DefensaFactory fabricaDefensa;
	private FabricaDeOleadas fabricaDeOleadas;
	
	private Defensa rt;
	
	public Juego(Gui gui, int alto, int ancho)  {
		this.gui = gui;
		puntaje = new Puntaje();
		mapa = new Mapa(this, alto, ancho);
		fabricaDeOleadas = new FabricaDeOleadas(this, alto);
		fabricaDefensa = new DefensaFactory();
	}
	
	public void run() {}
	
	public Defensa construirDefensa() 
	{
		rt=fabricaDefensa.construirDefensa();
		return  rt;
	}
	
	public void eliminarDefensa(int x,int y )
	{
	   
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
		new Thread(enemigo).start();
	}
	
	public void crearEnemigo() {
		fabricaDeOleadas.generarEnemigo();
	}
	
	public void moverEnemigoGrafico(int xAnterior, int yAnterior, int xNuevo, int yNuevo) {
		gui.moverEnemigoGrafico(xAnterior, yAnterior, xNuevo, yNuevo);
	}
	
	

}
