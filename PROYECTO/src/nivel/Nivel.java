package nivel;

import logica.Juego;

public abstract class Nivel 
{

	//atributos
	protected Juego juego;
	
	
	//
	public Nivel()
	{}
	
	// metodos
	public abstract Nivel getSiguienteNivel();
	
	public abstract void crearNivel();
}
