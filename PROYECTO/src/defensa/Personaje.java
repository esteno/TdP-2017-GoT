package defensa;

import estadoMultiplicador.*;

public abstract class Personaje extends Defensa 
{
	
 
	protected final int puntosVidaInicio = this.puntosVida;
     
    protected final int fuerzaImpactoInicio = this.fuerzaImpacto;
     
    protected int aux;

    protected EstadoMultiplicador estado = new EstadoDefensaDefecto();
    
    
	
	
	public void curacion()
	{
		this.guardarPuntosVida();
		puntosVida = puntosVidaInicio;
	}
	
	
	public void restaurarPuntosVida()
	{
		puntosVida = this.aux;
	}
	
	private void guardarPuntosVida()
	{
		aux = this.getPuntosVida();
	}
	
	

}
