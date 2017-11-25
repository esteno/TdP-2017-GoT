package enemigos;

import javax.swing.JLabel;

import celdas.Celda;

public class Gigante extends EnemigoCuerpo{

		public Gigante() {
			proximoAtaque = 0;
			puntosVida = 500;
			fuerzaImpacto = 70;
			grafico = fabricaGrafica.construirGigante();
			fuerzaImpacto = 1000;
		    velocidad = contVelocidad = -30;
		    puntos=100;
		    oro=75;
		    velocidadAtaque = 20;
		}

		public void setCelda(Celda celdaNueva){
			celda = celdaNueva;
			int y = celda.getY();
			int x = celda.getX();
			if(y<7){
				celda.setDoble(this,x, y+1);
			}
			else{
				celda.setDoble(this,x, y-1);
				JLabel label=grafico.getLabel();
				label.setBounds(x*50, (y-1)*50, 50, 100);

			}
		}
	

}