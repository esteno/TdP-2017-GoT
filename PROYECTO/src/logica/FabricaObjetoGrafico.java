package logica;

import objetos.GameObjectGrafico;

public class FabricaObjetoGrafico 
{
	
	private static FabricaObjetoGrafico instancia = null;
	
    
	
	private FabricaObjetoGrafico() 
	{}
	
	public static FabricaObjetoGrafico getInstancia() 
	{
		if(instancia == null) 
		{
			instancia = new FabricaObjetoGrafico();
		}
		return instancia;
	}
	
	//CELDAS GRAFICAS 
	
	public GameObjectGrafico construirGraficoCeldaComun() 
	{
		return new GameObjectGrafico("res/imagenes/celda/Terreno1.png");
	}
	
	
	public GameObjectGrafico construirGraficoCeldaArena() 
	{
		return new GameObjectGrafico("res/imagenes/celda/Terreno2.png");
	}
	
	public GameObjectGrafico construirGraficoCeldaLago() 
	{
		return new GameObjectGrafico("res/imagenes/celda/Terreno3.png");
	}
	
	//ENEMIGOS
	
	
	public GameObjectGrafico construirGraficoEnemigoRojo() 
	{
		return new GameObjectGrafico("res/imagenes/enemigo/enemigo.png");
	}
	
	public GameObjectGrafico construirGraficoInmaculado() 
	{
		return new GameObjectGrafico("res/imagenes/enemigo/inmaculado.png");
	}
	
	//DEFENSA
	
	public GameObjectGrafico construirGraficoJorgito() 
	{
		return new GameObjectGrafico("res/imagenes/defensa/test.png");
	}
	
	public GameObjectGrafico construirGraficoMuro() {
		return new GameObjectGrafico("res/imagenes/defensa/muro.png");
	}
	
	//DISPARO
	
	public GameObjectGrafico construirGraficoDisparo() 
	{
		return new GameObjectGrafico("res/imagenes/disparo/disparo.png");
	}
	
}
