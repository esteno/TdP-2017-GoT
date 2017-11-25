package defensa;

public class Gendry extends DefensaCuerpo {
	
	public Gendry(){
		velocidadAtaque = 3;
		proximoAtaque = 0;
		puntosVida = puntosVidaInicio = 250;
		fuerzaImpacto = fuerzaImpactoInicio = 55;
		grafico = fabricaGrafica.construirGraficoGendry();
	}
}