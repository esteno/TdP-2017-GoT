package enemigos;

public class OsoSalvaje extends Enemigo {

	public OsoSalvaje(){
		grafico = fabricaGrafica.construirOsoSalvaje();
		fuerza_impacto = 1000;
	    velocidad = contVelocidad = 1000;
	    puntos=100;
	    puntos_vida=5;
	    
	}

}
