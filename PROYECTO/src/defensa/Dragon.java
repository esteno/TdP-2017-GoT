package defensa;

public class Dragon extends DefensaRango {

	public Dragon() 
	{	
		velocidadAtaque = 8;
		proximoAtaque = 0;
		puntosVida = 400;
		fuerzaImpacto = 100;
		precio = 450;
		grafico = fabricaGrafica.construirGraficoDragon();
	}

}
