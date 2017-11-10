package defensa;

import objetos.GameObjectGrafico;

public class Jorgito extends DefensaRango {
	

	public Jorgito() {
		velocidadAtaque = 3;
		proximoAtaque = 0;
		puntosVida = 200;
		grafico = fabricaGrafica.construirGraficoJorgito();
	}
}
