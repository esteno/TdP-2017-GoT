package enemigos;

import objetos.GameObjectGrafico;

public class Dragon extends EnemigoRango {
	public Dragon() {
		grafico = fabricaGrafica.construirDragon();
		fuerzaImpacto = 100;
	    velocidad = contVelocidad = -4;
	    puntos=100;
	    puntosVida=25;
	    oro=20;
	    velocidadAtaque = 10;
	    proximoAtaque = 0;
	    alto = 2;
	}

	@Override
	protected GameObjectGrafico getGraficoDisparo() {
		return fabricaGrafica.construirGraficoDisparoDragon();
	}
	

}