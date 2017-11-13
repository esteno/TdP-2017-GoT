package objetos;

import javax.swing.JLabel;

import colisiones.Visitor;

public abstract class ObjetoMovil extends GameObject
{
	
	//atributos
	protected int velocidad;
	protected int contVelocidad;
	protected boolean bloqueado;
	
	public abstract void avanzar();
	
	public synchronized boolean Lock(Boolean b){
		if(b!=true) bloqueado=false;
		return bloqueado;
	}
	public boolean moverGrafico(){
		JLabel actual=grafico.getLabel();
		int x=actual.getBounds().x;
		x=x+velocidad;
		boolean toret=true;
		if((x%50)<Math.abs(velocidad)){
			if(velocidad>0)x=x+(x%50);
			else x=x-(x%50);
			toret=false;
			bloqueado=false;
		}
		actual.setBounds(x, actual.getBounds().y, 50, 50);
		return toret;
	}
	
	public abstract Visitor getVisitor();
	
}
