package defensa;

import logica.Juego;

public class Muro extends Defensa {
	
	private Juego juego;

	public Muro(Juego j) {
		juego = j;
		velocidadAtaque = 0;
		proximoAtaque = 0;
		puntosVida = 100000;
		grafico = fabricaGrafica.construirGraficoMuro();
	}
	@Override
	public void atacar() {
	}
	
	
	public void recibirAtaque(int impacto) {
		System.out.println("muro game over");
		juego.gameOver();
	}

}
