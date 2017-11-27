package disparos;

import java.util.List;

import celdas.Celda;
import colisiones.Visitor;
import colisiones.VisitorDisparoEnemigo;
import defensa.Defensa;
import objetos.GameObjectGrafico;


public class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(GameObjectGrafico graf,double danio) {
		super(graf,danio);
		velocidad = -8;
		visitor = new VisitorDisparoEnemigo(this);
	}



	@Override
	public void avanzar() {
		
	//Pide la celda a la que se va a mover
		if(contVelocidad == 0) {
			if(alcance > 0) {
				List<Celda> celdasNuevas = celdas.celdaIzquierda();
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
			contVelocidad++;
			}
	}

	public void atacar() {
		for(Celda celda : celdas.getCeldas()) {
			Defensa defensa = celda.getEstatico();
			if(defensa!=null)
				//Le pasa el visitor, si es enemigo lo ataca, si es otro disparo no hace nada.
				defensa.aceptar(visitor);
		}
	}

	@Override
	public void aceptar(Visitor v) {		
	}
}