package disparos;

import celdas.Celda;
import colisiones.VisitorDisparo;
import defensa.Defensa;


public class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(double danio) {
		super(danio);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void avanzar() 
	{
		// TODO Auto-generated method stub

		//Pide la celda a la que se va a mover
		Celda celdaIzquierda = celda.celdaIzquierda();
		//Si todavia tiene alcance y no llego al 
		if( (alcance > 0) && (celdaIzquierda != null) ) 
		{	
			//Si hay otro objeto movil en esa celda
			Defensa defensa = celdaIzquierda.getEstatico();
			if(defensa!=null)
			{	
				//Le pasa el visitor, si es enemigo lo ataca, si es otro disparo no hace nada.
				defensa.aceptar(new VisitorDisparo(this));
			} 
			else 
			{
				//Guarda la posicion actual
				int xAnterior = celda.getX();
				int yAnterior = celda.getY();
				
				//Cambia de celda
				celda = celdaIzquierda;

				//Se mueve
				celda.moverDisparoEnemigo(xAnterior, yAnterior);

				//Decrementa el alcance
				alcance--;
			}
		}
		else
		{
			destruir();
		}
	}

}
