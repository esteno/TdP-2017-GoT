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
    public Celda(Mapa m, int y, int x)
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
    
    public Celda celdaArriba() {
    	return mapa.celdaArriba(this);
    }
    
    public void moverMovilArriba(ObjetoMovil objeto) {
    	mapa.moverMovilArriba(this, objeto);
    }
}
