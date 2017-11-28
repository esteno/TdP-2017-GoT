package obstaculo;



public class Roca extends Obstaculo {

	public Roca() {
		
		velocidadAtaque = 0;
		proximoAtaque = 0;
		puntosVida = 150;
		fuerzaImpacto = 0;
		grafico = fabricaGrafica.construirGraficoRoca();
	}

}
