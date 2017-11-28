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
	
	 // primer oleada
	protected List<Enemigo> oleada1() 
	{
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
	//	toReturn.addAll(builder.generarZombie(3, estado));
		toReturn.addAll(builder.generarZombie(1, estado));
		return toReturn;
	}

	
	// segunda oleada
	@Override
	protected List<Enemigo> oleada2() {
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		//toReturn.addAll(builder.generarZombie(2, estado));
		//toReturn.addAll(builder.generarZombieFrio(2, estado));
		toReturn.addAll(builder.generarZombie(1, estado));
		return toReturn;
	}

	
	// tercer oleada
	@Override
	protected List<Enemigo> oleada3() {
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
<<<<<<< HEAD
		//toReturn.addAll(builder.generarZombieFrio(2, estado));
		//toReturn.addAll(builder.generarZombie(2, estado));
		//toReturn.addAll(builder.generarSalvaje(1, estado));
		toReturn.addAll(builder.generarZombie(1, estado));
=======
		toReturn.addAll(builder.generarZombieFrio(2, estado));
		toReturn.addAll(builder.generarOsoSalvaje(2, estado));
		toReturn.addAll(builder.generarSalvaje(1, estado));
>>>>>>> c8437237736f82772a5c5022ea0222e9b71c76db
		return toReturn;
	}
}