package obstaculo;

import java.util.List;

import colisiones.Visitor;
import defensa.Defensa;

public class Barricada extends Obstaculo
{

	public Barricada()
	{
		precio = 100;
		velocidadAtaque = 0;
		proximoAtaque = 0;
		puntosVida = 150;
		fuerzaImpacto = 0;

		grafico = fabricaGrafica.construirGraficoBarricada();
		
	}

}
