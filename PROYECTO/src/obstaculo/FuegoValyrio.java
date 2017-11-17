package obstaculo;

import java.util.List;


import defensa.Defensa;

public class FuegoValyrio extends Obstaculo
{

	public FuegoValyrio()
	{
		precio = 100;
		velocidadAtaque = 0;
		proximoAtaque = 0;
		puntosVida = 250;
		fuerzaImpacto = 0;

		grafico = fabricaGrafica.construirGraficoFuegoValyrio();
	}
	

}
