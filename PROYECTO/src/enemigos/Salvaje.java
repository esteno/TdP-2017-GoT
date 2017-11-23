package enemigos;

public class Salvaje extends EnemigoCuerpo {
	
	public Salvaje(){
		grafico = fabricaGrafica.construirSalvaje();
		fuerzaImpacto = 1000;
	    velocidad = contVelocidad = 1000;
	    puntos=100;
	    puntosVida=75;
	    oro=50;
	}

}