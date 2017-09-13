package mapa;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import objetos.GameObjectGrafico;

public class CeldaGrafica extends GameObjectGrafico 
{	
	public CeldaGrafica() {
		try {
		    imagen = ImageIO.read(new File("res/imagenes/celda/terreno.png"));
		} catch (IOException e) {
			System.out.println("Imagen no encontrada");
		}
	}

}
