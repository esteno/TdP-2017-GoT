package obstaculo;

public class Trinchera extends Obstaculo {
	
	public Trinchera(){
		precio = 120;
		velocidadAtaque = 0;
		proximoAtaque = 0;
		puntosVida = 220;
		fuerzaImpacto = 0;
		grafico = fabricaGrafica.construirGraficoTrinchera();
	}

}
