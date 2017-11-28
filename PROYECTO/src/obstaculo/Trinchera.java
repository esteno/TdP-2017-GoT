package obstaculo;

public class Trinchera extends Obstaculo {
	
	public Trinchera(){
		
		velocidadAtaque = 0;
		proximoAtaque = 0;
		puntosVida = 160;
		fuerzaImpacto = 0;
		grafico = fabricaGrafica.construirGraficoTrinchera();
	}

}
