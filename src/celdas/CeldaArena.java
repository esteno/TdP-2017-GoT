package celdas;

import mapa.Mapa;

public class CeldaArena extends Celda {
	
	public CeldaArena(Mapa m, int y, int x) {
		super(m, y, x);
    	grafica = fabricaGrafica.construirGraficoCeldaArena();
		
	}

}
