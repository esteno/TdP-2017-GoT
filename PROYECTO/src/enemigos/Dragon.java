package enemigos;

import objetos.GameObjectGrafico;

public class Dragon extends EnemigoRango {
	public Dragon() {
		grafico = fabricaGrafica.construirDragon();
		fuerzaImpacto = 100;
	    velocidad = contVelocidad = -4;
	    puntos=100;
	    puntosVida=25;
	    oro=200;
	    velocidadAtaque = 10;
	    proximoAtaque = 0;
	}

	@Override
	protected GameObjectGrafico getGraficoDisparo() {
		return fabricaGrafica.construirGraficoDisparoDragon();
	}
	

}