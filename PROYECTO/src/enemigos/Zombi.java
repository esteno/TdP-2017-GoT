package enemigos;

public class Zombi extends Enemigo {
	
	public Zombi(){
		grafico = fabricaGrafica.construirGraficoZombi();
		fuerzaImpacto = 1000;
	    velocidad = contVelocidad = -4;
	    puntos=100;
	    puntosVida=25;
	    oro=20;
	}

}
