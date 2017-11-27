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
	    puntosVida=e.getPuntosVida()/2;
	    oro=0;
	    velocidadAtaque = 10;
	    proximoAtaque = 0;
	    juego=j;
	    System.out.println(enemigo.getGrafico().getLabel()==null);
	    enemigo.getGrafico().getLabel().setBorder(new MatteBorder(2, 2, 2, 2, Color.BLUE));
	}
	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
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
		juego.eliminarEscudo(this);
		juego.reemplazarEnemigo(enemigo, getAncho(), getAlto());
	}

	public int getAncho() {
		
		return enemigo.getAncho();
	}
	
	public int getAlto() {
		
		return enemigo.getAlto();
	}
}
