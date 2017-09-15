package objetos;

public abstract class GameObject 
{
  
	private GameObjectGrafico grafico;
	
	public GameObject(String path) {
		grafico = new GameObjectGrafico(path);
	}
}
