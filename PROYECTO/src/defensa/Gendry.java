package defensa;

public class Gendry extends DefensaCuerpo 
{

	public Gendry()
	{
		// TODO Auto-generated constructor stub
		velocidadAtaque = 3;
		proximoAtaque = 0;
		puntosVida = 250;
		fuerzaImpacto = 55;

		grafico = fabricaGrafica.construirGraficoGendry();
	}

}
