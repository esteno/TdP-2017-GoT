package objetos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import logica.Juego;

public class GameObjectGrafico 
{
	
	protected BufferedImage imagen;
	
	
	public GameObjectGrafico(String path) 
	{
		try 
		{
		    imagen = ImageIO.read(new File(path));
		}
		catch (IOException e)
		{
			System.out.println("Imagen no encontrada");
		}
	}
	
	
	
	
	public BufferedImage getImagen() 
	{
		return imagen;
	}
	
	

}
