package defensa;

public abstract class Dragon extends DefensaRango {

	public Dragon() 
	{
		// TODO Auto-generated constructor stub
		grafico = fabricaGrafica.construirGraficoDragon();
		precio = 300;
	}

}
