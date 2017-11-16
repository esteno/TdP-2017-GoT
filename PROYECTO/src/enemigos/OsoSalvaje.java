package enemigos;

public class OsoSalvaje extends EnemigoCuerpo
{

	public OsoSalvaje()
	{
		grafico = fabricaGrafica.construirOsoSalvaje();
		fuerzaImpacto = 1000;
	    velocidad = contVelocidad = 1000;
	    puntos=100;
	    puntosVida=150;
	    oro=75;
	}

}
