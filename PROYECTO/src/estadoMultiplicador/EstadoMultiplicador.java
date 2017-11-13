package estadoMultiplicador;

public abstract class EstadoMultiplicador 
{
	protected double multiplicadorAtaque;
	protected double multiplicadorVida;
	
	public double multiplicadorAtaque() {
		return multiplicadorAtaque;
	}
	
	public double multiplicadorVida() {
		return multiplicadorVida;
	}
}
