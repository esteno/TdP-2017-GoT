package enemigos;

public class EnemigoRojo extends Enemigo {
	

	public EnemigoRojo() {
		grafico = fabricaGrafica.construirGraficoEnemigoRojo();
	    velocidad=1000;
	    puntaje=100;
	}

}
