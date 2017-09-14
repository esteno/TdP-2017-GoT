package mapa;

import objetos.*;
import premio.*;

public class Mapa 
{ 
	private Celda[][] matrizCeldas;
	private GameObject[][] matrizEstatica;
	private ObjetoMovil[][] matrizMovil;
	
	public Mapa(int alto, int ancho)
	{
		matrizCeldas = new Celda[alto][ancho];
		matrizEstatica = new GameObject[alto][ancho];
		matrizMovil = new ObjetoMovil[alto][ancho];
		
		for(int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				matrizCeldas[i][j] = new Celda(this, i, j);
			}
		}
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
