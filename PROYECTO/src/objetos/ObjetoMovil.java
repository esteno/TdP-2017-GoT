package objetos;

public abstract class ObjetoMovil extends GameObject{
	//atributos
	protected int velocidad;
	protected int contVelocidad = 0;
	
	public abstract void avanzar();

	public int getVelocidad(){
		return velocidad;
	}

}
