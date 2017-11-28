package enemigos;

import disparos.DisparoEnemigo;
import objetos.GameObjectGrafico;

public abstract class EnemigoRango extends Enemigo{

	// Si debe atacar, agrega un nuevo disparo en esta celda que se va a mover por la fila
	public void atacar() {
		if(proximoAtaque == 0) {
			celdas.agregarDisparo(new DisparoEnemigo(getGraficoDisparo(),fuerzaImpacto));
			proximoAtaque = velocidadAtaque;
		}
		else 
			proximoAtaque--;
	}
	
	protected abstract GameObjectGrafico getGraficoDisparo();
}
