package celdas;

import java.util.ArrayList;
import java.util.List;

import ObjetoDeMapa.ObjetoDeMapa;
import defensa.Defensa;
import disparos.*;
import enemigos.Enemigo;
import enemigos.Gigante;
import logica.FabricaObjetoGrafico;
import mapa.Mapa;
import objetos.GameObject;
import objetos.GameObjectGrafico;
import objetos.ObjetoMovil;

/**
 * Clase que modela las celdas logicas de un mapa para ser usada por los personajes y elementos.
 * @author Comision 15
 *
 */
public class Celda 
{
	//atributos
    protected Mapa mapa;
    //Posicion de la celda dentro del mapa.
    protected int x;
    protected int y;
    
    private ObjetoDeMapa objeto;
    
    //constructor 
    public Celda(Mapa m, int x, int y)
    {
    	mapa=m;
    	this.x=x;
    	this.y=y;
    }
    
    //metodos
    public int getX()
    {return x; }
    
    public int getY()
    {return y; }
    
    // Retorna el Objeto Grafico asociado a la celda
    public GameObjectGrafico getGrafico() {
    	return objeto.getGrafico();
    }
    
    // Asocia un objeto del mapa a la celda
    public void setObjetoDeMapa(ObjetoDeMapa obj) {
    	objeto = obj;
    }
    
    // Retorna la velocidad del objeto de la celda
    public double getMultiVelocidad() {
    	return objeto.getMultiVelocidad();
    }
    
    // Retorna el objeto que se encuentra en la celda
    public ObjetoDeMapa getObjetoDeMapa() {
    	return objeto;
    }
    
    // Retorna la cantidad de celdas izquierdas de acuerdo al tamaño de la celda compuesta
    public List<Celda> celdaIzquierda() 
    {
    	List<Celda> lista = new ArrayList<Celda>();
    	lista.add(mapa.celdaIzquierda(this));
    	return lista;
    }
    
    // Retorna la cantidad de celdas derechas de acuerdo al tamaño de la celda compuesta
    public List<Celda> celdaDerecha()
    {
    	List<Celda> lista = new ArrayList<Celda>();
    	lista.add(mapa.celdaDerecha(this));
    	return lista;
    }
    
    //Devuelve el objeto movil que esta sobre esta celda
    public Enemigo getEnemigo() 
    {
    	return mapa.getEnemigo(this);
    }
    
    //--------MOVER
    
    //Mueve un enemigo de la posicion (xAnterior, yAnterior) a su nueva posicion (x,y). ANTERIOR
    public void moverEnemigo(int xAnterior, int yAnterior)
    {
    	mapa.moverEnemigo(x, y, xAnterior, yAnterior);
    }
    
    //------ELIMINAR
    //Elimina un objeto movil del juego
    public void destruirEnemigo() 
    {
    	mapa.eliminarEnemigo(x, y);
    }

    // Agrega en el mapa un disparo en esta celda
	public void agregarDisparo(Disparo disparo) {
		mapa.agregarDisparo(disparo, x, y);
		
	}

    //Devuelve el objeto estatico sobre esta celda.
	public Defensa getEstatico() {
		return mapa.getEstatico(x, y);
	}

	// Devuelve la lista de enemigos adyacentes a esta celda
	public List<ObjetoMovil> adyEnemigos() {
		List<ObjetoMovil> l=new ArrayList<ObjetoMovil>();
		l=mapa.adyEnemigos(this.getX(), this.getY());
		return l;
	}
	
	// Devuelve la lista de defensas adyacentes a esta celda
	public List<Defensa> adyDefensa() {
		List<Defensa> l=new ArrayList<Defensa>();
		l=mapa.adyDefensa(this.getX(), this.getY());
		return l;
	}

	// Mueve logicamente el objeto en el mapa a la siguiente celda
	public void moverGrafico(ObjetoMovil objeto) {
		mapa.moverGrafico(objeto);
	}

	// Destruye logicamente la defensa de esta celda
	public void destruirDefensa() {
		mapa.eliminarDefensa(x, y);
	}
	
	
}
