package enemigos;

import celdas.Celda;
import defensa.Defensa;

public abstract class EnemigoCuerpo extends Enemigo {



	public void atacar() {
		// Si debe atacar, por cada celda izquierda de la celda compuesta, les pide a sus objetos que lo acepten
		if(proximoAtaque == 0 ) 
		{
			for(Celda celdaIzquierda : celdas.celdaIzquierda()) 
			{
				Defensa defensa = celdaIzquierda.getEstatico();
				if(defensa != null) 
				{
					defensa.aceptar(visitor);
					atacando=true;
				}
				else
					atacando=false;
			}
			proximoAtaque = velocidadAtaque;
		}
		else 
		{
			proximoAtaque--;
		}
	}
}