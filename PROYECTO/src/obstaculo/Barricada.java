package obstaculo;


public class Barricada extends Obstaculo{
	
	public Barricada(){
		
		// este obstaculo es un premio, por lo cual es el unico que no se puede comprar
		velocidadAtaque = 0;
		proximoAtaque = 0;
		puntosVida = 150;
		fuerzaImpacto = 0;
		grafico = fabricaGrafica.construirGraficoBarricada();
	}
}
