package colisiones;


import defensa.Defensa;
import enemigos.Enemigo;

public class VisitorDefensa extends Visitor{
	
		 //atributo
		 protected Defensa miDefensor;
		
		 //contructor
	     public VisitorDefensa(Defensa g){
	    	 miDefensor=g;
	     }
	     
	     //metodos
	     @Override
	     public void visitarDefensa(Defensa d) { 
	    	///Un defensor ha visitado un defensor. No hay accion 
	     }
	     
	     public void visitarEnemigo(Enemigo e){
	    	 e.recibirAtaque(miDefensor.getFuerzaImpacto());
	     }

}
