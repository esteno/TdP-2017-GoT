package defensa;

public class Dragon extends DefensaRango {

	public Dragon() 
	{	
		precio = 1000;
		velocidadAtaque = 8;
		proximoAtaque = 0;
		puntosVida = 400;
		vidaMaxima=400;
		fuerzaImpacto = 100;

		grafico = fabricaGrafica.construirGraficoDragon();
	}

}
