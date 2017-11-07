package premio;


import logica.Timer;

public class Mina extends Explosivo{

	Timer t;
	public Mina() {	
		
		velocidadAtaque = 0;
		proximoAtaque = 0;
		puntos_vida = 50;
		grafico = fabricaGrafica.construirGraficoExplosivo();
	}

	public void atacar() {
			
	}
	
	
}
