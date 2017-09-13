package mapa;

import java.awt.image.BufferedImage;

import objetos.GameObjectGrafico;

public class Celda 
{
	//atributos
    protected Mapa mapa;
    protected int x;
    protected int y;
    private CeldaGrafica grafica;
    
    //constructor 
    public Celda(Mapa m, int x, int y)
    {
    	grafica = new CeldaGrafica();
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
