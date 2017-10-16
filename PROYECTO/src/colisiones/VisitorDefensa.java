package colisiones;

import defensa.Defensa;
import enemigos.Enemigo;
import objetos.*;
import disparos.*;
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
     public void visitarDefensa(Defensa d)
     { 
    	// TODO Auto-generated method stub
    	System.out.println("Un defensor ha visitado un defensor. No hay acción."); 
     }
 	 
     
     public void visitarEnemigo(Enemigo e)
     {
    	 // TODO Auto-generated method stub
    	 e.recibirDanio(miDefensor.getFuerzaImpacto());
    	 //ver que hace fabrica de oleadas con respecto a los puntos
     }
 	
     public void visitarDisparo(Disparo d)
     { 
    	 // TODO Auto-generated method stub
    	 // Este caso no se va a dar pues el disparo siempre avanza hacia adelante y el defensor es estatico.
    	 System.out.println("Un defensor ha visitado un disparo. No hay acción.");
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
