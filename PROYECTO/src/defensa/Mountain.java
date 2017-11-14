package defensa;

public class Mountain extends DefensaCuerpo 
{

	public Mountain() 
	{
		// TODO Auto-generated constructor stub
		velocidadAtaque = 4;
		proximoAtaque = 0;
		puntosVida = 350;
		fuerzaImpacto = 70;
		precio = 500;
		grafico = fabricaGrafica.construirGraficoMountain();
	}

}
