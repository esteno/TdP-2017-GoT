package logica;

import mapa.*;
import nivel.Nivel;
import nivel.Niveles;
import objetos.*;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.ImageIcon;

import celdas.Celda;
import defensa.*;
import disparos.Disparo;
import disparos.DisparoDefensa;
import disparos.DisparoEnemigo;
import enemigos.Enemigo;
import gui.*;

import premio.PremioDanioDoble;
import premio.PremioCampoProtector;
import premio.PremioCuracion;;


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
	private PremioCampoProtector pc;
	private PremioDanioDoble pd;
	private PremioCuracion cu;
	
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
		gui.oroActual(puntaje.getOro());
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
		sigOleada();
	}
	
	//Genera la oleada para el control
	public void sigOleada() {
		controlDeOleadas.setOleada(nivelActual.getOleada());
	}
	
	
	
	//-----------AGREGAR
	//Agrega la defensa guardada en la fabrica en la pos x,y
	public void agregarDefensa(int x, int y)
	{
		
		mapa.agregarDefensa(FabricaDeDefensa.getInstancia().getDefensa(), x, y);
		controlDeDefensa.agregarDefensa(FabricaDeDefensa.getInstancia().getDefensa());
		FabricaDeDefensa.getInstancia().reset();
	}
	
	public void agregarDefensa(Defensa def, int x, int y)
	{
		
		mapa.agregarDefensa(def, x, y);
		controlDeDefensa.agregarDefensa(def);
	}

	//Agrega un objeto movil al mapa y graficamente si es posible
	/*	
	public Boolean agregarObjetoMovil(ObjetoMovil obj, int x, int y) 
	{
		Boolean puedoAgregar = mapa.agregarObjetoMovil(obj, x, y);
		if(puedoAgregar)
			gui.agregarObjetoMovil(x, y, obj);
		return puedoAgregar;
	}
	*/
	
	
	public boolean agregarEnemigo(Enemigo obj, int x, int y)
	{
		boolean puedoAgregar = mapa.agregarEnemigo(obj, x, y);
		if(puedoAgregar)
			gui.agregarObjetoMovil(x, y, obj);
		return puedoAgregar;
	}
	
	
	public boolean agregarDisparoDefensa(DisparoDefensa obj, int x, int y)
	{
		boolean puedoAgregar = mapa.agregarDisparoDefensa(obj, x, y);
		if(puedoAgregar)
			gui.agregarObjetoMovil(x, y, obj);
		return puedoAgregar;
	}
	
	public boolean agregarDisparoEnemigo(DisparoEnemigo obj, int x, int y)
	{
		boolean puedoAgregar = mapa.agregarDisparoEnemigo(obj, x, y);
		if(puedoAgregar)
			gui.agregarObjetoMovil(x, y, obj);
		return puedoAgregar;
	}
	
	
	
	//---------ELIMINAR
	//Elimina una defensa de mapa
	public void eliminarDefensa(int x,int y )
	{
	    Defensa defensa = mapa.eliminarDefensa(x,y);
	    controlDeDefensa.removerDefensa(defensa);
	}
	
	

	
	
	public void moverEnemigoGrafico(ObjetoMovil o)
	{
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
		gui.puntaje(puntaje.getPuntaje());
	}
	
	
	public int getAncho() {
		return ancho - 1;
	}
	
	//Genera un nuevo disparo en x,y
	public void generarDisparo(Disparo disparo, int x, int y) {
		controlDisparo.agregarDisparo(disparo, x, y);
	}

	
	public void sumarOro(int oro) {
		
		puntaje.sumarOro(oro);
		gui.oroActual(oro);
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
	
	//Retorna una matriz de celdas que representa el mapa
	public GameObjectGrafico[][] getCeldasGraficas()
	{
		return mapa.getGraficos();
	}
	
	// modificacion para Premios de tipo Magia Temporal
	public List<Defensa> getDefensas()
	{
		return controlDeDefensa.getListaDefensa();
	}
	
	public void agregarBomba() {
		System.out.println("agregue bomba");
		puntaje.agregarBomba();
	}
	
	public void restarBomba() {
		puntaje.restarBomba();
	}
	
	public boolean hayBombas() {
		return puntaje.hayBombas();
	}
	
	public void agregarMina() {
		puntaje.agregarMina();
	}
	
	public void restarMina() {
		puntaje.restarMina();
	}
	
	public boolean hayMinas() {
		return puntaje.hayMinas();
	}
	
	public void agregarBarricada() {
		puntaje.agregarBarricada();
	}
	
	public void restarBarricada() {
		puntaje.restarBarricada();
	}
	
	public boolean hayBarricadas() {
		return puntaje.hayBarricadas();
	}
}
