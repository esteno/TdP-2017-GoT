package ObjetoDeMapa;

import logica.FabricaObjetoGrafico;
import logica.Temporal;

public class RocaTemporal extends ObjetoDeMapa implements Temporal
{

	public RocaTemporal()
	{
		grafico = FabricaObjetoGrafico.getInstancia().construirGraficoRocaTemporal();
		multiplicadorVelocidad = 1;
	}
	
	
	@Override
	public void accionarPorTiempo() 
	{
		// TODO Auto-generated method stub
		
	}

}
