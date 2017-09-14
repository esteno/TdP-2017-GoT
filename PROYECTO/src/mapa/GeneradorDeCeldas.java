package mapa;

import java.util.Random;

import celdas.*;

public class GeneradorDeCeldas {
	
	private static GeneradorDeCeldas instancia = null;
	
	private GeneradorDeCeldas() {
	}
	
	public static GeneradorDeCeldas instancia() {
		if(instancia == null) {
			instancia = new GeneradorDeCeldas();
		}
		return instancia;
	}
	
	public Celda generar(Mapa m, int y, int x) {
		double rand = Math.random();
		if(rand < 0.4) 
			return new CeldaComun(m, y, x);
		if(rand < 0.7) 
			return new CeldaLago(m, y, x);
		
		return new CeldaArena(m, y, x);
	}

}
