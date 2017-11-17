package colisiones;

import defensa.Defensa;
import disparos.DisparoEnemigo;
import enemigos.Enemigo;
import objetos.GameObject;

public class VisitorDisparoEnemigo extends Visitor {
	
	private DisparoEnemigo miDisparo;
	
	public VisitorDisparoEnemigo(DisparoEnemigo disparo) {
		miDisparo = disparo;
	}

	@Override
	public void visitarDefensa(Defensa d) {
		System.out.println("atacar defensa");
		d.recibirAtaque(miDisparo.getFuerzaImpacto());
		miDisparo.destruir();

	}

	@Override
	public void visitarEnemigo(Enemigo e) {
		// TODO Auto-generated method stub

	}

}
