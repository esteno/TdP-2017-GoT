package nivel;

import java.util.List;

import enemigos.Enemigo;
import estadoEnemigo.EstadoEnemigo;

public abstract class Nivel 
{

	//atributos
	protected String path;
	protected EstadoEnemigo estado;
	
	// metodos

	
	
	public abstract List<Enemigo> getOleada();

	public String getPath() {
		return path;
	}
}
