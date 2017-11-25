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
import enemigos.Gigante;
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
	
	private Juego juego;
	private FabricaDeDefensa fabricaDeDefensa = FabricaDeDefensa.getInstancia();
	
	public Mapa(Juego juego, int alto, int ancho){
		matrizCeldas = new Celda[ancho][alto];
		matrizDeObjetoDeMapa = new ObjetoDeMapa[ancho][alto];
		matrizDefensa = new Defensa[ancho][alto];
		matrizEnemigo = new Enemigo[ancho][alto];
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

	public Celda celdaIzquierda(Celda celdaActual){	
		Celda celdaIzquierda = null;
		if(celdaActual.getX() != 0)
			celdaIzquierda = matrizCeldas[celdaActual.getX() - 1][celdaActual.getY()];
		return celdaIzquierda;
	}
	
	public Celda celdaDerecha(Celda celdaActual) {
		Celda celdaDerecha = null;
		if(celdaActual.getX() < matrizCeldas.length-1){
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
	
	public void agregarDefensa(Defensa defensa, int x, int y){
		if(matrizDefensa[x][y] == null) {
			matrizDefensa[x][y]= defensa;
		}
		defensa.setCelda(matrizCeldas[x][y]);
	}
	
	public void setDoble(Defensa d, int x, int y){
		if(matrizDefensa[x][y] == null) {
			matrizDefensa[x][y]= d;
		}
		d.setCelda2(matrizCeldas[x][y]);
	}
	
	
	
	public void setDoble(Enemigo e , int x, int y)
	{
		// TODO Auto-generated method stub
		if (matrizEnemigo[x][y] == null)
		{
			matrizEnemigo[x][x] = e;
		}
		e.setCelda2(matrizCeldas[x][y]);
	}
	
	public boolean agregarEnemigo(Enemigo obj, int x, int y) {
		if(matrizEnemigo[x][y] == null) {
			matrizEnemigo[x][y] = obj;
			obj.setCelda(matrizCeldas[x][y]);
			return true;
		}
		return false;
	}
	
	public void agregarDisparo(Disparo disparo, int x, int y) {
		disparo.setCelda(matrizCeldas[x][y]);
		juego.agregarDisparo(disparo, x, y);
	}
	
	//------MOVER
	public void moverEnemigo(int x, int y, int xAnterior, int yAnterior) {	
		if (x==0)
			juego.gameOver();
		matrizEnemigo[x][y] = matrizEnemigo[xAnterior][yAnterior];
		matrizEnemigo[xAnterior][yAnterior] = null;
		moverGrafico(matrizEnemigo[x][y]);
	}
	
	public Defensa eliminarDefensa(int x, int y){
		Defensa defensa = matrizDefensa[x][y];
		matrizDefensa[x][y]=null;
		Celda aux=defensa.getDoble();
		if(aux!=null){
			matrizDefensa[aux.getX()][aux.getY()]=null;
		}
		return defensa;
	}
	
	public  void eliminarEnemigo(int x, int y){
		matrizEnemigo[x][y] = null;
	}

	public Juego getJuego(){
		return juego;
	}
	
	public Enemigo getEnemigo(Celda c){
		return matrizEnemigo[c.getX()][c.getY()];
	}
	
	public Defensa getEstatico(int x, int y) {
		return matrizDefensa[x][y];
	}
	
	public List<ObjetoMovil> adyEnemigos(Celda celdaOriginal) {
		List<ObjetoMovil> lista = new ArrayList<ObjetoMovil>();
		for (int x = celdaOriginal.getX()-1; x < celdaOriginal.getX()+2; x++)
			for (int y=celdaOriginal.getY()-1; y<celdaOriginal.getY()+2; y++)
				if ((x < matrizEnemigo.length && x >= 0) && (y <matrizEnemigo[0].length && y >= 0))			
					if (matrizEnemigo[x][y]!=null)
						lista.add(matrizEnemigo[x][y]);
		return lista;		
	}

	public List<Defensa> adyDefensa(Celda celdaOriginal) {
		List<Defensa> lista = new ArrayList<Defensa>();
		for (int x = celdaOriginal.getX()-1; x < celdaOriginal.getX()+2; x++)
			for (int y=celdaOriginal.getY()-1; y<celdaOriginal.getY()+2; y++)
				if ((x < matrizDefensa.length && x >= 0) && (y <matrizDefensa[0].length && y >= 0))			
					if (matrizDefensa[x][y]!=null)
						lista.add(matrizDefensa[x][y]);
		return lista;		
	}

	public void moverGrafico(ObjetoMovil objeto) {
		juego.moverGrafico(objeto);
	}

	

}
