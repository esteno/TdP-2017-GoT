package colisiones;

import defensa.Defensa;
import enemigos.Enemigo;
import objetos.*;
import disparos.*;
import obstaculo.*;

public class VisitorDefensa extends Visitor
{
	
	 //atributo
	 protected Defensa miDefensa;
	
	 //contructor
     public VisitorDefensa(GameObject g)
     {
    	 super(g);
     }
     
     //metodos
     @Override
     public void visitarDefensa(Defensa d)
     { 
    	// TODO Auto-generated method stub
     }
 	 
     
     public void visitarEnemigo(Enemigo e)
     {
    	// TODO Auto-generated method stub
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
