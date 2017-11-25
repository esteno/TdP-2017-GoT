package colisiones;

import defensa.Bomba;
import defensa.Defensa;
import enemigos.Enemigo;
import objetos.GameObject;

public class VisitorBomba extends Visitor {
	
	protected Bomba bomba;
	
	public VisitorBomba(Bomba b) {
		bomba = b;
	}

	@Override
	public void visitarDefensa(Defensa d) {
		d.destruir();

	}

	@Override
	public void visitarEnemigo(Enemigo e) {
		e.destruir();

	}

}
