package logica;

import mapa.*;
import nivel.Nivel;
import nivel.Niveles;
import objetos.*;

import java.util.List;

import javax.swing.JLabel;

import defensa.*;
import disparos.Disparo;
import enemigos.Enemigo;
import gui.*;
import premio.PremioDanioDoble;
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
	
	private boolean bombaCreada;
	
	private Premios premios;
	
	//Objeto que transforma un archivo de texto en una matriz de celdas
	private Parser parser;
	
	private PremioDanioDoble b;
	
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
		controlDisparo = new ControlDisparo(this);
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
		if (nivelActual == null)
			gui.ganar();
		else {
			numNivel++;
			mapa.cambiarMapa(parser.parsearNivel(nivelActual.getPath()));
			sigOleada();
		}
	}
	
	//Genera la oleada para el control
	public void sigOleada() {
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
	
	public void agregarDefensa(Defensa def, int x, int y){
		mapa.agregarDefensa(def, x, y);
		controlDeDefensa.agregarDefensa(def);
	}

	public boolean agregarEnemigo(Enemigo obj, int x, int y){
		boolean puedoAgregar = mapa.agregarEnemigo(obj, x, y);
		if(puedoAgregar)
			gui.agregarObjetoMovil(x, y, obj);
		return puedoAgregar;
	}
	
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
		gui.gameOver();
	}
	
	//Retorna una matriz de celdas que representa el mapa
	public GameObjectGrafico[][] getCeldasGraficas(){
		return mapa.getGraficos();
	}
	
	// modificacion para Premios de tipo Magia Temporal
	public List<Defensa> getDefensas(){
		return controlDeDefensa.getListaDefensa();
	}
	
	public void agregarBomba() {
		puntaje.agregarBomba();
	}
	
	public void restarBomba() {
		bombaCreada=true;
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
	
	public boolean hayBarricadas() {
		return puntaje.hayBarricadas();
	}
	
	public void crearPremio(int x, int y) {
		premios.crearPremio(x, y);
	}
	
	public void crearBomba(int x, int y, JLabel nuevo) {
		new Bomba(x,y,mapa,this,nuevo);
		
	}
	
	public void eliminarLabelPremio(JLabel label) {
		gui.eliminarLabelPremio(label);
	}
	
	public boolean seCreoBomba() {
		return bombaCreada;
		
	}

	public void agregarPremioBomba(int x, int y) {
		gui.agregarPremioBomba(x, y);
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
		System.out.println("Juego DD");
		new PremioDanioDoble(this);
	}

	public void modificarDefensa(EstadoMultiplicador estado) {
		System.out.println("juego modificarDefensa");
		controlDeDefensa.modificarEstado(estado);
	}
	
	public void curar() {
		controlDeDefensa.curar();
	}

	public boolean crearCampo(int x, int y) {
		Defensa d=mapa.getEstatico(x, y);
		if(d!=null)
			new PremioCampoProtector(d);
		return (d!=null);
	}


}