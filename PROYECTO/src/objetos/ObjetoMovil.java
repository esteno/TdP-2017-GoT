package objetos;

public abstract class ObjetoMovil extends GameObject
{
	protected Boolean isRunning = true;
	
	public ObjetoMovil(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}
	//atributos
	protected int velocidad;
	protected int puntos_vida;
	

	
}
