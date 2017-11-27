package logica;

public class CostosDeDefensa {
	
	private final int COSTO_DRAGON = 1000;
	private final int COSTO_GENDRY = 300;
	private final int COSTO_INMACULADO = 150;
	private final int COSTO_MOUNTAIN = 500;
	private final int COSTO_YGRITTE = 200;
	private final int COSTO_BRONN = 400;
	
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
	
	
	
}
