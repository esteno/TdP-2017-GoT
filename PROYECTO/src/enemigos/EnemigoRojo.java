package enemigos;

public class EnemigoRojo extends Enemigo {
	

	public EnemigoRojo() 
	{
		super();
		grafico = fabricaGrafica.construirGraficoEnemigoRojo();
	    velocidad=-5;
	    puntos=100;
	    puntos_vida=2;
	}

}
