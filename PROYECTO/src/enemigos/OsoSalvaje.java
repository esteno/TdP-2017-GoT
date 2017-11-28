package enemigos;

public class OsoSalvaje extends EnemigoCuerpo {

	// Crea un oso con un grafico, daño, vida, velocidad,, puntos de vida, oro y velocidad de ataque determinados
	public OsoSalvaje(){
		grafico = fabricaGrafica.construirOsoSalvaje();
		fuerzaImpacto = 150;
	    velocidad = contVelocidad = -30;
	    puntos=100;
	    puntosVida=150;
	    oro=100;
	    velocidadAtaque = 20;
	    proximoAtaque = 0;
	}

}