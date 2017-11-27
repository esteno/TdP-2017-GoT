package ObjetoDeMapa;

import logica.FabricaObjetoGrafico;
import logica.Temporal;

public class LagoTemporal extends ObjetoDeMapa implements Temporal
{

	
	public LagoTemporal()
	{
		grafico = FabricaObjetoGrafico.getInstancia().construirGraficoLagoTemporal();
		multiplicadorVelocidad = 2;
	}
	
	@Override
	public void accionarPorTiempo() 
	{
		// TODO Auto-generated method stub
		
	}

}
