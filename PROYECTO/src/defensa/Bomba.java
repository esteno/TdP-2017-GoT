package defensa;

import logica.Temporal;
import logica.Timer;
import objetos.ObjetoMovil;
import colisiones.*;

public class Bomba extends Explosivo implements Temporal{

	Timer timer;
	Visitor v;
	public Bomba() {	
		
		timer  = new Timer(this, 3000);
		velocidadAtaque = 0;
		proximoAtaque = 0;
		grafico = fabricaGrafica.construirGraficoBomba();
		visitor = new VisitorDefensa(this);
		puntosVida=1;
	}

	public void recibirAtaque(int i) {
		
		atacar();
	}
	
	public void atacar() {
		
		for (ObjetoMovil c:getCelda().getMapa().adyacentes(getCelda()))
			c.aceptar(v);
		destruir();
	}
	
}
