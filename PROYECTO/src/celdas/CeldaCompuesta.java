package celdas;

import java.util.ArrayList;
import java.util.List;

import ObjetoDeMapa.ObjetoDeMapa;
import disparos.Disparo;
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
	    
	    public CeldaCompuesta(Mapa map, int x, int y) {
			super(map, x, y);
			c1=new Celda (map, x, y);
			c2=new Celda (map, x, y+1);
			z=y+1;
		}
	       
	    
	    
	    //Mueve un enemigo de la posicion (xAnterior, yAnterior) a su nueva posicion (x,y).
	    public void moverEnemigo(int xAnterior, int yAnterior) {
	    	mapa.moverEnemigo(x, y, xAnterior, yAnterior);
	    	mapa.moverEnemigo(x, z, xAnterior, yAnterior);
	    }
	    
	    //Genera un nuevo disparo en esta celda
	    public void generarDisparo(Disparo disparo) {
	    	mapa.generarDisparo(disparo,x, y);
	    	mapa.generarDisparo(disparo,x, z);
	    }

	}