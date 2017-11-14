package defensa;


public class Jorgito extends DefensaCuerpo {
	

	public Jorgito() {

		velocidadAtaque = 5;
		proximoAtaque = 0;
		puntosVida = 200;
		grafico = fabricaGrafica.construirGraficoJorgito();
	}
}
