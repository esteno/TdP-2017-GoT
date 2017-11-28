package defensa;

import objetos.GameObjectGrafico;

public class Bronn extends DefensaRango {

	// Crea un objeto con velocidad de ataque, vida, daño y un grafico determinados
	public Bronn() {
		velocidadAtaque = 4;
		proximoAtaque = 0;
		puntosVida = 300;
		fuerzaImpacto = 45;
		grafico = fabricaGrafica.construirGraficoBronn();
	}

	// Construye el grafico del disparo de este personaje
	protected GameObjectGrafico getGraficoDisparo() {
		return fabricaGrafica.construirGraficoDisparoBronn();
	}
}