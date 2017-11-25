package enemigos;

public class ZombieFrio extends EnemigoRango {
	
	public ZombieFrio(){
		grafico = fabricaGrafica.construirZombiFrio();
		fuerzaImpacto = 1000;
	    velocidad = contVelocidad = -25;
	    puntos=100;
	    puntosVida=50;
	    oro=30;
	    velocidadAtaque = 100;
	    proximoAtaque = 0;
	    pathDisparo="disparoEnemigo.gif";
	}

}