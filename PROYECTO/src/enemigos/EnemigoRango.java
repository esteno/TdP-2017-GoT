package enemigos;

import disparos.DisparoEnemigo;
import objetos.GameObjectGrafico;

public abstract class EnemigoRango extends Enemigo{

	public void atacar() {
		if(proximoAtaque == 0) {
			celda.agregarDisparo(new DisparoEnemigo(getGraficoDisparo(),fuerzaImpacto));
			proximoAtaque = velocidadAtaque;
		}
		else 
			proximoAtaque--;
	}
	
	protected abstract GameObjectGrafico getGraficoDisparo();
}
