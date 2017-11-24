package nivel;

import java.util.ArrayList;
import java.util.List;

import enemigos.Enemigo;
import estadoMultiplicador.*;

public class Nivel1 extends Nivel{

	public Nivel1() {
		path = "res/niveles/nivel1.txt";
		estado = new EstadoEnemigoNivel1();
	}
	
	protected List<Enemigo> oleada1() {
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		 // primer oleada
		toReturn.addAll(builder.generarZombie(3, estado));
		//toReturn.addAll(builder.generarZombieFrio(8, estado));
		return toReturn;
	}

	@Override
	protected List<Enemigo> oleada2() {
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		toReturn.addAll(builder.generarZombie(3, estado));
		toReturn.addAll(builder.generarZombieFrio(3, estado));
		toReturn.addAll(builder.generarOsoSalvaje(2, estado));
		toReturn.addAll(builder.generarSalvaje(1, estado));
		toReturn.addAll(builder.generarGigante(1, estado));
		toReturn.addAll(builder.generarDragon(1, estado));
		return toReturn;
	}

	@Override
	protected List<Enemigo> oleada3() {
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		toReturn.addAll(builder.generarZombie(3, estado));
		toReturn.addAll(builder.generarZombieFrio(3, estado));
		toReturn.addAll(builder.generarOsoSalvaje(2, estado));
		toReturn.addAll(builder.generarSalvaje(1, estado));
		toReturn.addAll(builder.generarGigante(1, estado));
		toReturn.addAll(builder.generarDragon(1, estado));
		return toReturn;
	}
}