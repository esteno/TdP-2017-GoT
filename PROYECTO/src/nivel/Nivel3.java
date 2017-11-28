package nivel;

import java.util.ArrayList;
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

		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		toReturn.addAll(builder.generarSalvaje(8, estado));
		return toReturn;
	}

	@Override
	protected List<Enemigo> oleada2() {

		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		toReturn.addAll(builder.generarOsoSalvaje(5, estado));
		toReturn.addAll(builder.generarGigante(2, estado));
		return toReturn;
	}

	@Override
	protected List<Enemigo> oleada3() {

		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		toReturn.addAll(builder.generarOsoSalvaje(3, estado));
		toReturn.addAll(builder.generarSalvaje(5, estado));
		toReturn.addAll(builder.generarGigante(3, estado));
		toReturn.addAll(builder.generarDragon(3, estado));
		return toReturn;
	}

}
