package nivel;

import java.util.ArrayList;
import java.util.List;

import enemigos.Enemigo;
import estadoEnemigo.*;
import logica.BuilderDeOleadas;

public class Nivel1 extends Nivel
{
	
	
	
	public Nivel1() {
		path = "res/niveles/nivel1.txt";
		estado = new EstadoEnemigoNivel1();
		
	}

	@Override
	public List<Enemigo> getOleada() {
		BuilderDeOleadas builder = BuilderDeOleadas.getInstancia();
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		toReturn.addAll(builder.generarZombi(2, estado));
		return toReturn;
	}

}
