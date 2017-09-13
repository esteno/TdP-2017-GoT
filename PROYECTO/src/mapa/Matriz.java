package mapa;

public class Matriz
{
	protected Celda[][] matriz;
    protected int altura;
    protected int ancho;
	
	public Matriz(int maxX, int maxY)
	{
		altura=maxX;
		ancho=maxY;
		
		matriz= (Celda [][]) new Object[altura][ancho];
		
		for(int i=0; i<altura; i++)
		{	
			for(int j=0; j<ancho ; j++)
		        this.matriz[i][j] = new Celda(this,i,j);
		}
	}
	
	public Celda getCelda(int i, int j)
	{ return matriz[i][j]; }
	
	public int getAncho()
	{ return ancho; }

	public int getAltura()
	{ return altura; }
	
	public Celda[][] getMatriz()
	{ return matriz; }	
}
