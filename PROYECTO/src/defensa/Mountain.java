package defensa;



public class Mountain extends DefensaCuerpo {
	
	// Crea un objeto con velocidad de ataque, vida, daño y un grafico determinados
	public Mountain() {
		velocidadAtaque = 2;
		proximoAtaque = 0;
		puntosVida = puntosVidaInicio = 500;
		fuerzaImpacto = fuerzaImpactoInicio = 70;
		grafico = fabricaGrafica.construirGraficoMountain();
		alto = 2;
	}
}