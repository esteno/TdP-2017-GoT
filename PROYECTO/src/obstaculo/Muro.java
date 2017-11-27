package obstaculo;

public class Muro extends Obstaculo{

	public Muro()
	{	
		velocidadAtaque = 0;
		proximoAtaque = 0;
		puntosVida = 110;
		fuerzaImpacto = 0;
		grafico = fabricaGrafica.construirGraficoMuro();
	}
}
