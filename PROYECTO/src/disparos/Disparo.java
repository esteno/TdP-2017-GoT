package disparos;
import objetos.*;
import celdas.Celda;
import colisiones.Visitor;

public abstract class Disparo extends ObjetoMovil 
{
	protected int alcance;
	
	protected Visitor visitor;
	
	
	public Disparo(double danio) 
	{
		velocidad=8;
		alcance = 30;
		fuerzaImpacto = (int) Math.floor(danio);
		grafico = fabricaGrafica.construirGraficoDisparo();
	}


	
	
	@Override
	public abstract void avanzar();
	
	
	
	public void destruir() 
	{
		//Para poder ser removido 
		alcance=0;
		//celda.destruirObjetoMovil();
		grafico.destruir();
	}


	
	@Override
	public void atacar() 
	{
		// TODO Auto-generated method stub
	}
	
	
	
	public int getAlcance() {
		return alcance;
	}


	@Override
	public Visitor getVisitor() {
		// TODO Auto-generated method stub
		return visitor;
	}



}

