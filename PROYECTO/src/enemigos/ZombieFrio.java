package enemigos;

import objetos.GameObjectGrafico;

public class ZombieFrio extends EnemigoRango {
	
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