package colisiones;

import objetos.*;
import defensa.Defensa;
import disparos.*;
import enemigos.Enemigo;
import obstaculo.*;


public class VisitorDisparoDefensa extends Visitor{
	
	//atributos
	protected Disparo miDisparo;
	
	//constructor
	public VisitorDisparoDefensa(Disparo g){
		
		miDisparo=g;
	}
	
	//metodos
	@Override
	public void visitarDefensa(Defensa d){ 
		
		System.out.println("Un disparo ha visitado una defensa. No hay accion.");
    }
	 
	@Override
    public void visitarEnemigo(Enemigo e)
	{	
    	System.out.println("Yo Disparo recibi a un enemigo.");
	    e.recibirAtaque(miDisparo.getFuerzaImpacto()); //por ahora destruye el enemigo
		System.out.println("Yo Disparo da�e a un enemigo.");
	    miDisparo.destruir();  //al visitar un enemigo el disparo de destruye poniendo el grafico en null
		System.out.println("Disparo destruido.");
	}




}
	


