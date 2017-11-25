package defensa;

public class Inmaculado extends DefensaRango {

	public Inmaculado() {
		velocidadAtaque = 7;
		proximoAtaque = 0;
		puntosVida = puntosVidaInicio = 200;
		fuerzaImpacto = fuerzaImpactoInicio = 45;
		grafico = fabricaGrafica.construirGraficoInmaculado();
	}
}