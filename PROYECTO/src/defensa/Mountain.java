package defensa;

import javax.swing.JLabel;

import celdas.Celda;

public class Mountain extends DefensaCuerpo {
	
	public Mountain() {
		velocidadAtaque = 2;
		proximoAtaque = 0;
		puntosVida = puntosVidaInicio = 500;
		fuerzaImpacto = fuerzaImpactoInicio = 70;
		grafico = fabricaGrafica.construirGraficoMountain();
		alto = 2;
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