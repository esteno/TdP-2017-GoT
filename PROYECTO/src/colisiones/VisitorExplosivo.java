package colisiones;


import defensa.*;
import disparos.*;
import enemigos.*;
import objetos.*;
import obstaculo.FuegoValyrio;

public class VisitorExplosivo extends Visitor
{
		
		 //atributo
		 protected Explosivo miExplosivo;
		
		 //contructor
	     public VisitorExplosivo(Explosivo g){
	    	 
	    	 miExplosivo=g;
	     }
	     
	     //metodos
	     @Override
	     public void visitarDefensa(GameObject d){
	    	 
	    	 d.recibirAtaque(miExplosivo.getFuerzaImpacto());
	     }
	 	 
	     
	     public void visitarEnemigo(Enemigo e){
	    	 
	    	 e.recibirAtaque(miExplosivo.getFuerzaImpacto());
	     }
	 	
	     public void visitarDisparo(Disparo d){
	    	 
	    	System.out.println("Un defensor ha visitado un disparo. No hay accion.");
	     }

		@Override
		public void visitarFuegoValyrio(FuegoValyrio f){
			
			// TODO Auto-generated method stub
		}

		@Override
		public void visitarExplosivo(GameObject ex) {

			System.out.println("Las bombas no se dañan entre si");
			
		}
		
}
