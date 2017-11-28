package enemigos;

public class Salvaje extends EnemigoCuerpo {
	
	public Salvaje(){
		grafico = fabricaGrafica.construirSalvaje();
		fuerzaImpacto = 80;
	    velocidad = contVelocidad = -7;
	    puntos=100;
	    puntosVida=75;
	    oro=50;
	}

}