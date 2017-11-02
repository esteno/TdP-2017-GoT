package premio;

import colisiones.Visitor;
import defensa.Defensa;

public class DanioDoble extends MagiaTemporal
{

	public DanioDoble() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public void aceptar(Visitor v)
	{
		//NO HACE NADA, ES DECIR, NADIE LO VISITA
		//SOLO SETTEA EL IMPACTO DE LOS DEFENSORES, LA DUPLICA
	}

	@Override
	public void accionar(Defensa d) {
		// TODO Auto-generated method stub
		
	}

}
