package obstaculo;

import colisiones.Visitor;

public class Roca extends Obstaculo 
{

	public Roca() 
	{
		// TODO Auto-generated constructor stub
		precio = 90;
		velocidadAtaque = 0;
		proximoAtaque = 0;
		puntosVida = 150;
		fuerzaImpacto = 0;

		grafico = fabricaGrafica.construirGraficoRoca();
	}
	



}
