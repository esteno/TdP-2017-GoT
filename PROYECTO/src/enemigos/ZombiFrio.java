package enemigos;

public class ZombiFrio extends Enemigo {
	
	public ZombiFrio(){
		grafico = fabricaGrafica.construirZombiFrio();
		fuerzaImpacto = 1000;
	    velocidad = contVelocidad = 1000;
	    puntos=100;
	    puntosVida=50;
	    oro=30;
	}

}
