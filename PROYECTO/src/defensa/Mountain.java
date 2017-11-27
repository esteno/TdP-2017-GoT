package defensa;

import javax.swing.JLabel;

import celdas.Celda;

public class Mountain extends DefensaCuerpo {
	
	public Mountain() {
		velocidadAtaque = 2;
		proximoAtaque = 0;
		puntosVida = puntosVidaInicio = 500;
		fuerzaImpacto = fuerzaImpactoInicio = 70;
		grafico = fabricaGrafica.construirGraficoMountain();
		alto = 2;
	}
}