package defensa;

import javax.swing.JLabel;

import celdas.Celda;
import objetos.GameObjectGrafico;

public class Dragon extends DefensaRango
{
	public Dragon() {
		velocidadAtaque = 8;
		proximoAtaque = 0;
		puntosVida = puntosVidaInicio = 400;
		fuerzaImpacto = fuerzaImpactoInicio = 100;
		grafico = fabricaGrafica.construirGraficoDragon();
	}


	protected GameObjectGrafico getGraficoDisparo() {
		return fabricaGrafica.construirDisparoDragonDef();
	}
}