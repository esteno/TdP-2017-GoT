package mapa;

import java.util.ArrayList;
import java.util.List;

import ObjetoDeMapa.ObjetoDeMapa;
import celdas.*;
import defensa.*;
import disparos.Disparo;
import enemigos.Enemigo;
import logica.FabricaDeDefensa;
import logica.Juego;
import objetos.*;

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
	
	public boolean agregarDefensa(Defensa defensa, int x, int y){
		Boolean pudeAgregar = false;
		Boolean hayEspacio = true;
		if((defensa.getAlto()+y <= matrizCeldas[0].length) && (defensa.getAncho()+x <= matrizCeldas.length)) {
			for(int iCheck = x; iCheck < defensa.getAncho()+x ; iCheck++) {
				for(int jCheck = y; jCheck < defensa.getAlto()+ y ; jCheck++) {
					if(matrizDefensa[iCheck][jCheck] != null)
						hayEspacio = false;
				}
			}
			if(hayEspacio) {
				CeldaCompuesta celdaCompuesta = new CeldaCompuesta(this, x, y);
				for(int i = x; i < defensa.getAncho()+x ; i++) {
					for(int j = y; j < defensa.getAlto()+y ; j++) {
						System.out.println("agregue celda en "+i+" "+j);
						matrizDefensa[i][j] = defensa;
						celdaCompuesta.agregarCeldas(matrizCeldas[i][j]);
					}
				}
				defensa.setCelda(celdaCompuesta);
				pudeAgregar = true;
			}
		}
		return pudeAgregar;
	}
	
	
	public boolean agregarEnemigo(Enemigo enemigo, int x, int y) {
		Boolean pudeAgregar = false;
		Boolean hayEspacio = true;
		if((enemigo.getAlto()+y <= matrizCeldas[0].length) && (enemigo.getAncho()+x <= matrizCeldas.length)) {
			for(int iCheck = x; iCheck < enemigo.getAncho()+x ; iCheck++) {
				for(int jCheck = y; jCheck < enemigo.getAlto()+ y ; jCheck++) {
					if(matrizEnemigo[iCheck][jCheck] != null)
						hayEspacio = false;
				}
			}
			if(hayEspacio) {
				CeldaCompuesta celdaCompuesta = new CeldaCompuesta(this, x, y);
				for(int i = x; i < enemigo.getAncho()+x ; i++) {
					for(int j = y; j < enemigo.getAlto()+ y ; j++) {
						System.out.println("agregue celda enemigo en "+i+" "+j);
						matrizEnemigo[i][j]= enemigo;
						celdaCompuesta.agregarCeldas(matrizCeldas[i][j]);
					}
				}
				enemigo.setCelda(celdaCompuesta);
				pudeAgregar = true;
			}
		}
		
		return pudeAgregar;
	}
	
	public void agregarDisparo(Disparo disparo, int x, int y) {
		CeldaCompuesta celda = new CeldaCompuesta(this, x, y);
		disparo.setCelda(celda);
		celda.agregarCeldas(matrizCeldas[x][y]);
		juego.agregarDisparo(disparo, x, y);
	}
	
	//------MOVER
	public void moverEnemigo(int x, int y, int xAnterior, int yAnterior) {
		System.out.format("moverEnemigo de x %d y %d xAnterior %d yAnterior %d \n", x, y, xAnterior, yAnterior);
		matrizEnemigo[x][y] = matrizEnemigo[xAnterior][yAnterior];
		matrizEnemigo[xAnterior][yAnterior] = null;
		if (x==0)
			juego.gameOver();
	}
	
	public Defensa eliminarDefensa(int x, int y){
		Defensa defensa = matrizDefensa[x][y];
		matrizDefensa[x][y]=null;
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
	
	public List<ObjetoMovil> adyEnemigos(int x, int y) {
		List<ObjetoMovil> lista = new ArrayList<ObjetoMovil>();
		for (int xBuscar = x-1; xBuscar < x+2; xBuscar++)
			for (int yBuscar = y-1; yBuscar < y+2; yBuscar++)
				if ((xBuscar < matrizEnemigo.length && xBuscar >= 0) && (yBuscar <matrizEnemigo[0].length && yBuscar >= 0))			
					if (matrizEnemigo[xBuscar][yBuscar]!=null)
						lista.add(matrizEnemigo[xBuscar][yBuscar]);
		return lista;		
	}

	public List<Defensa> adyDefensa(int x, int y) {
		List<Defensa> lista = new ArrayList<Defensa>();
		for (int xBuscar = x-1; xBuscar < x+2; xBuscar++)
			for (int yBuscar=y-1; yBuscar<y+2; yBuscar++)
				if ((xBuscar < matrizDefensa.length && xBuscar >= 0) && (yBuscar <matrizDefensa[0].length && yBuscar >= 0))			
					if (matrizDefensa[xBuscar][yBuscar]!=null)
						lista.add(matrizDefensa[xBuscar][yBuscar]);
		return lista;		
	}

	public void moverGrafico(ObjetoMovil objeto) {
		juego.moverGrafico(objeto);
	}

	public void reemplazarEnemigo(Enemigo campo, int x, int y) {
		CeldaCompuesta celdaCompuesta = new CeldaCompuesta(this, x, y);
		for(int i = x; i < campo.getAncho()+x ; i++) {
			for(int j = y; j < campo.getAlto()+ y ; j++) {
				matrizEnemigo[i][j]= campo;
				celdaCompuesta.agregarCeldas(matrizCeldas[i][j]);
			}
		}
		celdaCompuesta.setPos(x, y);
		campo.setCelda(celdaCompuesta);
	}

	public void reemplazarDefensa(Defensa campo, int x, int y) {

		CeldaCompuesta celdaCompuesta = new CeldaCompuesta(this, x, y);
		for(int i = x; i < campo.getAncho()+x ; i++) {
			for(int j = y; j < campo.getAlto()+ y ; j++) {
				matrizDefensa[i][j]= campo;
				celdaCompuesta.agregarCeldas(matrizCeldas[i][j]);
			}
		}
		celdaCompuesta.setPos(x, y);
		campo.setCelda(celdaCompuesta);
	}

}
