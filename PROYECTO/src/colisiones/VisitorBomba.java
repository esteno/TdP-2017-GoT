package colisiones;

import defensa.Defensa;
import enemigos.Enemigo;
import premio.Bomba;

public class VisitorBomba extends Visitor {
	
	protected Bomba bomba;
	
	public VisitorBomba(Bomba b) {
		bomba = b;
	}

	@Override
	public void visitarDefensa(Defensa d) 
	{
		d.recibirAtaque(d.getPuntosVida()+1);
	}

	@Override
	public void visitarEnemigo(Enemigo e) 
	{
		e.recibirAtaque(e.getPuntosVida()+1);
	}

}
