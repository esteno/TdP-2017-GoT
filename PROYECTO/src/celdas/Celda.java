package celdas;

import mapa.Mapa;
import objetos.GameObjectGrafico;

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
}
