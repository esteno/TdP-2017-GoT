package defensa;

import javax.swing.JLabel;

import celdas.Celda;

public class Mountain extends DefensaCuerpo 
{

	private Celda celda2;
	
	public Mountain() 
	{
		// TODO Auto-generated constructor stub
		velocidadAtaque = 2;
		proximoAtaque = 0;
		puntosVida = 500;
		fuerzaImpacto = 70;

		grafico = fabricaGrafica.construirGraficoMountain();
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
