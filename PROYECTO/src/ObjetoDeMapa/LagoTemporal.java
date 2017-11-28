package ObjetoDeMapa;

import defensa.Defensa;
import logica.FabricaObjetoGrafico;
import logica.Temporal;

public class LagoTemporal extends Defensa implements Temporal
{

	
	public LagoTemporal()
	{
		grafico = FabricaObjetoGrafico.getInstancia().construirGraficoLagoTemporal();

	}
	
	@Override
	public void accionarPorTiempo() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}

}