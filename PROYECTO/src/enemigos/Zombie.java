package enemigos;

public class Zombie extends EnemigoCuerpo {
	
	// Crea un zombie con un grafico, daño, vida, velocidad, puntos, puntos de vida, oro y velocidad de ataque determinados
	public Zombie(){
		grafico = fabricaGrafica.construirGraficoZombi();
		fuerzaImpacto = 20;
	    velocidad = contVelocidad = -20;
	    puntos=100;
	    puntosVida=25;
	    oro=20;
	    velocidadAtaque = 10;
	    proximoAtaque = 0;
	}

}
