package logica;

import mapa.*;
import objetos.*;
import objetos.GameObjectGrafico;
import celdas.Celda;
import defensa.*;
import enemigos.Enemigo;
import gui.*;


public class Juego implements Runnable 
{
	
	private Puntaje puntaje;
	private Mapa mapa;
	
	private GuiNueva gui;
	

	private ControlDeOleadas controlDeOleadas;
	
	public Juego(GuiNueva gui, int alto, int ancho) 
	{
		this.gui = gui;
		puntaje = new Puntaje();
		mapa = new Mapa(this, alto, ancho);
		controlDeOleadas = new ControlDeOleadas(this, new FabricaDeOleadas(), alto);
		
		new Thread(controlDeOleadas).start();
	}
	
	
	public void run() 
	{         }
	
	
	
	public void agregarDefensa(int x, int y)
	{
		mapa.agregarDefensa(x,y);
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
	
	public void agregarEnemigo(Enemigo enemigo, int pos) 
	{
		Celda celda = mapa.agregarEnemigo(enemigo, pos);
		gui.agregarEnemigo(celda.getX(), celda.getY(), enemigo.getGrafico());
	}
	
	
	public void crearEnemigo() 
	{
		System.out.println("JUEGO fabricaDeOleadas.generarEnemigo()");
		controlDeOleadas.generarEnemigo();
	}
	
	public void moverEnemigoGrafico(int xAnterior, int yAnterior, int xNuevo, int yNuevo)
	{
		//gui.moverEnemigoGrafico(xAnterior, yAnterior, xNuevo, yNuevo);
	}
	
	
	public void eliminarEnemigo(int x, int y)
	{
		//gui.eliminarEnemigo(x, y);
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
	
}
