package gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import defensa.Defensa;
import logica.FabricaDeDefensa;
import logica.Juego;
import objetos.GameObject;
import objetos.GameObjectGrafico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Gui
{

	private JFrame frame;
	
	private Juego juego;
	private final int ALTO = 8;
	private final int ANCHO = 16;
	private final int ALTO_IMG = 50; // antes 32
	private final int ANCHO_IMG = 50; // antes 32
	
	private final int NIVELCELDA = 2;
	private final int NIVELDEFENSA = 0;
	private final int NIVELENEMIGO = 1;
	
	private FabricaDeDefensa fabricaDeDefensa = FabricaDeDefensa.getInstancia();
	
	private JLabel labelPuntaje;
	private boolean aEliminar=false;
	
	private JLayeredPane panelMapa;
	private JPanel panelControl;
	private JPanel panelCeldas;
	private JPanel panelDefensa;
	private JPanel panelEnemigos;
	private JPanel panelPersonajes;
	private JButton btnJorgito;

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
		frame = new JFrame("NIGHT KING DEFENSE");
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		
		panelMapa = new JLayeredPane();
		panelMapa.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMapa.setBounds(0,0,ANCHO*ANCHO_IMG,ALTO*ALTO_IMG);
		panelMapa.setLocation(200,100);
		panelMapa.setBackground(Color.GRAY);
		
		
		panelCeldas = new JPanel();
		panelCeldas.setLayout(null);
		panelCeldas.setBounds(panelMapa.getBounds());
		panelCeldas.setBackground(new Color(0,0,0,0));
		panelMapa.add(panelCeldas, NIVELCELDA);
		
		panelDefensa = new JPanel();
		panelDefensa.setLayout(null);
		panelDefensa.setBounds(panelMapa.getBounds());
		panelDefensa.setBackground(new Color(0,0,0,0));
		panelMapa.add(panelDefensa, NIVELDEFENSA);
		
		panelEnemigos = new JPanel();
		panelEnemigos.setLayout(null);
		panelEnemigos.setBounds(panelMapa.getBounds());
		panelEnemigos.setBackground(new Color(0,0,0,0));
		panelMapa.add(panelEnemigos, NIVELENEMIGO);
		
		frame.getContentPane().repaint();
		juego = new Juego(this, ALTO, ANCHO);
		GameObjectGrafico[][] graficos = juego.getCeldasGraficas();
		
		
		for(int i = 0; i < ANCHO; i++) 
		{
			for (int j = 0; j < ALTO; j++) 
			{
				ImageIcon imagen = graficos[i][j].getImagen();
				int ancho = imagen.getIconWidth();
				int alto = imagen.getIconHeight();
				int x = i*ancho;
				int y = j*alto;
				JLabel label = new JLabel();
				label.setBounds(x ,y,alto,ancho);
				label.setIcon(imagen);
				label.addMouseListener(getMouseListener());
				panelCeldas.add(label);
				
			}
		}
		
		juego.crearMuro();
		
		frame.getContentPane().add(panelMapa, BorderLayout.CENTER);
		panelMapa.setLayout(null);
		
		JPanel panelPuntaje = new JPanel();
		panelPuntaje.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPuntaje.setBackground(SystemColor.menu);
		panelPuntaje.setBounds(171, 11, 117, 81);
		panelMapa.add(panelPuntaje);
		panelPuntaje.setLayout(null);
		
		labelPuntaje = new JLabel("Puntaje: 0");
		labelPuntaje.setBounds(26, 11, 64, 14);
		panelPuntaje.add(labelPuntaje);
		
		panelPersonajes = new JPanel();
		panelPersonajes.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPersonajes.setBounds(10, 11, 151, 539);
		panelMapa.add(panelPersonajes);
		panelPersonajes.setLayout(null);
		
		btnJorgito = new JButton("Jorgito");
		btnJorgito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FabricaDeDefensa.getInstancia().construirJorgito(); 
			}
		});
		btnJorgito.setBounds(10, 11, 83, 54);
		panelPersonajes.add(btnJorgito);
		
		JButton botonYgritte = new JButton("");
		botonYgritte.setEnabled(false);
		botonYgritte.setIcon(new ImageIcon("C:\\CARPETAS_DE_ESCRITORIO\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\defensa\\ygrette.png"));
		botonYgritte.setBounds(10, 76, 89, 50);
		panelPersonajes.add(botonYgritte);
		
		JPanel paneloObjetosPreciosos = new JPanel();
		paneloObjetosPreciosos.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneloObjetosPreciosos.setBounds(455, 11, 519, 81);
		panelMapa.add(paneloObjetosPreciosos);
		paneloObjetosPreciosos.setLayout(null);
		
		JButton botonBomba = new JButton("");
		botonBomba.setEnabled(false);
		botonBomba.setIcon(new ImageIcon("C:\\CARPETAS_DE_ESCRITORIO\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\premios\\iconoBomba.png"));
		botonBomba.setBounds(152, 11, 92, 59);
		paneloObjetosPreciosos.add(botonBomba);
		
		JButton botonBarricada = new JButton("");
		botonBarricada.setEnabled(false);
		botonBarricada.setIcon(new ImageIcon("C:\\CARPETAS_DE_ESCRITORIO\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\premios\\iconoBarricada.png"));
		botonBarricada.setBounds(279, 11, 89, 59);
		paneloObjetosPreciosos.add(botonBarricada);
		
		JButton botonFuegovalyrio = new JButton("");
		botonFuegovalyrio.setEnabled(false);
		botonFuegovalyrio.setIcon(new ImageIcon("C:\\CARPETAS_DE_ESCRITORIO\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\premios\\botonFuegoValyrio.png"));
		botonFuegovalyrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonFuegovalyrio.setBounds(402, 11, 92, 59);
		paneloObjetosPreciosos.add(botonFuegovalyrio);
		
		JLabel lblPremios = new JLabel("OBJETOS PRECIOSOS: ");
		lblPremios.setBounds(10, 23, 132, 47);
		paneloObjetosPreciosos.add(lblPremios);
		
		JPanel panelMonedas = new JPanel();
		panelMonedas.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMonedas.setBounds(315, 11, 117, 81);
		panelMapa.add(panelMonedas);
		panelMonedas.setLayout(null);
		
		JLabel lblMonedas = new JLabel("Monedas:  0");
		lblMonedas.setBounds(10, 11, 97, 14);
		panelMonedas.add(lblMonedas);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\CARPETAS_DE_ESCRITORIO\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\premios\\monedas.gif"));
		label.setBounds(37, 25, 70, 45);
		panelMonedas.add(label);
		
		JPanel panelMagiaTemporal = new JPanel();
		panelMagiaTemporal.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMagiaTemporal.setBounds(171, 502, 600, 48);
		panelMapa.add(panelMagiaTemporal);
		panelMagiaTemporal.setLayout(null);
		
		JLabel lblMagiaTemporal = new JLabel("MAGIA TEMPORAL: ");
		lblMagiaTemporal.setBounds(28, 23, 135, 14);
		panelMagiaTemporal.add(lblMagiaTemporal);
		
		JButton botonCampoProteccion = new JButton("");
		botonCampoProteccion.setEnabled(false);
		botonCampoProteccion.setIcon(new ImageIcon("C:\\CARPETAS_DE_ESCRITORIO\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\premios\\gemaceleste.png"));
		botonCampoProteccion.setBounds(202, 11, 89, 30);
		panelMagiaTemporal.add(botonCampoProteccion);
		
		JButton botonDanioDoble = new JButton("");
		botonDanioDoble.setEnabled(false);
		botonDanioDoble.setIcon(new ImageIcon("C:\\CARPETAS_DE_ESCRITORIO\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\premios\\gemaroja.png"));
		botonDanioDoble.setBounds(338, 11, 89, 30);
		panelMagiaTemporal.add(botonDanioDoble);
		
		JButton botonCuracion = new JButton("");
		botonCuracion.setEnabled(false);
		botonCuracion.setIcon(new ImageIcon("C:\\CARPETAS_DE_ESCRITORIO\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\premios\\gemaverde.png"));
		botonCuracion.setBounds(479, 11, 89, 30);
		panelMagiaTemporal.add(botonCuracion);
		
		//panelControl = new JPanel();
		/*panelControl.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelControl.setBackground(new Color(255, 0, 255));
		frame.getContentPane().add(panelControl, BorderLayout.EAST);
		panelControl.setLayout(new GridLayout(0, 1, 0, 0));
		int x = panelMapa.getX() + panelMapa.getWidth();
		int y = panelMapa.getY() + panelMapa.getHeight();
		//panelControl.setBounds(x, y, 300, 500);
		 * */
		//panelControl.setLocation(0, 0);
		
		
	}
	
	public void puntaje(int puntaje)
	{
		labelPuntaje.setText("Puntaje: "+puntaje);
	}

	public void agregarObjetoMovil(int x, int y, GameObject obj) 
	{
		
		JLabel labelEnemigo = new JLabel();
		obj.getGrafico().setLabel(labelEnemigo);
		labelEnemigo.setIcon(obj.getGrafico().getImagen());
		labelEnemigo.setBounds(x*ANCHO_IMG, y*ALTO_IMG,50,50);
		panelEnemigos.add(labelEnemigo);
		repintar();
	}
	
	public void moverEnemigoGrafico(int x, int y, int xAnterior, int yAnterior) 
	{
		JLabel label = buscarLabel(xAnterior, yAnterior, panelEnemigos);
		label.setLocation(x*ANCHO_IMG,y*ALTO_IMG);
		repintar();
	}
	
	public void eliminarMovil(int x, int y) {
		System.out.println("GUI Quiero eliminar en x "+x+" y "+y);
		JLabel aEliminar = buscarLabel(x, y, panelEnemigos);
		panelEnemigos.remove(aEliminar);
		repintar();
		
	}
	
	private JLabel buscarLabel(int x, int y, JPanel panel) {
		Component[] arrComponents = panel.getComponents();
		JLabel label = null;
		boolean encontre = false;
		for(int i = 0; !encontre && i < arrComponents.length; i++ ) {
			Component comp = arrComponents[i];
			if(comp.getBounds().x == x*ANCHO_IMG && comp.getBounds().y == y*ALTO_IMG) {
				encontre = true;
				label = (JLabel) arrComponents[i];
			}
		}
		return label;
	}
	
	private void repintar() {
		panelMapa.validate();
		panelMapa.repaint();
	}
	
	public MouseListener getMouseListener() {
		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel labelCelda = (JLabel) e.getComponent();
				int x= labelCelda.getBounds().x / ANCHO_IMG;
				int y= labelCelda.getBounds().y / ALTO_IMG;
				if(aEliminar)
				{
					
					JLabel remover = buscarLabel(x, y, panelDefensa);
					if(remover!=null){
						juego.eliminarDefensa(x, y);
					}
					aEliminar=false;
				}
				else {
					Defensa defensa = fabricaDeDefensa.getDefensa();
					if(defensa != null) 
					{
						juego.agregarDefensa(x,y);
						ImageIcon imagen = defensa.getGrafico().getImagen();
						JLabel labelNuevo = new JLabel(imagen);
						defensa.getGrafico().setLabel(labelNuevo);
						labelNuevo.setBounds(labelCelda.getBounds());
						panelDefensa.add(labelNuevo);
						repintar();
					 }
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
	
	public void dibujarDefensa(int x, int y, GameObject obj) {
		JLabel labelCelda = buscarLabel(x, y, panelCeldas);
		JLabel labelNuevo = new JLabel(obj.getGrafico().getImagen());
		obj.getGrafico().setLabel(labelNuevo);
		labelNuevo.setBounds(labelCelda.getBounds());
		panelDefensa.add(labelNuevo);
		repintar();
	}

	public void gameOver() {
		int reply = JOptionPane.showConfirmDialog(frame, "Has perdido!\nQuieres jugar de nuevo?", "Game Over", JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			frame.getContentPane().removeAll();
			frame.getContentPane().repaint();
			
			initialize();
		}
		else {
			JOptionPane.showMessageDialog(null, "Gracias por jugar!");
			System.exit(0);
		}
		
	}
}
