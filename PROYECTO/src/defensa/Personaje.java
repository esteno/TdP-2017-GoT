package defensa;

import estadoMultiplicador.*;

public abstract class Personaje extends Defensa 
{
	
 
	protected int puntosVidaInicio = this.puntosVida;
     
    protected int fuerzaImpactoInicio = this.fuerzaImpacto;
     

    protected EstadoMultiplicador estado = new EstadoDefensaDefecto();
    
    
	
	
	public void curacion()
	{
		puntosVida = puntosVidaInicio;
	}
	
	

}
