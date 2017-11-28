package enemigos;

public class Gigante extends EnemigoCuerpo{

		
	// Crea un gigante con un grafico, da�o, vida, velocidad, puntos, puntos de vida, oro, velocidad de ataque y tama�o determinados.
	public Gigante() {
			proximoAtaque = 0;
			puntosVida = 200;
			fuerzaImpacto = 100;
			grafico = fabricaGrafica.construirGigante();
		    velocidad = contVelocidad = -30;
		    puntos=100;
		    oro=300;
		    velocidadAtaque = 20;
		    alto = 2;
		}
	

}