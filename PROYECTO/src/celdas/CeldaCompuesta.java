package celdas;

import java.util.ArrayList;
import java.util.List;

import disparos.Disparo;
import mapa.Mapa;

public class CeldaCompuesta extends Celda {
	
	private List<Celda> listaCeldas;

	public CeldaCompuesta(Mapa m, int x, int y) {
		super(m, x, y);
		listaCeldas = new ArrayList<Celda>();
		// TODO Auto-generated constructor stub
	}
	
	public void agregarCeldas(Celda celda) {
		listaCeldas.add(celda);
	}
	
	//Mueve un enemigo de la posicion (xAnterior, yAnterior) a su nueva posicion (x,y). ANTERIOR
    public void moverEnemigo(int xAnterior, int yAnterior)
    {
    	for(Celda celda : listaCeldas) {
    		mapa.moverEnemigo(celda.getX(), celda.getY(), xAnterior+celda.getX(), yAnterior+celda.getY());
    	}
    }
    
    public void moverEnemigoDoble(int xAnterior, int yAnterior)
    {
    	mapa.moverEnemigo(x, y, xAnterior, yAnterior);
    }
    
    //------ELIMINAR
    //Elemina un objeto movil del juego
    public void destruirEnemigo() 
    {
    	for(Celda celda : listaCeldas) {
    		mapa.eliminarEnemigo(celda.getX(), celda.getY());
    	}
    }
    
    public void destruirDefensa() {
    	for(Celda celda : listaCeldas) {
    		mapa.eliminarDefensa(celda.getX(), celda.getY());
    	}
	}


}
