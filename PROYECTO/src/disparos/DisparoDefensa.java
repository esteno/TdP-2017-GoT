package disparos;

import java.util.List;

import celdas.Celda;
import colisiones.Visitor;
import colisiones.VisitorDisparoDefensa;
import enemigos.Enemigo;
import objetos.GameObjectGrafico;

public class DisparoDefensa extends Disparo {

	// Genera un disparo del enemigo con un grafico y daño pasados por parametro
	public DisparoDefensa(GameObjectGrafico graf, double danio) {
		super(graf,danio);
		velocidad = 4;
		visitor = new VisitorDisparoDefensa(this);
	}

	public void avanzar() {
		//Pide la celda a la que se va a mover
		if(contVelocidad == 0) {
			if(alcance > 0) {
				List<Celda> celdasNuevas = celdas.celdaDerecha();
				if(!celdasNuevas.isEmpty()) {
					//Si todavia tiene alcance y no llego al  
					celdas.limpiar();
					for(Celda celdaNueva : celdasNuevas) {
						//Cambia de celda
						celdas.agregarCeldas(celdaNueva);
						//Decrementa el alcance
					}
					alcance--;
					contVelocidad = velocidad;
					celdas.moverGrafico(this);
				}
				else
					destruir();
			}
		}
		else {
			contVelocidad--;
		}
	}

	public void atacar() {
		//Si hay otro objeto movil en esa celda
		for(Celda celda: celdas.getCeldas()) {
			Enemigo enemigo = celda.getEnemigo();
			if(enemigo!=null)
			//Le pasa el visitor, si es enemigo lo ataca, si es otro disparo no hace nada.
			enemigo.aceptar(visitor);
		}
	}

	@Override
	public void aceptar(Visitor v) {
	}
}