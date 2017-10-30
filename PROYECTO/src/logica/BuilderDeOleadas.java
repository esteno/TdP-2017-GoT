package logica;


import java.util.ArrayList;
import java.util.List;

import enemigos.*;
import estadoEnemigo.EstadoEnemigo;
import objetos.ObjetoMovil;

public class BuilderDeOleadas{
	
	private static BuilderDeOleadas instancia = null;
	
	
	private BuilderDeOleadas() {
	}

	public static BuilderDeOleadas getInstancia() {
		if(instancia == null) {
			instancia = new BuilderDeOleadas();
		}
		return instancia;
	}
	
	public List<Enemigo> generarEnemigoRojo(int cant, EstadoEnemigo estado) {
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		for(int i = 0; i < cant ; i++) {
			Enemigo enemigo = new EnemigoRojo();
			enemigo.setEstado(estado);
			toReturn.add(enemigo);
		}
			
		return toReturn;
	}
	
	public List<Enemigo> generarZombi1(int cant, EstadoEnemigo estado) {
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		for(int i = 0; i < cant ; i++) {
			Enemigo enemigo = new EnemigoRojo();
			enemigo.setEstado(estado);
			toReturn.add(enemigo);
		}
			
		return toReturn;
	}

	
	

}
