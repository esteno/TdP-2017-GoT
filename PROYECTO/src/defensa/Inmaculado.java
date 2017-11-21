package defensa;

public class Inmaculado extends DefensaRango {

	public Inmaculado() 
	{
		velocidadAtaque = 7;
		proximoAtaque = 0;
		puntosVida = 200;
		fuerzaImpacto = 45;

		grafico = fabricaGrafica.construirGraficoInmaculado();
	}

}
