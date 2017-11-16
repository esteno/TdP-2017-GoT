package disparos;

import celdas.Celda;
import colisiones.VisitorDisparo;
import objetos.ObjetoMovil;

public class DisparoPersonaje extends Disparo {

	public DisparoPersonaje(double danio) {
		super(danio);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void avanzar() 
	{
		// TODO Auto-generated method stub
		
		//Pide la celda a la que se va a mover
				Celda celdaNueva = celda.celdaDerecha();
				//Si todavia tiene alcance y no llego al 
				if( (alcance > 0) && (celdaNueva != null) ) 
				{	
					//Si hay otro objeto movil en esa celda
					ObjetoMovil objetoMovil = celdaNueva.objetoMovil();
					if(objetoMovil!=null)
					{	
						//Le pasa el visitor, si es enemigo lo ataca, si es otro disparo no hace nada.
						objetoMovil.aceptar(new VisitorDisparo(this));
					} 
					else 
					{
						//Guarda la posicion actual
						int xAnterior = celda.getX();
						int yAnterior = celda.getY();
						
						//Cambia de celda
						celda = celdaNueva;

						//Se mueve
						celda.moverEnemigo(xAnterior, yAnterior);

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
