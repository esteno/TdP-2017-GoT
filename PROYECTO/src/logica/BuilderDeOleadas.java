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
	

	
	public List<Enemigo> generarZombi(int cant, EstadoMultiplicador estado) 
	{
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		for(int i = 0; i < cant ; i++) 
		{
			Enemigo enemigo = new Zombi();
			enemigo.setEstado(estado);
			toReturn.add(enemigo);
		}
			
		return toReturn;
	}

	
	public List<Enemigo> generearEnemigos(int cant, EstadoMultiplicador estado)
	{
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		
		int aleatorio;
		
		
		for(int i = 0; i < cant ; i++) 
		{
			aleatorio = (int) (Math.random() *6 ) + 1; 
			
			switch(aleatorio)
			{
			  case 1: // dragon
			        {
			        	//Enemigo enemigo = new Dragon());
						//enemigo.setEstado(estado);
						//toReturn.add(enemigo);
			        }
			  case 2: // gigante
			  		{
			  			//Enemigo enemigo = new Gigante();
						//enemigo.setEstado(estado);
						//toReturn.add(enemigo);
			  		}
			
			  case 3: // oso salvaje
		  		{
		  			Enemigo enemigo = new OsoSalvaje();
					enemigo.setEstado(estado);
					toReturn.add(enemigo);
		  		}
			  case 4: // salvaje
		  		{
		  			Enemigo enemigo = new Salvaje();
					enemigo.setEstado(estado);
					toReturn.add(enemigo);
		  		}
			  case 5: // zombi
		  		{
		  			Enemigo enemigo = new Zombi();
					enemigo.setEstado(estado);
					toReturn.add(enemigo);
		  		}
			  case 6: //zombi frio
		  		{
		  			Enemigo enemigo = new ZombiFrio();
					enemigo.setEstado(estado);
					toReturn.add(enemigo);
		  		}
		
			
			
			}

		}
			
		
		
		
		return toReturn;
	}
	
	

}
