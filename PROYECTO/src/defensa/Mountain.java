package defensa;

public class Mountain extends DefensaCuerpo 
{

	public Mountain() 
	{
		// TODO Auto-generated constructor stub
		velocidadAtaque = 2;
		proximoAtaque = 0;
		puntosVida = 500;
		fuerzaImpacto = 70;

		grafico = fabricaGrafica.construirGraficoMountain();
	}

}
