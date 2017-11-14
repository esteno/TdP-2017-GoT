package defensa;

public class Ygritte extends DefensaRango 
{

	public Ygritte() 
	{
		// TODO Auto-generated constructor stub
		velocidadAtaque = 4;
		proximoAtaque = 0;
		puntosVida = 250;
		fuerzaImpacto = 40;
		precio = 600;
		alcance = 0;
		grafico = fabricaGrafica.construirGraficoYgritte();
	}

}
