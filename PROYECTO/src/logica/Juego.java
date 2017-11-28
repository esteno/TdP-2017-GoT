package logica;

import mapa.*;
import nivel.Nivel;
import nivel.Niveles;
import objetos.*;

import javax.swing.JLabel;

import defensa.*;
import disparos.Disparo;
import enemigos.Enemigo;
import gui.*;
import estadoMultiplicador.*;

import premio.*;


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
	private Ventana gui;
	
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
	
	
	private Premios premios;
	
	//Objeto que transforma un archivo de texto en una matriz de celdas
	private Parser parser;

	
	public Juego(Ventana ventana, int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		this.gui = ventana;
		puntaje = new Puntaje();
		ventana.oroActual(puntaje.getOro());
		mapa = new Mapa(this, alto, ancho);
		niveles = new Niveles();
		parser = new Parser(mapa, alto, ancho);
		premios = new Premios(this);
		
		controlDeOleadas = new ControlDeOleadas(this, alto);
		controlDisparo = new ControlDisparo();
		controlDeDefensa = new ControlDeDefensa(this);
		
		numNivel = 1;
		sigNivel();
		
		new Thread(controlDeOleadas).start();
		new Thread(controlDisparo).start();
		new Thread(controlDeDefensa).start();
		new Thread(ventana).start();
	}
	
	//Siguiente nivel basado en numNivel
	public void sigNivel() {
		nivelActual = niveles.getNivel(numNivel);
		ConsolaMensajes.mostrarMensaje(" NIVEL: "+numNivel);
		if (nivelActual == null)
			gui.ganar();
		else 
		{
			numNivel++;

			mapa.cambiarMapa(parser.parsearNivel(nivelActual.getPath()));
			gui.dibujarMapa(mapa.getGraficos());
			sigOleada();
		}
	}
	
	//Genera la oleada para el control
	public void sigOleada() {
		ConsolaMensajes.mostrarMensaje("Nueva Oleada!");
		controlDeOleadas.setOleada(nivelActual.getOleada());
	}
	
	//-----------AGREGAR
	//Agrega la defensa guardada en la fabrica en la pos x,y
	public void agregarDefensa(int x, int y){
		
		Boolean pudeAgregar = mapa.agregarDefensa(FabricaDeDefensa.getInstancia().getDefensa(), x, y);
		if(pudeAgregar) {
			Defensa defensa = FabricaDeDefensa.getInstancia().getDefensa();
			controlDeDefensa.agregarDefensa(defensa);
			FabricaDeDefensa.getInstancia().reset();
			gui.dibujarDefensa(x, y, defensa);
		}
	}
	
	// Agrega una defensa determinada en una posicion pasada por parametro en el mapa y en el control de la defensa
	public void agregarDefensa(Defensa def, int x, int y){
		mapa.agregarDefensa(def, x, y);
		controlDeDefensa.agregarDefensa(def);
	}

	// Agrega un enemigo en una posicion pasada por parametro en el mapa y graficamente
	public boolean agregarEnemigo(Enemigo obj, int x, int y){
		boolean puedoAgregar = mapa.agregarEnemigo(obj, x, y);
		if(puedoAgregar)
			gui.agregarObjetoMovil(x, y, obj);	
		return puedoAgregar;
	}
	
	// Reemplaza un enemigo en una posicion determinada por otro pasado por parametro
	public void reemplazarEnemigo(Enemigo enemigo, int x, int y) {
	
		mapa.reemplazarEnemigo(enemigo, x, y);
	}
	
	// Agrega un disparo pasado por parametro en una posicion especifica
	public void agregarDisparo(Disparo disparo, int x, int y) {
		controlDisparo.agregarDisparo(disparo);
		gui.agregarObjetoMovil(x, y, disparo);
	}
	
	//---------ELIMINAR
	//Elimina una defensa de mapa
	public void eliminarDefensa(int x,int y ){
	    Defensa defensa = mapa.eliminarDefensa(x,y);
	    controlDeDefensa.removerDefensa(defensa);
	}
	
	public void moverGrafico(ObjetoMovil o){
		gui.moverGrafico(o,false);
	}
	
	//Suma un puntaje
	public void sumarPuntaje(int p) {
		puntaje.sumarPuntaje(p);
		gui.puntaje(puntaje.getPuntaje());
	}
	
	public int getAncho() {
		return ancho - 1;
	}

	public void sumarOro(int oro) {
		puntaje.sumarOro(oro);
		gui.oroActual(puntaje.getOro());
	}
	
	public void restarOro(int oro) {
		puntaje.restarOro(oro);
		gui.oroActual(puntaje.getOro());
		
	}
	
	//Dibuja una defense en x,y
	public void dibujarDefensa(int x, int y, GameObject obj) {
		gui.dibujarDefensa(x, y, obj);
	}

	public void gameOver() {
		ConsolaMensajes.mostrarMensaje("GAME OVER");
		gui.gameOver();
	}
	
	//Retorna una matriz de celdas que representa el mapa
	public GameObjectGrafico[][] getCeldasGraficas(){
		return mapa.getGraficos();
	}
	
	public void agregarBomba() {
		puntaje.agregarBomba();
	}
	
	public void restarBomba() {
		puntaje.restarBomba();
	}
	
	public boolean hayBombas() {
		return puntaje.hayBombas();
	}
	
	public boolean hayBarricada() {
		return puntaje.hayBarricadas();
	}
	
	public void agregarBarricada() {
		puntaje.agregarBarricada();
	}
	
	public void restarBarricada() {
		puntaje.restarBarricada();
	}
	
	public void crearPremio(int x, int y) {
		premios.crearPremio(x, y);
	}
	
	public void crearBomba(int x, int y, JLabel nuevo) {
		ConsolaMensajes.mostrarMensaje("TIC TOC");
		new Bomba(x,y,mapa,this,nuevo);
		
	}
	
	public void eliminarLabelPremio(JLabel label) {
		gui.eliminarLabelPremio(label);
	}

	public void agregarPremioBomba(int x, int y) {
		gui.agregarPremioBomba(x, y);
	}

	public void agregarPremioBarricada(int x, int y) {
		gui.agregarPremioBarricada(x, y);
	}

	public void agregarPremioOro(int x, int y) {
		gui.agregarPremioOro(x, y);
	}

	public void agregarPremioCuracion(int x, int y) {
		gui.agregarPremioCuracion(x, y);
	}

	public void agregarPremioDanioDoble(int x, int y) {
		gui.agregarPremioDanioDoble(x, y);
	}
	public void agregarPremioCampoProtector(int x, int y) {
		gui.agregarPremioCampoProtector(x, y);
	}

	public void curarDefensas() {
		new PremioCuracion(this);
	}

	public void danioDoble() {
		ConsolaMensajes.mostrarMensaje("Daño doble!");
		new PremioDanioDoble(this);
	}

	public void modificarDefensa(EstadoMultiplicador estado) {
		controlDeDefensa.modificarEstado(estado);
	}
	
	public void curar() {
		controlDeDefensa.curar();
	}

	// Crea un campo protector sobre una defensa en una posicion pasada por parametro
	public boolean crearCampo(int x, int y) {
		ConsolaMensajes.mostrarMensaje("Campo protector!");
		Defensa d=mapa.getEstatico(x, y);
		if(d!=null) 
			new PremioCampoProtector(d,this);
		return (d!=null);
	}

	public void reemplazarDefensa(Defensa personaje, int x, int y) {

		mapa.reemplazarDefensa(personaje,x,y);
		
	}

	public void eliminarEnemigo(Enemigo enemigo) {
		controlDeOleadas.eliminarEnemigo(enemigo);
		
	}
	
	public void insertarEnemigo(Enemigo enemigo) {
		controlDeOleadas.insertarEnemigo(enemigo);
	}
}