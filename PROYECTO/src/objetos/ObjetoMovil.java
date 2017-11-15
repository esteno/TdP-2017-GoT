package objetos;

import javax.swing.JLabel;

import colisiones.Visitor;

public abstract class ObjetoMovil extends GameObject
{
	
	//atributos
	protected int velocidad;
	protected int contVelocidad;
	
	public abstract void avanzar();

	public int getVelocidad(){
		return velocidad;
	}
	
	public abstract Visitor getVisitor();
	
}
