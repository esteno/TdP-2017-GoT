package colisiones;

import defensa.Explosivo;
import enemigos.Enemigo;
import objetos.GameObject;

public class VisitorExplosivo extends Visitor {
	
	Explosivo miExplosivo;
	
	public VisitorExplosivo(Explosivo explosivo) {
		miExplosivo = explosivo;
	}

	@Override
	public void visitarDefensa(GameObject d) {
		d.recibirAtaque(miExplosivo.getFuerzaImpacto());

	}

	@Override
	public void visitarEnemigo(Enemigo e) {
		e.recibirAtaque(miExplosivo.getFuerzaImpacto());

	}

}
