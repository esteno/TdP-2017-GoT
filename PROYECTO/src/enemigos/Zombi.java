package enemigos;

public class Zombi extends Enemigo {
	
	public Zombi(){
		grafico = fabricaGrafica.construirGraficoZombi();

	    velocidad = contVelocidad = 1000;
	    puntos=100;
	    puntos_vida=5;
	    
	}

}
