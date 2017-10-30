package colisiones;


import defensa.Defensa;
import disparos.*;
import enemigos.Enemigo;
import enemigos.Enemigo.*;
import premio.AceroValirio;
import premio.Barricada;
import premio.CampoProteccion;
import premio.Mina;
import objetos.*;

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
	    	System.out.println("Un defensor ha visitado un defensor. No hay accion."); 
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
	    	 System.out.println("Un defensor ha visitado un disparo. No hay accion.");
	     }
	 	

		@Override
		public void visitarMina(Mina m) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void visitarCampoProteccion(CampoProteccion c) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void visitarBarricada(Barricada b) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void visitarAceroValirio(AceroValirio a) {
			// TODO Auto-generated method stub
			
		}
}
