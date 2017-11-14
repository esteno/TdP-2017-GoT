package defensa;

public class Inmaculado extends DefensaRango {

	public Inmaculado() 
	{
		velocidadAtaque = 4;
		proximoAtaque = 0;
		puntosVida = 290;
		fuerzaImpacto = 45;
		precio = 200;
		grafico = fabricaGrafica.construirGraficoInmaculado();
	}

}
