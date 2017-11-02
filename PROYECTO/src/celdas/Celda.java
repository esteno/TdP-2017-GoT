package celdas;

import defensa.Defensa;
import logica.FabricaObjetoGrafico;
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
    protected GameObjectGrafico grafica;
    protected double multiVelocidad;
    protected FabricaObjetoGrafico fabricaGrafica = FabricaObjetoGrafico.getInstancia();
  
    
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
    
    public double getMultiVelocidad() {
    	return multiVelocidad;
    }
    
    public GameObjectGrafico getGrafico() {
    	return grafica;
    }
    
    public Celda celdaIzquierda() 
    {
    	return mapa.celdaIzquierda(this);
    }
    
    public Celda celdaDerecha()
    {
    	return mapa.celdaDerecha(this);
    }
    
    //preguntar esto
    public ObjetoMovil objetoMovil() 
    {
    	return mapa.getObjeto(this);
    }
    
    
    public void moverEnemigo(int xAnterior, int yAnterior) {
    	mapa.moverEnemigo(x, y, xAnterior, yAnterior);
    }
    
    public void destruirObjetoMovil() 
    {
    	mapa.eliminarObjetoMovil(x, y);
    }
    public Mapa getMapa()
    { return mapa; }
    
    public void generarDisparo() {
    	mapa.generarDisparo(x, y);
    }


	public GameObject getEstatico() {
		return mapa.getEstatico(this);
	}


}
