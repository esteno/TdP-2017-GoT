package enemigos;

public class Zombi extends EnemigoCuerpo {
	
	public Zombi(){
		grafico = fabricaGrafica.construirGraficoZombi();
		fuerzaImpacto = 1000;
	    velocidad = contVelocidad = -10;
	    puntos=100;
	    puntosVida=25;
	    oro=20;
	    velocidadAtaque = 30;
	    proximoAtaque = 0;
	}

}
