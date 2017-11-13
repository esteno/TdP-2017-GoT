package colisiones;

import objetos.*;
import disparos.*;
import enemigos.Enemigo;
import obstaculo.*;


public class VisitorDisparo extends Visitor{
	
	//atributos
	protected Disparo miDisparo;
	
	//constructor
	public VisitorDisparo(Disparo g){
		
		miDisparo=g;
	}
	
	//metodos
	@Override
	public void visitarDefensa(GameObject d){ 
		
		System.out.println("Un disparo ha visitado una defensa. No hay accion.");
    }
	 
	@Override
    public void visitarEnemigo(Enemigo e){
		
    	//System.out.println("quiere destruir mi desparo");
	    miDisparo.destruir();  //al visitar un enemigo el disparo de destruye poniendo el grafico en null
		//System.out.println("quiere destruir mi enemigo");

	    e.recibirAtaque(miDisparo.getFuerzaImpacto()); //por ahora destruye el enemigo
    }
	
	@Override
    public void visitarDisparo(Disparo d){
		
    	System.out.println("Un disparo ha visitado un disparo. No hay accion.");
    }

	@Override
	public void visitarFuegoValyrio(FuegoValyrio f) {
		
		// TODO Auto-generated method stub		
	}




}
	


