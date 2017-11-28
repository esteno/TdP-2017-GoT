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
		///Un disparo ha visitado una defensa. No hay accion
    }
	 
	@Override
    public void visitarEnemigo(Enemigo e){
	    e.recibirAtaque(miDisparo.getFuerzaImpacto()); 
	    miDisparo.destruir();  
	}
}