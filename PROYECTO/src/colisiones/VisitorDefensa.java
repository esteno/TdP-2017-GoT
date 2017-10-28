package colisiones;


import defensa.Defensa;
import objetos.*;
import disparos.*;
import enemigos.Enemigo;
import obstaculo.*;

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
	     public void visitarDefensor(GameObject d)
	     { 
	    	// TODO Auto-generated method stub
	    	System.out.println("Un defensor ha visitado un defensor. No hay acci�n."); 
	     }
	 	 
	     
	     public void visitarEnemigo(Enemigo e)
	     {
	    	 // TODO Auto-generated method stub
	    	 e.recibirAtaque(miDefensor.getFuerzaImpacto());
	    	 //ver que hace fabrica de oleadas con respecto a los puntos
	     }
	 	
	     public void visitarDisparo(Disparo d)
	     { 
	    	 // TODO Auto-generated method stub
	    	 // Este caso no se va a dar pues el disparo siempre avanza hacia adelante y el defensor es estatico.
	    	 System.out.println("Un defensor ha visitado un disparo. No hay acci�n.");
	     }
	 	
	     public void visitarAgua(Agua a)
	 	 {
	    	// TODO Auto-generated method stub
	     }
	 	
	     public void visitarRoca(Roca r)
	 	 { 
	    	// TODO Auto-generated method stub
	     } 

}
