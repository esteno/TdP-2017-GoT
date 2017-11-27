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
	
	public List<Celda> celdaIzquierda()
    {
    	List<Celda> lista = new ArrayList<Celda>();
    	for(Celda celda : listaCeldas) {
    		Celda celdaIzquierda = mapa.celdaIzquierda(celda);
    		if(celdaIzquierda != null)
    			lista.add(celdaIzquierda);
    	}
    	return lista;
    }
	
	public List<Celda> celdaDerecha()
    {
    	List<Celda> lista = new ArrayList<Celda>();
    	for(Celda celda : listaCeldas) {
    		Celda celdaDerecha = mapa.celdaDerecha(celda);
    		if(celdaDerecha != null)
    			lista.add(celdaDerecha);
    	}
    	return lista;
    }
	
	
	//Mueve un enemigo de la posicion (xAnterior, yAnterior) a su nueva posicion (x,y). ANTERIOR
    public void moverEnemigo(int x, int y, int xAnterior, int yAnterior)
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

	public void limpiar() {
		listaCeldas.clear();
		
	}

	public List<Celda> getCeldas() {
		List<Celda> toReturn = new ArrayList<Celda>();
		for(Celda celda : listaCeldas) {
			toReturn.add(celda);
		}
		return toReturn;
	}
	
	public double getMultiVelocidad() {
    	return listaCeldas.get(0).getMultiVelocidad();
    }

	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
		
	}


}
