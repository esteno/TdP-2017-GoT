package enemigos;

import logica.Juego;

public class CampoProtectorEnemigo extends Enemigo {

	Juego juego;
	Enemigo enemigo;
	
	public CampoProtectorEnemigo(Enemigo e, Juego j) {

	    enemigo=e;
	    grafico = fabricaGrafica.construirGraficoProtector();
		fuerzaImpacto = 0;
	    velocidad = contVelocidad =e.getVelocidad();
	    puntos=0;
	    puntosVida=e.getPuntosVida()/2;
	    oro=0;
	    velocidadAtaque = 10;
	    proximoAtaque = 0;
	    juego=j;
	}
	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}
	
	public Enemigo getEnemigo() {
		return enemigo;
	}
	
	public void destruir() {
		grafico.destruir();
		celda.destruirEnemigo();
		juego.eliminarEscudo(this);
	}

}
