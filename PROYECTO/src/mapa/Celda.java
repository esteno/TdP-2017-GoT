package mapa;

public class Celda 
{
	//atributos
    protected Matriz matriz;
    protected int x;
    protected int y;
    
    //constructor 
    public Celda(Matriz m, int x, int y)
    {
    	matriz=m;
    	this.x=x;
    	this.y=y;
    }

    
    //metodos
    public int getX()
    {return x; }
    
    public int getY()
    {return y; }
}
