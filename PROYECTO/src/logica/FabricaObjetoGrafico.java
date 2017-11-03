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
	
	
	public GameObjectGrafico construirGraficoNieveProfunda() 
	{
		return new GameObjectGrafico("res/imagenes/celda/TerrenoNieveProfunda.png");
	}
	
	public GameObjectGrafico construirGraficoLago() 
	{
		return new GameObjectGrafico("res/imagenes/celda/TerrenoLago.png");
	}
	
	//ENEMIGOS
	public GameObjectGrafico construirGraficoEnemigoRojo() {
		return new GameObjectGrafico("res/imagenes/enemigo/enemigo.png");
	}
	public GameObjectGrafico construirGraficoInmaculado(){
		return new GameObjectGrafico("res/imagenes/enemigo/inmaculado.png");
	}
	public GameObjectGrafico construirGraficoZombi() {
		return new GameObjectGrafico("res/imagenes/enemigo/zombicamina.gif");
	}
	public GameObjectGrafico construirOsoSalvaje() {
		return new GameObjectGrafico("res/imagenes/enemigo/osocamina.gif");
	}
	public GameObjectGrafico construirZombiFrio() {
		return new GameObjectGrafico("res/imagenes/enemigo/zombipcamina.gif");
	}
	public GameObjectGrafico construirSalvaje() {
		return new GameObjectGrafico("res/imagenes/enemigo/e1camina.gif");
	}
	
	///Enemigo ataca
	public GameObjectGrafico getZombiAtaca() {
		return new GameObjectGrafico("res/imagenes/enemigo/zombiataca.gif");
	}
	public GameObjectGrafico getOsoSalvajeAtaca() {
		return new GameObjectGrafico("res/imagenes/enemigo/osoataca.gif");
	}
	public GameObjectGrafico getZombiFrioAtaca() {
		return new GameObjectGrafico("res/imagenes/enemigo/zombipataca.gif");
	}
	public GameObjectGrafico getSalvajeAtaca() {
		return new GameObjectGrafico("res/imagenes/enemigo/e1ataca.gif");
	}
	
	///muertos reviven
	public GameObjectGrafico getZombiAparece() {
		return new GameObjectGrafico("res/imagenes/enemigo/zombiaparece.gif");
	}
	
	///Enemigo Muere
	
	public GameObjectGrafico getZombiMuere() {
		return new GameObjectGrafico("res/imagenes/enemigo/zombimuere.gif");
	}
	public GameObjectGrafico getOsoSalvajeMuere() {
		return new GameObjectGrafico("res/imagenes/enemigo/osomuere.gif");
	}
	public GameObjectGrafico getZombiFrioMuere() {
		return new GameObjectGrafico("res/imagenes/enemigo/zombipmuere.gif");
	}
	public GameObjectGrafico getSalvajeMuere() {
		return new GameObjectGrafico("res/imagenes/enemigo/e1muere.gif");
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

	public GameObjectGrafico construirGraficoMina() {
		
		return new GameObjectGrafico("res/imagenes/disparo/mina.png");
	}

	public GameObjectGrafico construirGraficoExplosivo() {
		
		return new GameObjectGrafico("res/imagenes/disparo/explosivo.png");
	}
	
}
