package enemigos;

public class Salvaje extends EnemigoCuerpo {
	
	// Crea un salvaje con un grafico, daño, vida, velocidad, puntos, puntos de vida, oro y velocidad de ataque determinados
	public Salvaje(){
		grafico = fabricaGrafica.construirSalvaje();
		fuerzaImpacto = 80;
	    velocidad = contVelocidad = -7;
	    puntos=100;
	    puntosVida=75;
	    oro=50;
	}
}