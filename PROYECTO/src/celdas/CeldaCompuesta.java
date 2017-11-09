package celdas;

import java.util.ArrayList;
import java.util.List;

import ObjetoDeMapa.ObjetoDeMapa;
import logica.FabricaObjetoGrafico;
import mapa.Mapa;
import objetos.GameObject;
import objetos.GameObjectGrafico;
import objetos.ObjetoMovil;

public class CeldaCompuesta extends Celda
{
	

		//atributos
	    protected Mapa mapa;
	    //Posicion de la celda dentro del mapa.
	    protected Celda c1;
	    protected Celda c2;
	    protected int x;
	    protected int y;
	    protected int z;
	    
	    //Objeto grafico que se muestra en pantalla
	    protected GameObjectGrafico grafico;
	    
	    private ObjetoDeMapa objeto;
	    
	    //constructor 
	    
	    public CeldaCompuesta(Mapa m, int a, int b) {
			super(m, a, b);
			mapa=m;
			c1=new Celda (m,a,b);
			c2=new Celda (m,a,b+1);
			x=a;
			y=b;
			z=c2.getY();
			grafico = FabricaObjetoGrafico.getInstancia().construirGraficoCeldaComun();
		}
	       
	    //metodos
	    public int getX(){
	    	return x; 
	    }
	    
	    public int getY(){
	    	return y; 
	    }
	    
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
	    
	    public Celda celdaIzquierda(){
	    	return mapa.celdaIzquierda(c1);
	    }
	    
	    public Celda celdaDerecha() {
	    	return mapa.celdaDerecha(c1);
	    }
	    
	    //Devuelve el objeto movil que está sobre esta celda
	    public ObjetoMovil objetoMovil(){
	    	return mapa.getObjeto(this);
	    }
	    
	    //Mueve un enemigo de la posicion (xAnterior, yAnterior) a su nueva posicion (x,y).
	    public void moverEnemigo(ObjetoMovil o,int xAnterior, int yAnterior) {
	    	mapa.moverEnemigo(o,x, y, xAnterior, yAnterior);
	    	mapa.moverEnemigo(o,x, z, xAnterior, yAnterior);
	    }
	    
	    //Elemina un objeto movil del juego
	    public void destruirObjetoMovil(){
	    	mapa.eliminarObjetoMovil(x, y);
	    }
	    
	    //Genera un nuevo disparo en esta celda
	    public void generarDisparo() {
	    	mapa.generarDisparoDoble(x, y,z);
	    }

	    //Devuelve el objeto estatico sobre esta celda.
		public GameObject getEstatico() {
			return mapa.getEstatico(this);
		}

		public List<ObjetoMovil> adyacentes() {
			
			List<ObjetoMovil> l=new ArrayList<ObjetoMovil>();
			l=mapa.adyacentes(this);
			return l;
		}

	}