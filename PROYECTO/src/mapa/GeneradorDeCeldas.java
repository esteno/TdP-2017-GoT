package mapa;


import celdas.*;

/**
 * Clase que genera celdas para el mapa de manera aleatoria.
 * @author Comision 15 TdP
 *
 */
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
	
	//Genera de manera aleatoria en base al Math.random de java segun una proporcion de 0 a 1.
	public Celda generar(Mapa m, int y, int x) {
		double rand = Math.random();
		if(rand < 0.4) 
			return new CeldaComun(m, y, x);
		if(rand < 0.7) 
			return new CeldaLago(m, y, x);
		
		return new CeldaArena(m, y, x);
	}

}
