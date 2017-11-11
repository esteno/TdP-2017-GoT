package defensa;

import logica.Timer;
import objetos.ObjetoMovil;
import colisiones.*;

public class Mina extends Explosivo{

	Visitor v;
	Timer t;
	public Mina() {	
		
		velocidadAtaque = 0;
		proximoAtaque = 0;
		grafico = fabricaGrafica.construirGraficoMina();
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
