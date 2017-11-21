package logica;


import java.util.ArrayList;
import java.util.List;

import enemigos.*;
import estadoMultiplicador.EstadoMultiplicador;
import objetos.ObjetoMovil;

/**
 * Fabrica de oleadas de enemigos
 * @author Comision 15
 *
 */
public class BuilderDeOleadas {
	
	//Atributo estatico para el singleton
	private static BuilderDeOleadas instancia = null;
	
	
	private BuilderDeOleadas() {
	}

	public static BuilderDeOleadas getInstancia() {
		if(instancia == null) {
			instancia = new BuilderDeOleadas();
		}
		return instancia;
	}
	
	//Todos los metodos devuelven una lista con la cantidad pedida de un tipo particular de enemigo
	

	
	public List<Enemigo> generarZombie(int cant, EstadoMultiplicador estado) 
	{
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		for(int i = 0; i < cant ; i++) 
		{
			Enemigo enemigo = new Zombie();
			enemigo.setEstado(estado);
			toReturn.add(enemigo);
		}
		return toReturn;
	}

	
	
	public List<Enemigo> generarZombieFrio(int cant, EstadoMultiplicador estado) 
	{
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		for(int i = 0; i < cant ; i++) 
		{
			Enemigo enemigo = new ZombieFrio();
			enemigo.setEstado(estado);
			toReturn.add(enemigo);
		}
		return toReturn;
	}
	
	
	public List<Enemigo> generarSalvaje(int cant, EstadoMultiplicador estado) 
	{
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		for(int i = 0; i < cant ; i++) 
		{
			Enemigo enemigo = new Salvaje();
			enemigo.setEstado(estado);
			toReturn.add(enemigo);
		}
		return toReturn;
	}
	
	
	public List<Enemigo> generarDragon(int cant, EstadoMultiplicador estado) 
	{
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		for(int i = 0; i < cant ; i++) 
		{
			Enemigo enemigo = new Dragon();
			enemigo.setEstado(estado);
			toReturn.add(enemigo);
		}
		return toReturn;
	}
	
	
	public List<Enemigo> generarGigante(int cant, EstadoMultiplicador estado) 
	{
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		for(int i = 0; i < cant ; i++) 
		{
			Enemigo enemigo = new Gigante();
			enemigo.setEstado(estado);
			toReturn.add(enemigo);
		}
		return toReturn;
	}
	
	
	public List<Enemigo> generarOsoSalvaje(int cant, EstadoMultiplicador estado) 
	{
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		for(int i = 0; i < cant ; i++) 
		{
			Enemigo enemigo = new OsoSalvaje();
			enemigo.setEstado(estado);
			toReturn.add(enemigo);
		}
		return toReturn;
	}
	
}
