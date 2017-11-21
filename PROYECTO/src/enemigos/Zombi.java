package enemigos;

public class Zombi extends EnemigoCuerpo {
	
	public Zombi(){
		grafico = fabricaGrafica.construirGraficoZombi();
		fuerzaImpacto = 100;
	    velocidad = contVelocidad = -20;
	    puntos=100;
	    puntosVida=25;
	    oro=20;
	    velocidadAtaque = 10;
	    proximoAtaque = 0;
	}

}
