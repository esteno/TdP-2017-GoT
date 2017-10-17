package enemigos;

public class EnemigoRojo extends Enemigo {
	

	public EnemigoRojo() 
	{
		grafico = fabricaGrafica.construirGraficoEnemigoRojo();
	    velocidad=1000;
	    puntos=100;
	    puntos_vida=2;
	}

}
