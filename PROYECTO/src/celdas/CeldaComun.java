package celdas;

import mapa.Mapa;

public class CeldaComun extends Celda {
	
	public CeldaComun(Mapa m, int y, int x) {
		super(m, y, x);
    	grafica = new CeldaGrafica("res/imagenes/celda/terreno.png");
		
	}

}
