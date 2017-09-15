package defensa;

import objetos.GameObject;
import objetos.GameObjectGrafico;
import nivel.*;
import colisiones.*;

public abstract class Defensa extends GameObject 
{
     protected Nivel nivel;
     protected Visitor visitor;
     
     public Defensa(String path)
     {
    	 super(path);
    	 
     }
}
