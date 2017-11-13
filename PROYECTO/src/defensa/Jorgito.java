package defensa;

import objetos.GameObjectGrafico;

public class Jorgito extends DefensaRango {
	

	public Jorgito() {
		velocidadAtaque = 5;
		proximoAtaque = 0;
		puntosVida = 200;
		grafico = fabricaGrafica.construirGraficoJorgito();
	}
}
