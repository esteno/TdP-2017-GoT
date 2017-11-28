package nivel;

import java.util.List;

import enemigos.Enemigo;
import estadoMultiplicador.EstadoEnemigoNivel3;

public class Nivel3 extends Nivel{
	
	public Nivel3() {
		path = "res/niveles/nivel3.txt";
		estado = new EstadoEnemigoNivel3();
	}

	@Override
	protected List<Enemigo> oleada1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Enemigo> oleada2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Enemigo> oleada3() {
		// TODO Auto-generated method stub
		return null;
	}

}
