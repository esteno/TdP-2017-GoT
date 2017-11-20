package defensa;

import javax.swing.JLabel;

import celdas.Celda;

public class Dragon extends DefensaCuerpo {
	
	private Celda celda2;

	public Dragon() 
	{	
		precio = 1000;
		velocidadAtaque = 8;
		proximoAtaque = 0;
		puntosVida = 400;
		fuerzaImpacto = 100;

		grafico = fabricaGrafica.construirGraficoDragon();
	}

	public void setCelda(Celda celdaNueva)
	{
		celda = celdaNueva;
		int y = celda.getY();
		int x = celda.getX();
		if(y<7){
			celda.setDoble(this,x, y+1);
		}
		else{
			celda.setDoble(this,x, y-1);
			JLabel label=grafico.getLabel();
			label.setBounds(x*50, (y-1)*50, 100, 100);
			
		}
	}
	public void setCelda2(Celda c){
		celda2=c;
		System.out.println("Se seteo la celda 2");
	}
}
