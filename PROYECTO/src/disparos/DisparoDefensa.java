package disparos;

import celdas.Celda;
import colisiones.Visitor;
import colisiones.VisitorDisparoDefensa;
import objetos.ObjetoMovil;

public class DisparoDefensa extends Disparo {

	public DisparoDefensa(double danio) {
		super(danio);
		System.out.println("creado disparo defensa");
		velocidad = 4;
		visitor = new VisitorDisparoDefensa(this);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void avanzar() 
	{
		if(contVelocidad == 0) {
		
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
					objetoMovil.aceptar(new VisitorDisparoDefensa(this));
				} 
				else 
				{
					//Cambia de celda
					celda = celdaNueva;

					//Decrementa el alcance
					alcance--;
					
					
				}
			}
			else
			{
				destruir();
			}
			contVelocidad = velocidad;
		}
		else
			contVelocidad--;
		celda.moverGrafico(this);
	}



	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
