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
			
			if(celda2!=null){
				Celda celdaIzq2 = celda2.celdaIzquierda();
				Defensa defensa2 = celdaIzq2.getEstatico();
				if(defensa2 != null)
				{
					defensa2.aceptar(visitor);
				}
			}
			
			proximoAtaque = velocidadAtaque;
		}
		else {
			proximoAtaque--;
		}
	}
}