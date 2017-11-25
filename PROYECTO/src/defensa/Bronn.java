package defensa;

import objetos.GameObjectGrafico;

public class Bronn extends DefensaRango 
{

	public Bronn() {
		velocidadAtaque = 4;
		proximoAtaque = 0;
		puntosVida = 300;
		fuerzaImpacto = 45;
		grafico = fabricaGrafica.construirGraficoBronn();
	}

	@Override
	protected GameObjectGrafico getGraficoDisparo() {
		return fabricaGrafica.construirGraficoDisparoBronn();
	}
}