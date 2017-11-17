package colisiones;


import defensa.Defensa;
import disparos.*;
import enemigos.Enemigo;
import defensa.Bomba;
import objetos.*;
import obstaculo.FuegoValyrio;

public class VisitorDefensa extends Visitor
{
		
		 //atributo
		 protected Defensa miDefensor;
		
		 //contructor
	     public VisitorDefensa(Defensa g)
	     {
	    	 miDefensor=g;
	     }
	     
	     //metodos
	     @Override
	     public void visitarDefensa(Defensa d)
	     { 
	    	System.out.println("Un defensor ha visitado un defensor. No hay accion."); 
	     }
	 	 
	     
	     public void visitarEnemigo(Enemigo e)
	     {
	    	 e.recibirAtaque(miDefensor.getFuerzaImpacto());
	    	 //ver que hace fabrica de oleadas con respecto a los puntos
	     }
		
}
