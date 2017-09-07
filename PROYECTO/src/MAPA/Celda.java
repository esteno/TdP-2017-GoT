package MAPA;

public class Celda 
{
	//atributos
    protected Mapa mapa;
    protected int x;
    protected int y;
    
    //constructor 
    public Celda(Mapa m, int x, int y)
    {
    	mapa=m;
    	this.x=x;
    	this.y=y;
    }

    
    //metodos
    public int getX()
    {return x; }
    
    public int getY()
    {return y; }
}
