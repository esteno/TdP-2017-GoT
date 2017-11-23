package enemigos;

import celdas.Celda;
import defensa.Defensa;
import objetos.GameObject;

public abstract class EnemigoCuerpo extends Enemigo {
	
	public void atacar() {
		if(proximoAtaque == 0 ) {
			Celda celdaIzq = celda.celdaIzquierda();
			Defensa defensa = celdaIzq.getEstatico();
			if(defensa != null) {
				visitor.visitarDefensa(defensa);
				atacando=true;
			}
			else
				atacando=false;
			
			proximoAtaque = velocidadAtaque;
		}
		else {
			proximoAtaque--;
		}
	}
}