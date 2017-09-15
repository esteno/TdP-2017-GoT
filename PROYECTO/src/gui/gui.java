package gui;

import logica.*;
import objetos.GameObjectGrafico;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class gui {

	private JFrame frame;
	private Juego juego;
	private final int ALTO = 12;
	private final int ANCHO = 8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
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
	public gui() 
	{
		juego = new Juego(ALTO, ANCHO);
		
		initialize();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelMapa = new JPanel();
		//Pide todas las celdas graficas y los agrega a un panel con un gridbaglayout.
		GameObjectGrafico[][] graficos = juego.getCeldasGraficas();
		panelMapa.setLayout(new GridBagLayout());
		for(int i = 0; i < ALTO; i++) {
			for (int j = 0; j < ANCHO; j++) {
				GridBagConstraints cons = new GridBagConstraints();
				cons.gridheight = cons.gridwidth = 1;
				cons.gridx = j;
				cons.gridy = i;
				JLabel label = new JLabel();
				label.setIcon(new ImageIcon(graficos[i][j].getImagen()));
				panelMapa.add(label, cons);
			}
		}
		
		frame.getContentPane().add(panelMapa, BorderLayout.CENTER);
		
		JPanel panelControl = new JPanel();
		frame.getContentPane().add(panelControl, BorderLayout.EAST);
	}

}
