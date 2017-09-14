package mapa;

import celdas.Celda;
import celdas.CeldaGrafica;
import objetos.*;
import premio.*;

public class Mapa 
{ 
	//Generador de Celdas con distinto tipo de terreno
	private GeneradorDeCeldas generadorDeCeldas= GeneradorDeCeldas.instancia();
	
	//Matriz que va a contener las celdas que conforman el mapa.
	private Celda[][] matrizCeldas;
	
	//Matriz que tiene todo lo que son defensas del jugador y obstaculos
	private GameObject[][] matrizEstatica;
	
	//Matriz que contiene a los enemigos y los disparos de la defensa.
	private ObjetoMovil[][] matrizMovil;
	
	
	public Mapa(int alto, int ancho)
	{
		matrizCeldas = new Celda[alto][ancho];
		matrizEstatica = new GameObject[alto][ancho];
		matrizMovil = new ObjetoMovil[alto][ancho];
		
		//Inicializo la matriz con celdas
		for(int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				matrizCeldas[i][j] = generadorDeCeldas.generar(this, i, j);
			}
		}
	}
	
	public Celda celdaArriba(Celda celdaActual) {
		Celda celdaArriba = null;
		if(celdaActual.getY() != 0)
			celdaArriba = matrizCeldas[celdaActual.getY()-1][celdaActual.getX()];
		return celdaArriba;
	}
	
	public Celda CeldaAbajo(Celda celdaActual) {
		Celda celdaAbajo = null;
		if(celdaActual.getY() != matrizCeldas.length-1)
			celdaAbajo = matrizCeldas[celdaActual.getY()+1][celdaActual.getX()];
		return celdaAbajo;
	}
	
	public GameObjectGrafico[][] getGraficos() {
		GameObjectGrafico[][] toReturn = new CeldaGrafica[matrizCeldas.length][matrizCeldas[0].length];
		for(int i = 0; i < matrizCeldas.length; i++) {
			for (int j = 0; j < matrizCeldas[0].length; j++) {
				toReturn[i][j] = matrizCeldas[i][j].getGrafico();
			}
		}
		return toReturn;
	}

}
