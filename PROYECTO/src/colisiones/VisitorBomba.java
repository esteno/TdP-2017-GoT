package colisiones;

import defensa.Bomba;
import enemigos.Enemigo;
import objetos.GameObject;

public class VisitorBomba extends Visitor {
	
	protected Bomba bomba;
	
	public VisitorBomba(Bomba b) {
		bomba = b;
	}

	@Override
	public void visitarDefensa(GameObject d) {
		d.recibirAtaque(bomba.getFuerzaImpacto());

	}

	@Override
	public void visitarEnemigo(Enemigo e) {
		e.recibirAtaque(bomba.getFuerzaImpacto());

	}

}
