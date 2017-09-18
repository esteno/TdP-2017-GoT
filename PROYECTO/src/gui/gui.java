package gui;

import logica.*;
import objetos.GameObjectGrafico;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import defensa.Defensa;

import java.awt.BorderLayout;
import javax.swing.JLayeredPane;

import javax.swing.JButton;

public class gui {

	private JFrame frame;
	private Juego juego;
	private final int ALTO = 12;
	private final int ANCHO = 8;
	private Map<JLabel,Vector<Integer>> mapeoCoordenadas;
	private Defensa defensaSelec = null;
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
		mapeoCoordenadas = new HashMap<JLabel, Vector<Integer>>();
		
		initialize();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelControl = new JPanel();
		frame.getContentPane().add(panelControl, BorderLayout.EAST);
		
		JButton botonAgregar = new JButton("New button");
		botonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				defensaSelec = juego.construirDefensa();
				
			}
			
		});
		panelControl.add(botonAgregar);

		
		panelMapa = new JLayeredPane();
		frame.getContentPane().add(panelMapa);
		panelMapa.setLayout(new GridBagLayout());

		//Pide todas las celdas graficas y los agrega a un panel con un gridbaglayout.
		GameObjectGrafico[][] graficos = juego.getCeldasGraficas();
		for(int i = 0; i < ALTO; i++) {
			for (int j = 0; j < ANCHO; j++) {
				GridBagConstraints cons = new GridBagConstraints();
				cons.gridheight = cons.gridwidth = 1;
				cons.gridx = j;
				cons.gridy = i;
				JLabel label = new JLabel();
				label.setIcon(new ImageIcon(graficos[i][j].getImagen()));
				label.addMouseListener(getMouseListener());
				panelMapa.add(label, cons, NIVELCELDA);
				Vector<Integer> vector = new Vector<Integer>(2);
				vector.addElement(i);
				vector.addElement(j);
				mapeoCoordenadas.put(label, vector);
				
			}
		}
	}
	
	public MouseListener getMouseListener() {
		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(defensaSelec != null) {
					JLabel labelCelda = (JLabel) e.getComponent();
					Vector<Integer> vector = mapeoCoordenadas.get(e.getComponent());
					GridBagConstraints cons = new GridBagConstraints();
					cons.gridheight = cons.gridwidth = 1;
					System.out.println("x "+vector.get(1)+" y "+vector.get(0));
					cons.gridx = vector.get(1);
					cons.gridy = vector.get(0);
					BufferedImage imagen = defensaSelec.getGrafico();
					JLabel labelNuevo = new JLabel(new ImageIcon(imagen));
					labelNuevo.setBounds(labelCelda.getBounds());
					labelNuevo.setOpaque(false);
					System.out.println(cons.gridheight+" "+cons.gridwidth);
					panelMapa.add(labelNuevo, cons, NIVELDEFENSA);
					defensaSelec = null;
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
}
