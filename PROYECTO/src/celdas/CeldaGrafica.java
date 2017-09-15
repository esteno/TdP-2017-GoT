package celdas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import objetos.GameObjectGrafico;

public class CeldaGrafica extends GameObjectGrafico 
{	
	public CeldaGrafica(String path) {
		try {
		    imagen = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("Imagen no encontrada");
		}
	}

}
