package enemigos;

import objetos.GameObjectGrafico;

public class ZombiFrio extends Enemigo {
	
	public ZombiFrio(){
		grafico = fabricaGrafica.construirZombiFrio();
		fuerza_impacto = 1000;
	    velocidad = contVelocidad = 1000;
	    puntos=100;
	    puntos_vida=5;
	}

}
