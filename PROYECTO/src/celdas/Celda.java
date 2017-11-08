package celdas;

import java.util.ArrayList;
import java.util.List;

import ObjetoDeMapa.ObjetoDeMapa;
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
public class Celda 
{
	//atributos
    protected Mapa mapa;
    //Posicion de la celda dentro del mapa.
    protected int fila; // seria el X
    protected int columna; // seria el Y
    
    //Objeto grafico que se muestra en pantalla
    protected GameObjectGrafico grafico;
    
    private ObjetoDeMapa objeto;
    
    //constructor 
    public Celda(Mapa m, int x, int y)
    {
    	mapa=m;
    	fila=x;
    	columna=y;
    	grafico = FabricaObjetoGrafico.getInstancia().construirGraficoCeldaComun();
    }
    
   
    
    //metodos
    
    public int getX()
    {
    	return fila; 
    }
    
    
    
    public int getY()
    {
    	return columna; 
    }
    
    
    
    
    public GameObjectGrafico getGrafico() 
    {
    	GameObjectGrafico grafico = null;
    	
    	if(objeto != null) 
    	{
    		grafico = objeto.getGrafico();
    	}
    	return grafico;
    }
    
    
    
    
    public void setObjetoDeMapa(ObjetoDeMapa obj) 
    {
    	objeto = obj;
    }
    
    
    
    public double getMultiVelocidad()
    {
    	double toReturn = 1.0;
    	if(objeto != null) 
    	{
    		toReturn = objeto.getMultiVelocidad();
    	}
    	return toReturn;
    }
    
    
    
    public ObjetoDeMapa getObjetoDeMapa() 
    {
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
    
    
    
    //Devuelve el objeto movil que está sobre esta celda
    public ObjetoMovil objetoMovil() 
    {
    	return mapa.getObjeto(this);
    }
    
    
    
    //Mueve un enemigo de la posicion (xAnterior, yAnterior) a su nueva posicion (x,y).
    public void moverEnemigo(ObjetoMovil o,int xAnterior, int yAnterior) 
    {
    	mapa.moverEnemigo(o,fila, columna, xAnterior, yAnterior);
    }
    
    
    
    //Elemina un objeto movil del juego
    public void destruirObjetoMovil() 
    {
    	mapa.eliminarObjetoMovil(fila, columna);
    }
    
    
    
    //Genera un nuevo disparo en esta celda
    public void generarDisparo() {
    	mapa.generarDisparo(fila, columna);
    }
    
    
    

    //Devuelve el objeto estatico sobre esta celda.
	public GameObject getEstatico() 
	{
		return mapa.getEstatico(this);
	}
	
	
	
	

	public List<ObjetoMovil> adyacentes() 
	{
		
		List<ObjetoMovil> l=new ArrayList<ObjetoMovil>();
		l=mapa.adyacentes(this);
		return l;
	}

}
