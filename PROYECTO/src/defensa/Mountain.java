package defensa;

public class Mountain extends DefensaCuerpo 
{

	public Mountain() 
	{
		// TODO Auto-generated constructor stub
		precio = 500;
		velocidadAtaque = 4;
		proximoAtaque = 0;
		puntosVida = 350;
		vidaMaxima=350;
		fuerzaImpacto = 70;

		grafico = fabricaGrafica.construirGraficoMountain();
	}

}
