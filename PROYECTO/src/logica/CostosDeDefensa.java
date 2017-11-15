package logica;

public class CostosDeDefensa {
	
	private final int COSTO = 500;
	
	private static CostosDeDefensa instancia = null;
	
	private CostosDeDefensa() {}
	
	public static CostosDeDefensa getInstncia() {
		if(instancia == null) {
			instancia = new CostosDeDefensa();
		}
		return instancia;
	}
	
	public int costoJorgito() {
		return COSTO;
	}
	
	public int costoDragon() {
		return COSTO;
	}
	
	public int costoGendry() {
		return COSTO;
	}
	
	public int costoInmaculado() {
		return COSTO;
	}
	
	public int costoMountain() {
		return COSTO;
	}
	
	public int costoYgritte() {
		return COSTO;
	}
	
	public int costoBronn() {
		return COSTO;
	}
	

}
