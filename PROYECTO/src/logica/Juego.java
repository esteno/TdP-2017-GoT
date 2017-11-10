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
import disparos.Disparo;
import enemigos.Enemigo;
import gui.*;


public class Juego
{
	//Objeto que mantiene el puntaje
	private Puntaje puntaje;
	//Objeto que mantiene el mapa
	private Mapa mapa;
	
	//Alto del juego
	private int alto;
	//Ancho del juego
	private int ancho;
	
	//GUI
	private Gui gui;
	
	//Instancia de controles
	private ControlDeOleadas controlDeOleadas;
	private ControlDisparo controlDisparo;
	private ControlDeDefensa controlDeDefensa;
	
	//Objeto que mantiene los nieveles del juego
	private Niveles niveles;
	//Numero de nivel actual
	private int numNivel;
	//Nivel actual
	private Nivel nivelActual;
	
	//Objeto que transforma un archivo de texto en una matriz de celdas
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
		new Thread(gui).start();
	}
	
	//Siguiente nivel basado en numNivel
	public void sigNivel() {
		nivelActual = niveles.getNivel(numNivel);
		numNivel++;
		mapa.cambiarMapa(parser.parsearNivel(nivelActual.getPath()));
		generarOleada();
	}
	
	//Genera la oleada para el control
	private void generarOleada() {
		controlDeOleadas.setOleada(nivelActual.getOleada());
	}
	
	//Agrega la defensa guardada en la fabrica en la pos x,y
	public void agregarDefensa(int x, int y)
	{
		
		mapa.agregarDefensa(FabricaDeDefensa.getInstancia().getDefensa(), x, y);
		controlDeDefensa.agregarDefensa(FabricaDeDefensa.getInstancia().getDefensa());
		FabricaDeDefensa.getInstancia().reset();
	}
	
	
	//Elimina una defensa de mapa
	public void eliminarDefensa(int x,int y )
	{
	    mapa.eliminarDefensa(x,y);  
	}
	
	
	//Retorna una matriz de celdas que representa el mapa
	public GameObjectGrafico[][] getCeldasGraficas()
	{
		return mapa.getGraficos();
	}
	
	//Agrega un objeto movil al mapa y graficamente si es posible
	public Boolean agregarObjetoMovil(ObjetoMovil obj, int x, int y) 
	{
		Boolean puedoAgregar = mapa.agregarObjetoMovil(obj, x, y);
		if(puedoAgregar)
			gui.agregarObjetoMovil(x, y, obj);
		return puedoAgregar;
	}
	
	public void moverEnemigoGrafico(ObjetoMovil o){
		gui.moverEnemigoGrafico(o);
	}
	
	//Eleimina graficamente un ObjetoMovil
	public void eliminarObjetoMovil(int x, int y)
	{
		gui.eliminarMovil(x, y);
	}
	
	//Suma un puntaje
	public void sumarPuntaje(int p) 
	{
		puntaje.sumarPuntaje(p);
		gui.puntaje(puntaje.puntaje());
	}
	
	
	public int getAncho() {
		return ancho - 1;
	}
	
	//Genera un nuevo disparo en x,y
	public void generarDisparo(Disparo disparo, int x, int y) {
		controlDisparo.agregarDisparo(disparo, x, y);
	}

	
	
	
	
	//Dibuja una defense en x,y
	public void dibujarDefensa(int x, int y, GameObject obj) {
		gui.dibujarDefensa(x, y, obj);
		
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
