package premio;


public class PremioCuracion 
{

	private static int c=0;
	public PremioCuracion() 
	{
		// TODO Auto-generated constructor stub
	}

	public void aumentarCuracion() {
		
		c++;
	}

	public void restarCuracion() {
		
		c--;
	}

	public boolean hayCuracion() {
		
		return c>0;
	}

}
