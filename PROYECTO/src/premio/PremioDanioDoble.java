package premio;

public class PremioDanioDoble 
{

	private static int c=0;
	public PremioDanioDoble() 
	{
		// TODO Auto-generated constructor stub
	}

	public void aumentarDanio() {

		c++;
	}

	public void restarDanio() {

		c--;
	}

	public boolean hayDanio() {

		return c>0;
	}

}
