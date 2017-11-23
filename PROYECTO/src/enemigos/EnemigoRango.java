package enemigos;

import disparos.DisparoEnemigo;

public abstract class EnemigoRango extends Enemigo{

	public void atacar() {
		if(proximoAtaque == 0) {
			celda.agregarDisparo(new DisparoEnemigo(fuerzaImpacto));
			proximoAtaque = velocidadAtaque;
		}
		else 
			proximoAtaque--;
	}
}
