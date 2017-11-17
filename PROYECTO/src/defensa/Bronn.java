package defensa;

public class Bronn extends DefensaRango 
{

	public Bronn() 
	{
		// TODO Auto-generated constructor stub
		precio = 300;
		velocidadAtaque = 5;
		proximoAtaque = 0;
		puntosVida = 260;
		vidaMaxima=260;
		fuerzaImpacto = 45;
		alcance = 0;
		grafico = fabricaGrafica.construirGraficoBronn();
	}

}
