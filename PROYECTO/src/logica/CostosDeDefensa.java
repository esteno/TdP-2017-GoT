package logica;

public class CostosDeDefensa {
	
	
	//Matiene el costo de todas las cosas que se pueden comprar en el juego
	private final int COSTO_DRAGON = 1000;
	private final int COSTO_GENDRY = 400;
	private final int COSTO_INMACULADO = 200;
	private final int COSTO_MOUNTAIN = 500;
	private final int COSTO_YGRITTE = 600;
	private final int COSTO_BRONN = 300;
	
	private final int COSTO_FUEGO_VALYRIO = 700;
	private final int COSTO_MURO = 800;
	private final int COSTO_TRINCHERA = 500 ;
	private final int COSTO_ROCA = 600;
	
	private static CostosDeDefensa instancia = null;
	
	private CostosDeDefensa() {}
	
	public static CostosDeDefensa getInstancia() {
		if(instancia == null) {
			instancia = new CostosDeDefensa();
		}
		return instancia;
	}
	
	public int costoDragon() {
		return COSTO_DRAGON;
	}
	
	public int costoGendry() {
		return COSTO_GENDRY;
	}
	
	public int costoInmaculado() {
		return COSTO_INMACULADO;
	}
	
	public int costoMountain() {
		return COSTO_MOUNTAIN;
	}
	
	public int costoYgritte() {
		return COSTO_YGRITTE;
	}
	
	public int costoBronn() {
		return COSTO_BRONN;
	}
	
	
	// --------- costos de obstaculos
	
	public int costoFuegoValyrio()
	{
		return COSTO_FUEGO_VALYRIO;
	}
	
	public int costoMuro()
	{
		return COSTO_MURO;
	}
	
	public int costoRoca()
	{
		return COSTO_ROCA;
	}
	
	public int costoTrinchera()
	{
		return COSTO_TRINCHERA;
	}
}
