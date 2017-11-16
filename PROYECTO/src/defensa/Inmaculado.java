package defensa;

public class Inmaculado extends DefensaRango {

	public Inmaculado() 
	{
		precio = 200;
		velocidadAtaque = 4;
		proximoAtaque = 0;
		puntosVida = 290;
		fuerzaImpacto = 45;

		grafico = fabricaGrafica.construirGraficoInmaculado();
	}

}
