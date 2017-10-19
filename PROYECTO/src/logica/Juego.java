package logica;

import mapa.*;
import objetos.*;
import objetos.GameObjectGrafico;
import celdas.Celda;
import defensa.*;
import gui.*;


public class Juego implements Runnable 
{
	
	private Puntaje puntaje;
	private Mapa mapa;
	
	private int alto;
	private int ancho;
	
	private Gui gui;
	

	private ControlDeOleadas controlDeOleadas;
	private ControlDisparo controlDisparo;
	private ControlDeDefensa controlDeDefensa;
	
	public Juego(Gui gui, int alto, int ancho) 
	{
		this.alto = alto;
		this.ancho = ancho;
		this.gui = gui;
		puntaje = new Puntaje();
		mapa = new Mapa(this, alto, ancho);
		controlDeOleadas = new ControlDeOleadas(this, new FabricaDeOleadas(), alto);
		controlDisparo = new ControlDisparo(this);
		controlDeDefensa = new ControlDeDefensa(this);
		
		new Thread(controlDeOleadas).start();
		new Thread(controlDisparo).start();
		new Thread(controlDeDefensa).start();
	}
	
	
	public void run() 
	{         }
	
	
	
	public void agregarDefensa(int x, int y)
	{
		
		mapa.agregarDefensa(FabricaDeDefensa.getInstancia().getDefensa(), x, y);
		controlDeDefensa.agregarDefensa(FabricaDeDefensa.getInstancia().getDefensa());
		FabricaDeDefensa.getInstancia().reset();
	}
	
	
	
	public void eliminarDefensa(int x,int y )
	{
	    mapa.eliminarDefensa(x,y);  
	}
	
	
	
	
	public GameObjectGrafico[][] getCeldasGraficas()
	{
		return mapa.getGraficos();
	}
	
	
	public void agregarJugador()
	{
	      //mapa.getGraficos()
	}
	
	public void agregarEnemigo(ObjetoMovil enemigo, int x, int y) 
	{
		mapa.agregarEnemigo(enemigo, x, y);
		gui.agregarEnemigo(x, y, enemigo.getGrafico());
	}
	
	
	public void crearEnemigo() 
	{
		System.out.println("JUEGO fabricaDeOleadas.generarEnemigo()");
		controlDeOleadas.generarEnemigo();
	}
	
	public void moverEnemigoGrafico(int xAnterior, int yAnterior, int xNuevo, int yNuevo)
	{
		gui.moverEnemigoGrafico(xAnterior, yAnterior, xNuevo, yNuevo);
	}
	
	
	public void eliminarEnemigo(int x, int y)
	{
		gui.eliminarMovil(x, y);
	}
	
	public void sumarPuntaje(int p) 
	{
		morirLogico(p);
		gui.puntaje(puntaje.puntaje());
	}
	
   
	
	private void morirLogico(int puntos)
    {	
	   puntaje.sumarPuntaje(puntos);
	   //puntaje.sumarOro(o);
    }
	
	public int getAncho() {
		return ancho - 1;
	}
	
	public void generarDisparo(int x, int y) {
		controlDisparo.agregarDisparo(x, y);
	}
	
}
