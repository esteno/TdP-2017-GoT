package mapa;

public class Mapa 
{ 
	
	protected Matriz matrizEstatica;
	protected Matriz matrizMovil;
	
	
	public Mapa(int i, int j)
	{
		matrizEstatica = new Matriz(i,j);
		matrizMovil = new Matriz(i,j);
	}

	public Matriz getMatrizEstatica()
	{ return matrizEstatica; }
	
	public Matriz getMatrizMovil()
	{ return matrizMovil; }
}
