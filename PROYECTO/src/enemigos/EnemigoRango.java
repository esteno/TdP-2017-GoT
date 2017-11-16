package enemigos;

import disparos.DisparoEnemigo;

public abstract class EnemigoRango extends Enemigo
{

	public void atacar() {
		celda.agregarDisparo(new DisparoEnemigo(fuerzaImpacto));
	}
}
