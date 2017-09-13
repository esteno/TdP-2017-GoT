package mapa;

public class Mapa 
{ 
	// atributos
	protected Celda [][] mapa;
	protected int altura;
	protected int ancho;

	// constructor
	public Mapa(int maxM, int maxN)
	{
		altura=maxM;
		ancho=maxN;
	
		mapa= (Celda [][]) new Object [altura][ancho];

		for (int i=0; i < altura ; i++)
		{
			for (int j=0; j < ancho; j++)
			this.mapa[i][j]= new Celda(this, i,j);	
		}
			
	}
	
	//metodos
	public int getAltura()
	{return altura; }
	
	public int getAncho()
	{return ancho; }
	
	public Celda getCelda(int i,int j)
	{ return mapa[i][j]; }
	
	public Celda[][] getMapa()
	{return mapa; }
}
