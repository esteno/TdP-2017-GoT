package defensa;

public class Personaje extends Defensa 
{
	
 
	protected final int puntos_vida_inicio = this.puntos_vida;
     
    protected final int fuerza_impacto_inicio = this.fuerza_impacto;
     
    protected int aux = this.getPuntosVida();

	@Override
	public void atacar() 
	{
		// TODO Auto-generated method stub

	}
	
	public void danioDoble()
	{
		fuerza_impacto = fuerza_impacto*2;
	}
	
	public void curacion()
	{
		puntos_vida = puntos_vida_inicio;
	}

}
