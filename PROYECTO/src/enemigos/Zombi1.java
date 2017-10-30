package enemigos;

public class Zombi1 extends Enemigo {
	
	public Zombi1(){
		grafico = fabricaGrafica.construirGraficoEnemigoRojo();
		path="res/imagenes/enemigo/zombicamina.gif";
	    velocidad=1000;
	    puntos=100;
	    puntos_vida=5;
	}

}
