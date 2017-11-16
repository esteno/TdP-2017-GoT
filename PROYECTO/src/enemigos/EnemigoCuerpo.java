package enemigos;

import celdas.Celda;

public class EnemigoCuerpo extends Enemigo 
{

	public EnemigoCuerpo() 
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void avanzar() 
	{
		// TODO Auto-generated method stub

		if(!atacando)
			if(!grafico.Lock(true)){
			//Si la celda es nula quiere decir que llego al borde izquierdo del mapa.
			Celda celdaNueva = celda.celdaIzquierda();
				if(celdaNueva != null) 	{
					//Guarda la posicion acutal
					int xAnterior = celda.getX();
					int yAnterior = celda.getY();
					
					//Si ya se puede mover y no hay nada en la celda adyacente se mueve
					if(contVelocidad <= 0 && celdaNueva.objetoMovil() == null){	
						celda = celdaNueva;
						grafico.setBloqueado(true);
						celda.moverEnemigo(xAnterior, yAnterior);
						contVelocidad = (int) Math.floor(velocidad*celda.getMultiVelocidad());
					}
					else {
						//descuenta de contador
						contVelocidad -= 100*celda.getMultiVelocidad();
					}
				}
				else 
					destruir();
			}
	}

}
