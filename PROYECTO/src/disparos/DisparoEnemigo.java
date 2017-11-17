package disparos;

import celdas.Celda;
import colisiones.Visitor;
import colisiones.VisitorDisparoEnemigo;
import defensa.Defensa;


public class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(double danio) {
		super(danio);
		velocidad = -8;
		visitor = new VisitorDisparoEnemigo(this);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void avanzar() 
	{
		// TODO Auto-generated method stub
		if(contVelocidad == 0) {
			//Pide la celda a la que se va a mover
			Celda celdaIzquierda = celda.celdaIzquierda();
			//Si todavia tiene alcance y no llego al 
			if( (alcance > 0) && (celdaIzquierda != null) ) 
			{	
				//Cambia de celda
				celda = celdaIzquierda;
				//Decrementa el alcance
				alcance--;
				contVelocidad = velocidad;
			}
			else
			{
				destruir();
			}
			
		}
		contVelocidad++;
		
		celda.moverGrafico(this);
	}

	public void atacar() {
		Defensa defensa = celda.getEstatico();
		if(defensa!=null)
		{	
			System.out.println("Disapro enemigo atacar defensa");
			//Le pasa el visitor, si es enemigo lo ataca, si es otro disparo no hace nada.
			defensa.aceptar(visitor);
		} 
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
