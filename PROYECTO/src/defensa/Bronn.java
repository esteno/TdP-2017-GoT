package defensa;

public class Bronn extends DefensaRango 
{

	public Bronn() 
	{
		// TODO Auto-generated constructor stub
		velocidadAtaque = 4;
		proximoAtaque = 0;
		puntosVida = 300;
		fuerzaImpacto = 45;
		grafico = fabricaGrafica.construirGraficoBronn();
	}

}
