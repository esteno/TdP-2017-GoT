package enemigos;

public class ZombieFrio extends EnemigoRango {
	
	public ZombieFrio(){
		grafico = fabricaGrafica.construirZombiFrio();
		fuerzaImpacto = 1000;
	    velocidad = contVelocidad = 1000;
	    puntos=100;
	    puntosVida=50;
	    oro=30;
	}

}
