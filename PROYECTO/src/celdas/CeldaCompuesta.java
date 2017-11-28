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
	
	// Agrega esta celda a la lista de celdas de la celda compuesta
	public void agregarCeldas(Celda celda) {
		listaCeldas.add(celda);
	}
	
	 // Retorna la cantidad de celdas izquierdas de acuerdo al tamaño de la celda compuesta
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
	
	 // Retorna la cantidad de celdas derechas de acuerdo al tamaño de la celda compuesta
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
    
    // Destruye la defensa que se encuentra en cada celda de la celda compuesta
    public void destruirDefensa() {
    	for(Celda celda : listaCeldas) {
    		mapa.eliminarDefensa(celda.getX(), celda.getY());
    	}
	}

    // Limpia la lista de celdas pertenecientes a la celda compuesta
	public void limpiar() {
		listaCeldas.clear();
		
	}

	// Retorna la lista de celdas perteneciente a la lista compuesta
	public List<Celda> getCeldas() {
		List<Celda> toReturn = new ArrayList<Celda>();
		for(Celda celda : listaCeldas) {
			toReturn.add(celda);
		}
		return toReturn;
	}
	
	// Retorna la velocidad del objeto que se encuentra en la celda compuesta
	public double getMultiVelocidad() {
    	return listaCeldas.get(0).getMultiVelocidad();
    }

	// Setea la posicion de la celda
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
		
	}


}
