package nivel;

import java.util.ArrayList;
import java.util.List;

public class Niveles 
{
	protected List<Nivel>  niveles; 
	
	public Niveles(){
		niveles = new ArrayList<Nivel>();
		niveles.add(0, new Nivel1());
		niveles.add(1, new Nivel2());
		niveles.add(2, new Nivel3());
	}
	
	public Nivel getNivel(int i) {
		Nivel toReturn=null;
		if(i < niveles.size())
			toReturn = niveles.get(i-1);
		return toReturn;
	}

}