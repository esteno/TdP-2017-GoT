package celdas;

import mapa.Mapa;

public class CeldaLago extends Celda {
	
	public CeldaLago(Mapa m, int y, int x) {
		super(m, y, x);
    	grafica = fabricaGrafica.construirGraficoCeldaLago();
		
	}

}
