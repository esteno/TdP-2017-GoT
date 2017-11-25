package defensa;

import javax.swing.JLabel;

import celdas.Celda;

public class Dragon extends DefensaCuerpo
{
	public Dragon() {
		velocidadAtaque = 8;
		proximoAtaque = 0;
		puntosVida = puntosVidaInicio = 400;
		fuerzaImpacto = fuerzaImpactoInicio = 100;
		grafico = fabricaGrafica.construirGraficoDragon();
		///pathDisparo="disparodragon.gif";
	}
}