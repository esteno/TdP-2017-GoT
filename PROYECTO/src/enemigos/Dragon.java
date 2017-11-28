package enemigos;

import objetos.GameObjectGrafico;

public class Dragon extends EnemigoRango {
	
	// Crea un dragon con un grafico, daño, vida, velocidad, puntos, puntos de vida, oro y velocidad de ataque determinados
	public Dragon() {
		grafico = fabricaGrafica.construirDragon();
		fuerzaImpacto = 150;
	    velocidad = contVelocidad = -4;
	    puntos=100;
	    puntosVida=250;
	    oro=200;
	    velocidadAtaque = 10;
	    proximoAtaque = 0;
	}

	@Override
	protected GameObjectGrafico getGraficoDisparo() {
		return fabricaGrafica.construirGraficoDisparoDragon();
	}
	

}