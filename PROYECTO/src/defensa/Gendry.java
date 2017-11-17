package defensa;

public class Gendry extends DefensaCuerpo 
{

	public Gendry()
	{
		// TODO Auto-generated constructor stub
		precio = 400;
		velocidadAtaque = 4;
		proximoAtaque = 0;
		puntosVida = 250;
		vidaMaxima=250;
		fuerzaImpacto = 55;

		grafico = fabricaGrafica.construirGraficoGendry();
	}

}
