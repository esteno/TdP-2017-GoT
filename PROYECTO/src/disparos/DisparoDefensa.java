package disparos;

import celdas.Celda;
import colisiones.Visitor;
import colisiones.VisitorDisparoDefensa;
import enemigos.Enemigo;
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
		//Pide la celda a la que se va a mover
		
		if(contVelocidad == 0) {
			Celda celdaNueva = celda.celdaDerecha();
			System.out.println(celdaNueva);
			//Si todavia tiene alcance y no llego al 
			if( (alcance > 0) && (celdaNueva != null) ) 
			{	 
				//Cambia de celda
				celda = celdaNueva;
				//Decrementa el alcance
				alcance--;
				contVelocidad = velocidad;
			}
			else
			{
				destruir();
			}
			
		}
		contVelocidad--;
		celda.moverGrafico(this);
	}



	@Override
	public void atacar() {
		//Si hay otro objeto movil en esa celda
		System.out.println(celda);
		Enemigo enemigo = celda.getEnemigo();
		System.out.println(enemigo);
		if(enemigo!=null)
		{	
			//Le pasa el visitor, si es enemigo lo ataca, si es otro disparo no hace nada.
			enemigo.aceptar(visitor);
		}
	}



	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
