package nivel;

import java.util.ArrayList;
import java.util.List;

import enemigos.Enemigo;
import estadoMultiplicador.*;
import logica.BuilderDeOleadas;

public class Nivel1 extends Nivel
{
	
	
	
	public Nivel1() {
		path = "res/niveles/nivel1.txt";
		estado = new EstadoEnemigoNivel1();
		
	}

	@Override
	public List<Enemigo> getOleada() 
	{
		BuilderDeOleadas builder = BuilderDeOleadas.getInstancia();
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
<<<<<<< HEAD
		toReturn.addAll(builder.generarZombie(5, estado));
=======
		toReturn.addAll(builder.generarZombi(1, estado));
		//toReturn.addAll(builder.generarEnemigos( 5, estado));
>>>>>>> a99e4a95b6feb361d763922404f95c9ca600be53
		System.out.println("Oledadas de Nivel 1");
		return toReturn;
	}

}
