package defensa;

import javax.swing.JLabel;

import celdas.Celda;

public class Dragon extends DefensaRango
{
	public Dragon() {	
		velocidadAtaque = 8;
		proximoAtaque = 0;
		puntosVida = 400;
		fuerzaImpacto = 100;
		grafico = fabricaGrafica.construirGraficoDragon();
	}
}