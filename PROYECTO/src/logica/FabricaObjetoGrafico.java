package logica;

import objetos.GameObjectGrafico;

public class FabricaObjetoGrafico {
	
	private static FabricaObjetoGrafico instancia = null;
	
	private FabricaObjetoGrafico() {}

	public static FabricaObjetoGrafico getInstancia() {
		if(instancia == null) {
			instancia = new FabricaObjetoGrafico();
		}
		return instancia;
	}
	
	//Cada uno construye los graficos de cada uno de los elementos del juego
	//CELDAS GRAFICAS 
	
	public GameObjectGrafico construirGraficoObjetoComun(){
		return new GameObjectGrafico("res/imagenes/celda/Terreno1.png");
	}
	
	public GameObjectGrafico construirGraficoNieveProfunda(){
		return new GameObjectGrafico("res/imagenes/celda/TerrenoNieveProfunda.png");
	}
	
	public GameObjectGrafico construirGraficoLago() {
		return new GameObjectGrafico("res/imagenes/celda/TerrenoLago.png");
	}
	
	//ENEMIGOS
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
	public GameObjectGrafico construirDragon() {
		return new GameObjectGrafico("res/imagenes/enemigo/dragonecamina.gif");
	}
	public GameObjectGrafico construirGigante() {
		return new GameObjectGrafico("res/imagenes/enemigo/thenncamina.gif");
	}
	
	public GameObjectGrafico construirGraficoProtector(){
		return new GameObjectGrafico("res/imagenes/celda/proteector.png");
	}
	
	// PERSONAJES
	
	public GameObjectGrafico construirGraficoInmaculado(){
		return new GameObjectGrafico("res/imagenes/defensa/soldadoataca.gif");
	}
	
	public GameObjectGrafico construirGraficoDragon(){
		return new GameObjectGrafico("res/imagenes/defensa/blackdragonespera.gif");
	}
	
	public GameObjectGrafico construirGraficoYgritte(){
		return new GameObjectGrafico("res/imagenes/defensa/ygretteataca.gif");
	}
	
	public GameObjectGrafico construirGraficoMountain(){
		return new GameObjectGrafico("res/imagenes/defensa/mountainAtaca2.gif");
	}
	
	public GameObjectGrafico construirGraficoGendry(){
		return new GameObjectGrafico("res/imagenes/defensa/gendryataca.gif");
	}
	
	public GameObjectGrafico construirGraficoBronn(){
		return new GameObjectGrafico("res/imagenes/defensa/arqueropataca.gif");
	}
	
	//DEFENSA
	public GameObjectGrafico construirGraficoMuro() {
		return new GameObjectGrafico("res/imagenes/obstaculos/muro.png");
	}

	//DISPARO
	
	public GameObjectGrafico construirGraficoDisparoYgritte() {
		return new GameObjectGrafico("res/imagenes/disparo/flecha.png");
	}
	
	public GameObjectGrafico construirGraficoDisparoBronn() {
		return new GameObjectGrafico("res/imagenes/disparo/flecha2.png");
	}
	
	public GameObjectGrafico construirGraficoDisparoZombieFrio() {
		return new GameObjectGrafico("res/imagenes/disparo/disparoEnemigo.gif");
	}
	
	public GameObjectGrafico construirGraficoDisparoDragon() {
		return new GameObjectGrafico("res/imagenes/disparo/disparodragon.gif");
	}
	
	public GameObjectGrafico construirGraficoBomba() {
		return new GameObjectGrafico("res/imagenes/defensa/bomba.png");
	}
	public GameObjectGrafico construirDisparoDragonDef(){
		return new GameObjectGrafico("res/imagenes/disparo/fuego.gif");
	}
	
	// LABELS BOTONES
	public GameObjectGrafico botonBronn(){
		return new GameObjectGrafico("res/imagenes/juego/botonBronn.png");
	}

	public GameObjectGrafico construirGraficoDanio() {
		return new GameObjectGrafico("res/imagenes/juego/botonDanio.png");
	}

	public GameObjectGrafico construirGraficoCuracion() {
		return new GameObjectGrafico("res/imagenes/juego/botonCuracion.png");
	}

	public GameObjectGrafico construirGraficoBarricada() {
		return new GameObjectGrafico("res/imagenes/obstaculos/barricada.png");
	}

	public GameObjectGrafico construirGraficoFuegoValyrio() {
		return new GameObjectGrafico("res/imagenes/obstaculos/botonFuegoValyrio.png");
	}

	public GameObjectGrafico construirGraficoRoca() {
		return new GameObjectGrafico("res/imagenes/obstaculos/roca.png");
	}

	public GameObjectGrafico construirGraficoTrinchera() {
		return new GameObjectGrafico("res/imagenes/obstaculos/trinchera.png");
	}

}
