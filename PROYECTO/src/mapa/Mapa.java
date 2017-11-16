package mapa;

import java.util.ArrayList;
import java.util.List;

import ObjetoDeMapa.ObjetoDeMapa;
import celdas.Celda;
import defensa.*;
import disparos.Disparo;
import disparos.DisparoEnemigo;
import disparos.DisparoDefensa;
import enemigos.Enemigo;
import logica.FabricaDeDefensa;
import logica.Juego;
import objetos.*;
import premio.*;

public class Mapa 
{ 
	//Matriz que va a contener las celdas que conforman el mapa.
	private Celda[][] matrizCeldas;
	
	private ObjetoDeMapa[][] matrizDeObjetoDeMapa;
	
	//Matriz que tiene todo lo que son defensas del jugador y obstaculos
	private Defensa[][] matrizDefensa;
	
	private Enemigo [][] matrizEnemigo;
	
	private DisparoDefensa [][] matrizDisparoDefensa;
	
	private DisparoEnemigo [][] matrizDisparoEnemigo;
	
	
	
	private Juego juego;
	private FabricaDeDefensa fabricaDeDefensa = FabricaDeDefensa.getInstancia();
	
	
	
	public Mapa(Juego juego, int alto, int ancho)
	{
		matrizCeldas = new Celda[ancho][alto];
		matrizDeObjetoDeMapa = new ObjetoDeMapa[ancho][alto];
		matrizDefensa = new Defensa[ancho][alto];
		matrizEnemigo = new Enemigo[ancho][alto];
		matrizDisparoEnemigo = new DisparoEnemigo [ancho][alto];
		matrizDisparoDefensa = new DisparoDefensa[ancho][alto];	
		this.juego = juego;	
	}
	
	
	
	public void cambiarMapa(Celda[][] celdas) {
		
		matrizCeldas = celdas;
		for(int i = 0; i < matrizCeldas.length; i++) {
			for(int j = 0; j < matrizCeldas[0].length; j++) {
				ObjetoDeMapa objeto = matrizCeldas[i][j].getObjetoDeMapa();
				if(objeto != null) {
					matrizDeObjetoDeMapa[i][j] = objeto;
				}
			}
		}	
	}
	
	public Celda celdaIzquierda(Celda celdaActual) {
		
		Celda celdaArriba = null;
		if(celdaActual.getX() != 0)
			celdaArriba = matrizCeldas[celdaActual.getX() - 1][celdaActual.getY()];
		return celdaArriba;
	}
	
	public Celda celdaDerecha(Celda celdaActual) 
	{
		Celda celdaDerecha = null;
		if(celdaActual.getX() < matrizCeldas.length-1)
		{
			celdaDerecha = matrizCeldas[celdaActual.getX() + 1][celdaActual.getY()];
		}
		return celdaDerecha;
	}
	
	public GameObjectGrafico[][] getGraficos() {
		
		GameObjectGrafico[][] toReturn = new GameObjectGrafico[matrizCeldas.length][matrizCeldas[0].length];
		for(int i = 0; i < matrizCeldas.length; i++) {
			for (int j = 0; j < matrizCeldas[0].length; j++) {
				toReturn[i][j] = matrizCeldas[i][j].getGrafico();
			}
		}
		return toReturn;
	}
	
	//-------AGREGAR
	
	//AGREGAR ANTERIOR OBJETOMOVIL
	/*
	public boolean agregarEnemigo(ObjetoMovil obj, int x, int y) {
		
		if(matrizObjetoMovil[x][y] == null) {
			matrizObjetoMovil[x][y] = obj;
			obj.setCelda(matrizCeldas[x][y]);
			return true;
		}
		return false;
	}
	*/
	
	
	
	public void agregarDefensa(Defensa defensa, int x, int y){
		
		if(matrizDefensa[x][y] == null) {
			matrizDefensa[x][y]= defensa;
		}
		defensa.setCelda(matrizCeldas[x][y]);
	}
	
	public boolean agregarEnemigo(Enemigo obj, int x, int y) {
		
		if(matrizEnemigo[x][y] == null) {
			matrizEnemigo[x][y] = obj;
			obj.setCelda(matrizCeldas[x][y]);
			return true;
		}
		return false;
	}
	
	
	public boolean agregarDisparoDefensa(DisparoDefensa obj, int x, int y)
	{
		boolean toReturn = false;
		if(matrizDisparoDefensa[x][y] == null)
		{
			matrizDisparoDefensa[x][y] = obj;
			obj.setCelda(matrizCeldas[x][y]);
			toReturn = true;
		}
		return toReturn;
	}
	
	
	public boolean agregarDisparoEnemigo(DisparoEnemigo obj, int x, int y)
	{
		boolean toReturn = false;
		if(matrizDisparoEnemigo[x][y] == null)
		{
			matrizDisparoEnemigo[x][y] = obj;
			obj.setCelda(matrizCeldas[x][y]);
			toReturn = true;
		}
		return toReturn;
	}
	
	
	//------MOVER
	public void moverEnemigo(int x, int y, int xAnterior, int yAnterior) 
	{	
		matrizEnemigo[x][y] = matrizEnemigo[xAnterior][yAnterior];
		matrizEnemigo[xAnterior][yAnterior] = null;
		juego.moverEnemigoGrafico(matrizEnemigo[x][y]);
	}
	
	
	public void moverDisparoDefensa(int x, int y, int xAnterior, int yAnterior) 
	{	
		matrizDisparoDefensa[x][y] = matrizDisparoDefensa[xAnterior][yAnterior];
		matrizDisparoDefensa[xAnterior][yAnterior] = null;
		juego.moverEnemigoGrafico(matrizDisparoDefensa[x][y]);
	}
	
	
	public void moverDisparoEnemigo(int x, int y, int xAnterior, int yAnterior) 
	{	
		matrizDisparoEnemigo[x][y] = matrizDisparoEnemigo[xAnterior][yAnterior];
		matrizDisparoEnemigo[xAnterior][yAnterior] = null;
		juego.moverEnemigoGrafico(matrizDisparoEnemigo[x][y]);
	}

	
	// MOVER  ANTERIOR
		/*
		public void moverObjetoMovil(int x, int y, int xAnterior, int yAnterior) {
			
			matrizMovil[x][y] = matrizMovil[xAnterior][yAnterior];
			matrizMovil[xAnterior][yAnterior] = null;
			juego.moverEnemigoGrafico(matrizMovil[x][y]);
		}
		*/
	
	
	
	
	
	//----------ELIMINAR
	/*
	public void eliminarObjetoMovil(int x, int y)
	{
		
		matrizMovil[x][y]=null;
		juego.eliminarObjetoMovil(x, y);
	}
	*/
	
	public Defensa eliminarDefensa(int x, int y){
		Defensa defensa = matrizDefensa[x][y];
		matrizDefensa[x][y]=null;
		return defensa;
	}
	
	
	public  void eliminarEnemigo(int x, int y)
	{
		matrizEnemigo[x][y] = null;
		juego.eliminarObjetoMovil(x, y);
	}
	
	
	
	

	//------------
	public Juego getJuego(){
		
		return juego;
	}
	
	public ObjetoMovil getObjeto(Celda c){
		
		return matrizMovil[c.getX()][c.getY()];
	}
	
	
	public void generarDisparo(Disparo disparo, int x, int y) {
		juego.generarDisparo(disparo, x, y);
	}
	
	
	public void crearMuro() {
		for(int i = 0; i<matrizEstatica[0].length; i++) {
			Defensa muro = new Muro(juego);
			matrizEstatica[0][i] = muro;
			juego.dibujarDefensa(0, i, muro);
		}
		
	}

	public Defensa getEstatico(int x, int y) {
		return matrizEstatica[x][y];
	}
	
	public List<ObjetoMovil> adyacentes(Celda celdaOriginal) {

		List<ObjetoMovil> lista = new ArrayList<ObjetoMovil>();
		
		for (int x = celdaOriginal.getX()-1; x < celdaOriginal.getX()+2; x++)
			for (int y=celdaOriginal.getY()-1; y<celdaOriginal.getY()+2; y++)
				if ((x < matrizMovil.length && x >= 0) && (y <matrizMovil[0].length && y >= 0))			
					if (matrizMovil[x][y]!=null)
						lista.add(matrizMovil[x][y]);
		return lista;		
	}

	public Celda [][] getMatriz(){
		
		return matrizCeldas;
	}

}
