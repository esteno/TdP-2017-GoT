package enemigos;

public class Salvaje extends Enemigo {
	
	public Salvaje(){
		grafico = fabricaGrafica.construirSalvaje();
		fuerza_impacto = 1000;
	    velocidad = contVelocidad = 1000;
	    puntos=100;
	    puntos_vida=5;
	}

}
