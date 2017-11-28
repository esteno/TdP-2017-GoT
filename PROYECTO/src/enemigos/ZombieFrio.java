package enemigos;

import objetos.GameObjectGrafico;

public class ZombieFrio extends EnemigoRango {
	
	// Crea un zombie especial con un grafico, daño, vida, velocidad, puntos, puntos de vida, oro y velocidad de ataque determinados
	public ZombieFrio(){
		grafico = fabricaGrafica.construirZombiFrio();
		fuerzaImpacto = 60;
	    velocidad = contVelocidad = -25;
	    puntos=100;
	    puntosVida=50;
	    oro=30;
	    velocidadAtaque = 100;
	    proximoAtaque = 0;
	}

	@Override
	protected GameObjectGrafico getGraficoDisparo() {
		return fabricaGrafica.construirGraficoDisparoZombieFrio();
	}
}