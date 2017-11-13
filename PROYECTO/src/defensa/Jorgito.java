package defensa;

import colisiones.VisitorDefensa;
import objetos.GameObjectGrafico;

public class Jorgito extends DefensaCuerpo {
	

	public Jorgito() {

		velocidadAtaque = 5;
		proximoAtaque = 0;
		puntosVida = 200;
		grafico = fabricaGrafica.construirGraficoJorgito();
	}
}
