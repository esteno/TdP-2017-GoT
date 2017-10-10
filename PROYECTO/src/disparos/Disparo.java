package disparos;
import objetos.*;
import enemigos.*;

public class Disparo extends ObjetoMovil implements Runnable
{
	
	
	public Disparo() {
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void daniar(Enemigo e)
	{
		e.decrementarResistencia();
	}
	
}
