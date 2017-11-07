package defensa;

public class Personaje extends Defensa 
{
	
 
	protected final int puntos_vida_inicio = this.puntos_vida;
     
    protected final int fuerza_impacto_inicio = this.fuerza_impacto;
     
    protected int aux;

    
    
    
	@Override
	public void atacar() 
	{
		// TODO Auto-generated method stub

	}
	
	
	
	public void curacion()
	{
		this.guardarPuntosVida();
		puntos_vida = puntos_vida_inicio;
	}
	
	
	public void restaurarPuntosVida()
	{
		puntos_vida = this.aux;
	}
	
	private void guardarPuntosVida()
	{
		aux = this.getPuntosVida();
	}
	
	public void danioDoble()
	{
		fuerza_impacto = fuerza_impacto*2;
	}

	public void restaurarFuerzaimpacto()
	{
		fuerza_impacto = fuerza_impacto_inicio;
	}
}
