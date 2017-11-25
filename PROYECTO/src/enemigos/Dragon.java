package enemigos;

public class Dragon extends EnemigoRango {
	public Dragon() {
		grafico = fabricaGrafica.construirDragon();
		fuerzaImpacto = 100;
	    velocidad = contVelocidad = -10;
	    puntos=100;
	    puntosVida=25;
	    oro=20;
	    velocidadAtaque = 10;
	    proximoAtaque = 0;
	}
}