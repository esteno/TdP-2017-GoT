package colisiones;

import defensa.Defensa;
import disparos.DisparoEnemigo;
import enemigos.Enemigo;

public class VisitorDisparoEnemigo extends Visitor {
	
	private DisparoEnemigo miDisparo;
	
	public VisitorDisparoEnemigo(DisparoEnemigo disparo) {
		miDisparo = disparo;
	}

	@Override
	public void visitarDefensa(Defensa d) {
		d.recibirAtaque(miDisparo.getFuerzaImpacto());
		miDisparo.destruir();
	}

	@Override
	public void visitarEnemigo(Enemigo e) {
	}
}