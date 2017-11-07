package premio;

import logica.Timer;

public class Bomba extends Explosivo
{

	Timer t;
	public Bomba() 
	{	
		
		t=new Timer(this);
		new Thread(t).start();
		velocidadAtaque = 0;
		proximoAtaque = 0;
		puntos_vida = 50;
		grafico = fabricaGrafica.construirGraficoExplosivo();
	}

	public void atacar() {
		
	}

}
