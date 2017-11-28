package nivel;

import java.util.ArrayList;
import java.util.List;

import enemigos.Enemigo;
import estadoMultiplicador.EstadoMultiplicador;
import gui.ConsolaMensajes;
import logica.BuilderDeOleadas;

public abstract class Nivel {
	//atributos
	protected String path;
	protected EstadoMultiplicador estado;
	protected int contOleada = 1;
	protected BuilderDeOleadas builder = BuilderDeOleadas.getInstancia();
	
	// metodos
	public String getPath() {
		return path;
	}
	
	public List<Enemigo> getOleada() {
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		switch(contOleada){
			case 1: 
				toReturn = oleada1();
				break;
			case 2:	
				toReturn = oleada2();
				break;
			case 3:
				toReturn = oleada3();
		}	
		contOleada++;
		return toReturn;
	}
	
	protected abstract List<Enemigo> oleada1();
	
	protected abstract List<Enemigo> oleada2();
	
	protected abstract List<Enemigo> oleada3();
	
}
