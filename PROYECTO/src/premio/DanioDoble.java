package premio;

import colisiones.Visitor;

public class DanioDoble extends Premio 
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

}
