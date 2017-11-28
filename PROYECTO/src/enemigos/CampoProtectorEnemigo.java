package enemigos;

import java.awt.Color;

import javax.swing.border.MatteBorder;

import logica.Juego;
import objetos.*;

public class CampoProtectorEnemigo extends Enemigo {

	Juego juego;
	Enemigo enemigo;
	
	public CampoProtectorEnemigo(Enemigo e, Juego j) {
	    enemigo=e;
		fuerzaImpacto = 0;
	    velocidad = contVelocidad =e.getVelocidad();
	    puntos=0;
	    puntosVida = e.getPuntosVida()/2;
	    oro=0;
	    grafico = e.getGrafico();
	    velocidadAtaque = 10;
	    proximoAtaque = 0;
	    juego=j;
	    juego.eliminarEnemigo(e);
	    juego.insertarEnemigo(this);
	    enemigo.getGrafico().getLabel().setBorder(new MatteBorder(2, 2, 2, 2, Color.BLUE));
	}
	@Override
	public void atacar() {
		enemigo.atacar();
	}
	
	public GameObjectGrafico getGrafico() {
		return enemigo.getGrafico();
	}
	
	public Enemigo getEnemigo() {
		return enemigo;
	}
	
	public void destruir() {
		enemigo.getGrafico().getLabel().setBorder(null);
		celdas.destruirEnemigo();
		juego.reemplazarEnemigo(enemigo, celdas.getX(), celdas.getY());
		juego.insertarEnemigo(enemigo);
	}

	public int getAncho() {
		return enemigo.getAncho();
	}
	
	public int getAlto() {
		return enemigo.getAlto();
	}
}