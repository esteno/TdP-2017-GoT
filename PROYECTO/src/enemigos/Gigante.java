package enemigos;

import javax.swing.JLabel;

import celdas.Celda;

public class Gigante extends EnemigoCuerpo{

		public Gigante() {
			proximoAtaque = 0;
			puntosVida = 200;
			fuerzaImpacto = 70;
			grafico = fabricaGrafica.construirGigante();
			fuerzaImpacto = 1000;
		    velocidad = contVelocidad = -30;
		    puntos=100;
		    oro=300;
		    velocidadAtaque = 20;
		    alto = 2;
		}
	

}