package defensa;

import objetos.GameObjectGrafico;

public class Ygritte extends DefensaRango {
	
	public Ygritte() {
		velocidadAtaque = 5;
		proximoAtaque = 0;
		puntosVida = puntosVidaInicio = 250;
		fuerzaImpacto = fuerzaImpactoInicio = 30;
		grafico = fabricaGrafica.construirGraficoYgritte();
	}
	
	protected GameObjectGrafico getGraficoDisparo() {
		return fabricaGrafica.construirGraficoDisparoYgritte();
	}
}