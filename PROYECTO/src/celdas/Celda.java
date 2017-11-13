package celdas;

import java.util.ArrayList;
import java.util.List;

import ObjetoDeMapa.ObjetoDeMapa;
import defensa.Defensa;
import disparos.Disparo;
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
    
    //Objeto grafico que se muestra en pantalla
    protected GameObjectGrafico grafico;
    
    private ObjetoDeMapa objeto;
    
    //constructor 
    public Celda(Mapa m, int x, int y)
    {
    	mapa=m;
    	this.x=x;
    	this.y=y;
    	grafico = FabricaObjetoGrafico.getInstancia().construirGraficoCeldaComun();
    }
    
   
    
    //metodos
    public int getX()
    {return x; }
    
    public int getY()
    {return y; }
    
    public GameObjectGrafico getGrafico() {
    	if(objeto != null) {
    		return objeto.getGrafico();
    	}
    	return grafico;
    }
    
    public void setObjetoDeMapa(ObjetoDeMapa obj) {
    	objeto = obj;
    }
    
    public double getMultiVelocidad() {
    	double toReturn = 1.0;
    	if(objeto != null) {
    		toReturn = objeto.getMultiVelocidad();
    	}
    	return toReturn;
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
    
    //Mueve un enemigo de la posicion (xAnterior, yAnterior) a su nueva posicion (x,y).
    public void moverEnemigo(ObjetoMovil o,int xAnterior, int yAnterior) {
    	mapa.moverEnemigo(o,x, y, xAnterior, yAnterior);
    }
    
    //Elemina un objeto movil del juego
    public void destruirObjetoMovil() 
    {
    	mapa.eliminarObjetoMovil(x, y);
    }
    
    //Genera un nuevo disparo en esta celda
    public void generarDisparo(Disparo disparo) {
    	mapa.generarDisparo(disparo, x, y);
    }

    //Devuelve el objeto estatico sobre esta celda.
	public GameObject getEstatico() {
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

}
