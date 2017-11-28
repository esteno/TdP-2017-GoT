package defensa;

import objetos.GameObjectGrafico;

public class Ygritte extends DefensaRango {
	
	// Crea un objeto con velocidad de ataque, vida, daño y un grafico determinados
	public Ygritte() {
		velocidadAtaque = 5;
		proximoAtaque = 0;
		puntosVida = puntosVidaInicio = 250;
		fuerzaImpacto = fuerzaImpactoInicio = 30;
		grafico = fabricaGrafica.construirGraficoYgritte();
	}
	
	// Construye el grafico del disparo de este personaje
	protected GameObjectGrafico getGraficoDisparo() {
		return fabricaGrafica.construirGraficoDisparoYgritte();
	}
}