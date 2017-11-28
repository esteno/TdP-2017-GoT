package ObjetoDeMapa;

import defensa.Defensa;
import logica.FabricaObjetoGrafico;
import logica.Temporal;


public class ArenaTemporal extends Defensa implements Temporal
{

	public ArenaTemporal()
	{
		grafico = FabricaObjetoGrafico.getInstancia().construirGraficoArenaTemporal();

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
