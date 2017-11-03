package mapa;

import java.util.ArrayList;
import java.util.List;

import ObjetoDeMapa.ObjetoDeMapa;
import celdas.Celda;
import defensa.*;
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
	private GameObject[][] matrizEstatica;
	
	//Matriz que contiene a los enemigos y los disparos de la defensa.
	private ObjetoMovil[][] matrizMovil;
	
	private Juego juego;
	private FabricaDeDefensa fabricaDeDefensa = FabricaDeDefensa.getInstancia();
	
	
	public Mapa(Juego juego, int alto, int ancho)
	{
		matrizCeldas = new Celda[ancho][alto];
		matrizDeObjetoDeMapa = new ObjetoDeMapa[ancho][alto];
		matrizEstatica = new GameObject[ancho][alto];
		matrizMovil = new ObjetoMovil[ancho][alto];
		
		this.juego = juego;
	}
	
	public void cambiarMapa(Celda[][] celdas) {
		matrizCeldas = celdas;
		
	}
	
	public Celda celdaIzquierda(Celda celdaActual) {
		Celda celdaArriba = null;
		if(celdaActual.getX() != 0)
			celdaArriba = matrizCeldas[celdaActual.getX()- 1][celdaActual.getY()];
		return celdaArriba;
	}
	
	public Celda celdaDerecha(Celda celdaActual) {
		Celda celdaAbajo = null;
		if(celdaActual.getX() != matrizCeldas.length-1)
			celdaAbajo = matrizCeldas[celdaActual.getX()+1][celdaActual.getY()];
		return celdaAbajo;
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
	
	public boolean agregarObjetoMovil(ObjetoMovil obj, int x, int y) {
		if(matrizMovil[x][y] == null) {
			matrizMovil[x][y] = obj;
			obj.setCelda(matrizCeldas[x][y]);
			return true;
		}
		return false;
	}
	
	public void moverMovilIzquierda(Celda celda, ObjetoMovil movil) {
		matrizMovil[celda.getX() + 1][celda.getY()] = null;
		matrizMovil[celda.getX()][celda.getY()] = movil;
	}
	
	public boolean hayEnemigo(Celda celda) 
	{
		if(matrizMovil[celda.getX()][celda.getY()]!=null)
			return true;
		return false;
	}
	
	
	public void moverEnemigo(ObjetoMovil o,int x, int y, int xAnterior, int yAnterior) {
		matrizMovil[x][y] = matrizMovil[xAnterior][yAnterior];
		matrizMovil[xAnterior][yAnterior] = null;
		juego.moverEnemigoGrafico(o);
	}
 
 
	public void eliminarDefensa(int x, int y)
	{
			GameObject g=matrizEstatica[x][y];
			matrizEstatica[x][y]=null;
			g.destruir();
	}
	
	public void eliminarObjetoMovil(int x, int y)
	{
		matrizMovil[x][y]=null;
		juego.eliminarObjetoMovil(x, y);
	}
	
	public void agregarDefensa(Defensa defensa, int x, int y)
	{
		if(matrizEstatica[x][y] == null) {
			matrizEstatica[x][y]= defensa;
		}
		defensa.setCelda(matrizCeldas[x][y]);
	}

	public Juego getJuego()
	{
		return juego;
	}
	
	public ObjetoMovil getObjeto(Celda c)
	{
		return matrizMovil[c.getX()][c.getY()];
	}
	
	public void generarDisparo(int x, int y) {
		juego.generarDisparo(x, y);
	}

	public void crearMuro() {
		for(int i = 0; i<matrizEstatica[0].length; i++) {
			Defensa muro = new Muro(juego);
			matrizEstatica[0][i] = muro;
			juego.dibujarDefensa(0, i, muro);
		}
		
	}

	public GameObject getEstatico(Celda celda) {
		return matrizEstatica[celda.getX()][celda.getY()];
	}
	
	public List<ObjetoMovil> adyacentes(Celda c) {

		List<ObjetoMovil> l=new ArrayList<ObjetoMovil>();
		for (int x=c.getX()-1; x<c.getX()+2; x++)
			for (int y=c.getY()-1; y<c.getX()+2; y++)
				if ((x<matrizMovil.length)&&(y<matrizMovil[0].length))			
					if (matrizMovil[x][y]!=null)
					                l.add(matrizMovil[x][y]);
		return l;
		
		
	}

}
