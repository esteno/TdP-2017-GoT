package enemigos;

public class OsoSalvaje extends Enemigo {

	public OsoSalvaje(){
		grafico = fabricaGrafica.construirOsoSalvaje();
		fuerzaImpacto = 1000;
	    velocidad = contVelocidad = 1000;
	    puntos=100;
	    puntosVida=5;
	    
	}

}
