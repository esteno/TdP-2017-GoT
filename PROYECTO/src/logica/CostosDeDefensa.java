package logica;

public class CostosDeDefensa {
	
	private final int COSTO_JORGITO = 500;
	private final int COSTO_DRAGON = 1000; // ok 
	private final int COSTO_GENDRY = 400; // ok
	private final int COSTO_INMACULADO = 200; //ok
	private final int COSTO_MOUNTAIN = 500; //ok
	private final int COSTO_YGRITTE = 600; //ok
	private final int COSTO_BRONN = 300; //ok
	
	private static CostosDeDefensa instancia = null;
	
	private CostosDeDefensa() {}
	
	public static CostosDeDefensa getInstncia() {
		if(instancia == null) {
			instancia = new CostosDeDefensa();
		}
		return instancia;
	}
	
	public int costoJorgito() {
		return COSTO_JORGITO;
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
	

}
