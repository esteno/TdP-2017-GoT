package logica;

import mapa.*;
import nivel.Nivel;
import nivel.Niveles;
import objetos.*;
import objetos.GameObjectGrafico;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.ImageIcon;

import celdas.Celda;
import defensa.*;
import enemigos.Enemigo;
import gui.*;


public class Juego
{
	
	private Puntaje puntaje;
	private Mapa mapa;
	
	private int alto;
	private int ancho;
	
	private Gui gui;
	

	private ControlDeOleadas controlDeOleadas;
	private ControlDisparo controlDisparo;
	private ControlDeDefensa controlDeDefensa;
	
//	private Nivel miNivel;
	private Niveles niveles;
	private int numNivel;
	private Nivel nivelActual;
	private Parser parser;
	
	
	
	public Juego(Gui gui, int alto, int ancho) 
	{
		this.alto = alto;
		this.ancho = ancho;
		this.gui = gui;
		puntaje = new Puntaje();
		mapa = new Mapa(this, alto, ancho);
		niveles = new Niveles();
		
		parser = new Parser(mapa, alto, ancho);
		
		
		
		controlDeOleadas = new ControlDeOleadas(this, alto);
		controlDisparo = new ControlDisparo(this);
		controlDeDefensa = new ControlDeDefensa(this);
		
		numNivel = 1;
		sigNivel();
		
		new Thread(controlDeOleadas).start();
		new Thread(controlDisparo).start();
		new Thread(controlDeDefensa).start();
	}
	
	
	public void sigNivel() {
		nivelActual = niveles.getNivel(numNivel);
		numNivel++;
		mapa.cambiarMapa(parser.parsearNivel(nivelActual.getPath()));
		generarOleada();
	}
	
	public void generarOleada() {
		controlDeOleadas.setOleada(nivelActual.getOleada());
	}
	
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
	

	public void agregarObjetoMovil(ObjetoMovil obj, int x, int y) 
	{
		mapa.agregarObjetoMovil(obj, x, y);
		gui.agregarObjetoMovil(x, y, obj.getGrafico());
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


	public void dibujarDefensa(int x, int y, ImageIcon imageIcon) {
		gui.dibujarDefensa(x, y, imageIcon);
		
	}


	public void crearMuro() {
		mapa.crearMuro();
		
	}
	
	public void gameOver() {
		gui.gameOver();
		
	}
	
	
	
	// modificacion para Premios de tipo Magia Temporal
	public List<Defensa> getDefensas()
	{
		return controlDeDefensa.getListaDefensa();
	}
	
}
