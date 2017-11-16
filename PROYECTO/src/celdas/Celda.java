package celdas;

import java.util.ArrayList;
import java.util.List;

import ObjetoDeMapa.ObjetoDeMapa;
import defensa.Defensa;
import disparos.*;
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
    
    public GameObjectGrafico getGrafico() {
    	return objeto.getGrafico();
    }
    
    public void setObjetoDeMapa(ObjetoDeMapa obj) {
    	objeto = obj;
    }
    
    public double getMultiVelocidad() {
    	return objeto.getMultiVelocidad();
    }
    
    public ObjetoDeMapa getObjetoDeMapa() {
    	return objeto;
    }
    
    public Celda celdaIzquierda() 
    {
    	return mapa.celdaIzquierda(this);
    }
    
    public Celda celdaDerecha()
    {
    	return mapa.celdaDerecha(this);
    }
    
    //Devuelve el objeto movil que est� sobre esta celda
    public ObjetoMovil objetoMovil() 
    {
    	return mapa.getObjeto(this);
    }
    
    //--------MOVER
    
    //Mueve un enemigo de la posicion (xAnterior, yAnterior) a su nueva posicion (x,y). ANTERIOR
    public void moverObjetoMovil(int xAnterior, int yAnterior) {
    	mapa.moverEnemigo(x, y, xAnterior, yAnterior);
    }
    
    public void moverEnemigo(int xAnterior, int yAnterior)
    {
    	mapa.moverEnemigo(x, y, xAnterior, yAnterior);
    }
    
    //------ELIMINAR
    //Elemina un objeto movil del juego
    public void destruirEnemigo() 
    {
    	mapa.eliminarEnemigo(x, y);
    }

    
	public void agregarDisparo(Disparo disparo) {
		mapa.agregarDisparo(disparo, x, y);
		
	}

    //Devuelve el objeto estatico sobre esta celda.
	public Defensa getEstatico() {
		return mapa.getEstatico(x, y);
	}

	public List<ObjetoMovil> adyacentes() {
		
		List<ObjetoMovil> l=new ArrayList<ObjetoMovil>();
		l=mapa.adyacentes(this);
		return l;
	}
	public Mapa getMapa() {
		return mapa;
	}



	public void moverGrafico(ObjetoMovil objeto) {
		mapa.moverGrafico(objeto);
		
	}


}
