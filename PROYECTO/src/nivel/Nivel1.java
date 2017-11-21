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
		toReturn.addAll(builder.generarZombie(5, estado));
		System.out.println("Oledadas de Nivel 1");
		switch(contOleada)
		{
			case 0: {   // primer oleada
						toReturn.addAll(builder.generarZombie(3, estado));
						toReturn.addAll(builder.generarZombieFrio(3, estado));
						toReturn.addAll(builder.generarOsoSalvaje(2, estado));
						toReturn.addAll(builder.generarSalvaje(1, estado));
						toReturn.addAll(builder.generarGigante(1, estado));
						toReturn.addAll(builder.generarDragon(1, estado));
						break;
					}
			case 1:		// segunda oleada
					{
						toReturn.addAll(builder.generarZombie(3, estado));
						toReturn.addAll(builder.generarZombieFrio(3, estado));
						toReturn.addAll(builder.generarOsoSalvaje(2, estado));
						toReturn.addAll(builder.generarSalvaje(1, estado));
						toReturn.addAll(builder.generarGigante(1, estado));
						toReturn.addAll(builder.generarDragon(1, estado));
						break;
					}
			case 2: 	//	tercer oleada
					{
						toReturn.addAll(builder.generarZombie(3, estado));
						toReturn.addAll(builder.generarZombieFrio(3, estado));
						toReturn.addAll(builder.generarOsoSalvaje(2, estado));
						toReturn.addAll(builder.generarSalvaje(1, estado));
						toReturn.addAll(builder.generarGigante(1, estado));
						toReturn.addAll(builder.generarDragon(1, estado));
						break;
					}
		}	
		return toReturn;
	}

	
		

	
	
}
