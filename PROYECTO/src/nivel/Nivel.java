package nivel;

import java.util.List;

import enemigos.Enemigo;
import estadoMultiplicador.EstadoMultiplicador;

public abstract class Nivel 
{

	//atributos
	protected String path;
	protected EstadoMultiplicador estado;
	
	// metodos

	
	
	public abstract List<Enemigo> getOleada();

	public String getPath() {
		return path;
	}
}
