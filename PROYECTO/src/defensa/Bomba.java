package defensa;

import logica.Temporal;
import logica.Timer;

public class Bomba extends Explosivo implements Temporal{

	Timer timer;
	public Bomba() {	
		
		timer  = new Timer(this, 3000);
		velocidadAtaque = 0;
		proximoAtaque = 0;
		fuerzaImpacto=90;
		grafico = fabricaGrafica.construirGraficoBomba();
		puntosVida=1;
	}
	
}
