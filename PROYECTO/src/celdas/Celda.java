package celdas;

import mapa.Mapa;
import objetos.GameObject;
import objetos.GameObjectGrafico;
import objetos.ObjetoMovil;

public abstract class Celda 
{
	//atributos
    protected Mapa mapa;
    protected int x;
    protected int y;
    protected CeldaGrafica grafica;
    
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
    	return grafica;
    }
    
    public Celda celdaIzquierda() {
    	return mapa.celdaIzquierda(this);
    }
    
    public boolean hayEnemigo() {
    	return mapa.hayEnemigo(this);
    }
    
    public void moverEnemigo(int x, int y ,int xAnterior, int yAnterior) {
    	mapa.moverEnemigo(x, y, xAnterior, yAnterior);
    }
    
    public void destruirEnemigo() {
    	mapa.eliminarEnemigo(x, y);
    }
}
