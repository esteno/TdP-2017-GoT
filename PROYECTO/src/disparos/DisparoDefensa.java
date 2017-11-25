package disparos;

import celdas.Celda;
import colisiones.Visitor;
import colisiones.VisitorDisparoDefensa;
import enemigos.Enemigo;
import objetos.GameObjectGrafico;
import objetos.ObjetoMovil;

public class DisparoDefensa extends Disparo {

	public DisparoDefensa(GameObjectGrafico graf, double danio) {
		super(graf,danio);
		velocidad = 4;
		visitor = new VisitorDisparoDefensa(this);
	}

	public void avanzar() {
		//Pide la celda a la que se va a mover
		if(contVelocidad == 0) {
			Celda celdaNueva = celda.celdaDerecha();
			//Si todavia tiene alcance y no llego al 
			if( (alcance > 0) && (celdaNueva != null) ) 
			{	 
				//Cambia de celda
				celda = celdaNueva;
				//Decrementa el alcance
				alcance--;
				contVelocidad = velocidad;
				celda.moverGrafico(this);
			}
			else
				destruir();
		}
		contVelocidad--;
	}

	@Override
	public void atacar() {
		//Si hay otro objeto movil en esa celda
		Enemigo enemigo = celda.getEnemigo();
		if(enemigo!=null)
			//Le pasa el visitor, si es enemigo lo ataca, si es otro disparo no hace nada.
			enemigo.aceptar(visitor);
	}



	@Override
	public void aceptar(Visitor v) {
	}
}