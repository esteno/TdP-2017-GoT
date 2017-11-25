package enemigos;

import disparos.DisparoEnemigo;

public abstract class EnemigoRango extends Enemigo{

	protected String pathDisparo;
	public void atacar() {
		if(proximoAtaque == 0) {
			celda.agregarDisparo(new DisparoEnemigo(pathDisparo,fuerzaImpacto));
			proximoAtaque = velocidadAtaque;
		}
		else 
			proximoAtaque--;
	}
}
