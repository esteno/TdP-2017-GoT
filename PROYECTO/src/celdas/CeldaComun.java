package celdas;

import mapa.Mapa;

public class CeldaComun extends Celda {
	
	public CeldaComun(Mapa m, int y, int x) {
		super(m, y, x);
		multiVelocidad = 1;
    	grafica = fabricaGrafica.construirGraficoCeldaComun();
		
	}

}
