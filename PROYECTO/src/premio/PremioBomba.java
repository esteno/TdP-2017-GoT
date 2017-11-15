package premio;


public class PremioBomba{
	
	private static int c=0;
	
	public PremioBomba(){
		
	}

	public void aumentarBombas(){
		
		c++;
	}
	
	public boolean hayBombas() {
		
		return c>0;
	}
	
	public void restarBomba() {
		
		c--;
	}

	
}
