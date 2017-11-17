package enemigos;

import celdas.Celda;
import objetos.GameObject;

public abstract class EnemigoCuerpo extends Enemigo 
{

	public void atacar() {
		if(proximoAtaque == 0 ) {
			Celda celdaIzq = celda.celdaIzquierda();
			GameObject defensa = celdaIzq.getEstatico();
			if(defensa != null) {
				visitor.visitarDefensa(defensa);
				atacando=true;
				System.out.println("Atacaaaa");
			}
			else atacando=false;
			proximoAtaque = velocidadAtaque;
		}
		else {
			proximoAtaque--;
		}
	}
	

	

}
