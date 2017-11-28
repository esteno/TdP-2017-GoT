package nivel;

import java.util.ArrayList;
import java.util.List;

import enemigos.Enemigo;
import estadoMultiplicador.EstadoEnemigoNivel2;

public class Nivel2 extends Nivel{

	public Nivel2() {
		path = "res/niveles/nivel2.txt";
		estado = new EstadoEnemigoNivel2();
	}
	
	@Override
	protected List<Enemigo> oleada1() {
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		toReturn.addAll(builder.generarSalvaje(1, estado));
		toReturn.addAll(builder.generarZombie(1, estado));
		toReturn.addAll(builder.generarZombieFrio(1, estado));
		return toReturn;
	}

	@Override
	protected List<Enemigo> oleada2() {
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		toReturn.addAll(builder.generarOsoSalvaje(1, estado));
		toReturn.addAll(builder.generarZombie(1, estado));
		toReturn.addAll(builder.generarGigante(1, estado));
		toReturn.addAll(builder.generarDragon(1, estado));
		return toReturn;
	}

	@Override
	protected List<Enemigo> oleada3() {
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		toReturn.addAll(builder.generarOsoSalvaje(1, estado));
		toReturn.addAll(builder.generarSalvaje(1, estado));
		toReturn.addAll(builder.generarGigante(2, estado));
		toReturn.addAll(builder.generarDragon(1, estado));
		return toReturn;
	}
}
