package colisiones;

import defensa.Defensa;
import enemigos.Enemigo;
import objetos.*;
import disparos.*;
import obstaculo.*;

public class VisitorDefensa extends Visitor
{
	
	//contructor
     public VisitorDefensa(GameObject g)
     {
    	 super(g);
     }
     
     @Override
     public boolean visitarDefensa(Defensa d)
     { 
    	// TODO Auto-generated method stub
    	 return false;
     }
 	 
     
     public boolean visitarEnemigo(Enemigo e)
     {
    	// TODO Auto-generated method stub
    	 //atacar(e);
    	 return true; 
     }
 	
     public boolean visitarDisparo(Disparo d)
     { 
    	// TODO Auto-generated method stub
        return false; 
     }
 	
     public boolean visitarAgua(Agua a)
 	 {
    	// TODO Auto-generated method stub
        return false;
     }
 	
     public boolean visitarRoca(Roca r)
 	 { 
    	// TODO Auto-generated method stub
    	return false;
     } 
}
