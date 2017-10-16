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
    	System.out.println("Un defensor ha visitado un defensor"); 
     }
 	 
     
     public void visitarEnemigo(Enemigo e)
     {
    	// TODO Auto-generated method stub
    	 e.destruir();
  
    	//miDefensor.getCelda().getMapa().getJuego().sumarPuntaje(e.getPuntaje());
        //ver que hace fabrica de oleadas con respecto a los puntos
     }
 	
     public void visitarDisparo(Disparo d)
     { 
    	// TODO Auto-generated method stub
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
