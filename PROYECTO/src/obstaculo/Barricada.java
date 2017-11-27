package obstaculo;

import java.util.List;

import colisiones.Visitor;
import defensa.Defensa;

public class Barricada extends Obstaculo{
	
	public Barricada()
	{
		// este obstaculo es un premio, por lo cual es el unico que no se puede comprar
		velocidadAtaque = 0;
		proximoAtaque = 0;
		puntosVida = 1500;
		fuerzaImpacto = 0;
		grafico = fabricaGrafica.construirGraficoBarricada();
	}
}
