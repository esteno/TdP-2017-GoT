package nivel;

import java.util.ArrayList;
import java.util.List;

import enemigos.Enemigo;
import estadoMultiplicador.EstadoEnemigoNivel1;
import logica.BuilderDeOleadas;

public class Nivel2 extends Nivel
{

	public Nivel2() {
		path = "res/niveles/nivel2.txt";
		estado = new EstadoEnemigoNivel1();
	}
	
	@Override
	public List<Enemigo> getOleada()
	{
		BuilderDeOleadas builder = BuilderDeOleadas.getInstancia();
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		toReturn.addAll(builder.generarZombie(10, estado));
		System.out.println("Oledadas de Nivel 2");
		return toReturn;
	}
	
}
