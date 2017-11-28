package defensa;

public class Gendry extends DefensaCuerpo {
	
	// Crea un objeto con velocidad de ataque, vida, daño y un grafico determinados
	public Gendry(){
		velocidadAtaque = 3;
		proximoAtaque = 0;
		puntosVida = puntosVidaInicio = 250;
		fuerzaImpacto = fuerzaImpactoInicio = 55;
		grafico = fabricaGrafica.construirGraficoGendry();
	}
}