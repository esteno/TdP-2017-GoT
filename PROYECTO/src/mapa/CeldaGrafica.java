package mapa;

import objetos.GameObjectGrafico;

public class CeldaGrafica extends GameObjectGrafico 
{
	//atributos
    protected Mapa mapa;
    protected int x;
    protected int y;
    
    //constructor 
    public CeldaGrafica(Mapa m, int x, int y)
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

}
