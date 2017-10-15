package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import logica.Juego;

public class GUI_Romina 
{
	private JFrame frame;
	
	private Juego juego;
	
	private final int ALTO = 8;
	private final int ANCHO = 16;
	
	
	private JLabel[][] matrizLabelCelda;
	private JLabel[][] matrizLabelEstatica;
	private JLabel[][] matrizLabelMovil;
	private JLabel labelPuntaje;
	
	private JLayeredPane panelMapa;

	private final int NIVELCELDA = 0;
	private final int NIVELDEFENSA = 1;
	private final int NIVELENEMIGO = 2;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the application.
	 */
	public Gui() 
	{
		juego = new Juego(this, ALTO, ANCHO);
		matrizLabelCelda = new JLabel[ANCHO][ALTO];
		matrizLabelEstatica = new JLabel[ANCHO][ALTO];
		matrizLabelEnemigo = new JLabel[ANCHO][ALTO];
		
		initialize();	
	}

}
