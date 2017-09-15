package gui;

import logica.*;
import objetos.GameObjectGrafico;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JButton;

public class gui {

	private JFrame frame;
	private Juego juego;
	private final int ALTO = 12;
	private final int ANCHO = 8;
	private Map<JLabel,Vector<Integer>> mapeoCoordenadas;

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
		frame.setBounds(100, 100, 500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelControl = new JPanel();
		frame.getContentPane().add(panelControl, BorderLayout.EAST);
		
		JButton botonAgregar = new JButton("New button");
		botonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panelControl.add(botonAgregar);

		
		JLayeredPane panelMapa = new JLayeredPane();
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
				panelMapa.add(label, cons, 0);
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
				JLabel label = (JLabel) e.getComponent();
				System.out.println(mapeoCoordenadas.get(label).elementAt(0)+" "+mapeoCoordenadas.get(label).elementAt(1));
				
				
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
