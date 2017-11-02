package celdas;

import defensa.Defensa;
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
public abstract class Celda 
{
	//atributos
    protected Mapa mapa;
    //Posicion de la celda dentro del mapa.
    protected int x;
    protected int y;
    
    //Objeto grafico que se muestra en pantalla
    protected GameObjectGrafico grafica;
    
    //Multiplicador de velocidad para los que se muevan sobre esta celda.
    protected double multiVelocidad;
    
    //Instancia de la fabrica de objetos graficos
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
    
    //Devuelve el objeto movil que está sobre esta celda
    public ObjetoMovil objetoMovil() 
    {
    	return mapa.getObjeto(this);
    }
    
    //Mueve un enemigo de la posicion (xAnterior, yAnterior) a su nueva posicion (x,y).
    public void moverEnemigo(int xAnterior, int yAnterior) {
    	mapa.moverEnemigo(x, y, xAnterior, yAnterior);
    }
    
    //Elemina un objeto movil del juego
    public void destruirObjetoMovil() 
    {
    	mapa.eliminarObjetoMovil(x, y);
    }
    

    
    public void generarDisparo() {
    	mapa.generarDisparo(x, y);
    }


	public GameObject getEstatico() {
		return mapa.getEstatico(this);
	}


}
