package celdas;

import mapa.Mapa;

public class CeldaLago extends Celda {
	
	public CeldaLago(Mapa m, int y, int x) {
		super(m, y, x);
		multiVelocidad = 0.5;
    	grafica = fabricaGrafica.construirGraficoCeldaLago();
		
	}

}
