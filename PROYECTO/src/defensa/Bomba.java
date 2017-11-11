package defensa;

import logica.Timer;
import objetos.ObjetoMovil;
import colisiones.*;

public class Bomba extends Explosivo{

	Timer t;
	Visitor v;
	public Bomba() {	
		
		t=new Timer(this);
		new Thread(t).start();
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
