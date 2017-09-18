package defensa;

public abstract class DefensaCuerpo extends Defensa implements Runnable
{
    
	
	
	public DefensaCuerpo(String path)
	{
		super(path);
		
	}
	
	public void run() {}
}
