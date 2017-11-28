package defensa;


import objetos.GameObjectGrafico;

public class Dragon extends DefensaRango{
	
	// Crea un objeto con velocidad de ataque, vida, daño y un grafico determinados
	public Dragon() {
		velocidadAtaque = 8;
		proximoAtaque = 0;
		puntosVida = puntosVidaInicio = 400;
		fuerzaImpacto = fuerzaImpactoInicio = 100;
		grafico = fabricaGrafica.construirGraficoDragon();
	}

	// Construye el grafico del disparo de este personaje
	protected GameObjectGrafico getGraficoDisparo() {
		return fabricaGrafica.construirDisparoDragonDef();
	}
}