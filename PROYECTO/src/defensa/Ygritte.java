package defensa;

public class Ygritte extends DefensaRango 
{

	public Ygritte() 
	{
		// TODO Auto-generated constructor stub
		velocidadAtaque = 5;
		proximoAtaque = 0;
		puntosVida = 250;
		fuerzaImpacto = 30;
		grafico = fabricaGrafica.construirGraficoYgritte();
	}

}
