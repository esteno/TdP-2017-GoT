package premio;


public class PremioMina{

	private static int c=0;
	
	public PremioMina(){
			
	}

	public void aumentarMinas(){
		
		c++;
	}
	
	public boolean hayMinas() {
		
		return c>0;
	}
	
	public void restarMina() {
		
		c--;
	}
	
}
