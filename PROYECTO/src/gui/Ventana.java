package gui;

import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import logica.CostosDeDefensa;
import logica.FabricaDeDefensa;
import logica.Juego;
import logica.Puntaje;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JOptionPane;
import defensa.Defensa;
import enemigos.Enemigo;
import logica.*;
import objetos.*;
import premio.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Ventana implements Runnable{

private JFrame frame;
	
	private Juego juego;
	
	private final int ALTO = 8;
	private final int ANCHO = 16;
	private final int ALTO_IMG = 50; // antes 32
	private final int ANCHO_IMG = 50; // antes 32
	private final int NIVELCELDA = 3;
	private final int NIVELDEFENSA = 1;
	private final int NIVELENEMIGO = 2;
	private final int NIVELPREMIO = 0;
	private boolean clickCampo = false;
	
	private Puntaje p;
	private FabricaDeDefensa fabricaDeDefensa = FabricaDeDefensa.getInstancia();
	private CostosDeDefensa costosDeDefensa = CostosDeDefensa.getInstancia();
	
	private JLabel labelPuntaje;
	
	private boolean aEliminar=false;
	
	private JButton botonPremioBomba;
	private JButton botonPremioBarricada;
	private JButton botonPremioOro;
	private JButton botonPremioCuracion;
	private JButton botonPremioDanioDoble;
	private JButton botonPremioCampoProtector;
	
	private List<ObjetoMovil> moviles;
	private List<ObjetoMovil> aBorrar;
	private List<ObjetoMovil> aAgregar;
	private JLayeredPane panelMapa;
	private JPanel panelEnemigos;
	private JPanel panelCeldas;
	private JPanel panelDefensa;
	private JPanel panelCeldaPremios;
	private JPanel panelPersonajes;
	private JButton botonYgritte;
	private JButton botonMountain;
	private JButton botonDragon;
	private JButton botonInmaculado;
	private JButton botonBronn;
	private JButton botonGendry;
	private JButton botonBarricada;
	private JButton botonCampo;
	private JButton botonBomba;
	private JLabel lblPuntaje;
	private JLabel lblMonedas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
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
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("NIGHT KING DEFENSE");
		frame.setBounds(new Rectangle(0, 0, 1000, 600));
		frame.getContentPane().setBounds(new Rectangle(0, 0, 1000, 600));
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		moviles= new LinkedList<ObjetoMovil>();
		aBorrar= new LinkedList<ObjetoMovil>();
		aAgregar= new LinkedList<ObjetoMovil>();
		
		panelMapa = new JLayeredPane();
		panelMapa.setBounds(200, 100, 800, 400);
		frame.getContentPane().add(panelMapa);
				
		panelDefensa = new JPanel();
		panelDefensa.setOpaque(false);
		panelDefensa.setBounds(0, 0, 800, 400);
		panelDefensa.setLayout(null);
		panelMapa.add(panelDefensa);
		
		panelEnemigos = new JPanel();
		panelEnemigos.setOpaque(false);
		panelEnemigos.setBounds(0, 0, 800, 400);
		panelEnemigos.setLayout(null);
		panelMapa.add(panelEnemigos);
		
		panelCeldaPremios = new JPanel();
		panelCeldaPremios.setOpaque(false);
		panelCeldaPremios.setBounds(0, 0, 800, 400);
		panelCeldaPremios.setLayout(null);
		panelMapa.add(panelCeldaPremios);
		
		panelCeldas = new JPanel();
		panelCeldas.setOpaque(false);
		panelCeldas.setBounds(0, 0, 800, 400);
		panelCeldas.setLayout(null);
		panelMapa.add(panelCeldas);
		
		panelPersonajes = new JPanel();
		panelPersonajes.setOpaque(false);
		panelPersonajes.setBounds(0, 0, 100, 562);
		frame.getContentPane().add(panelPersonajes);
		FlowLayout fl_panelPersonajes = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panelPersonajes.setLayout(null);
		
		botonYgritte = new JButton("");
		botonYgritte.setBounds(0, 0, 100, 93);
		botonYgritte.setIcon(new ImageIcon("C:\\Users\\Juan\\Documents\\GitHub\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\juego\\botonYgritte.png"));
		panelPersonajes.add(botonYgritte);
		
		botonMountain = new JButton("");
		botonMountain.setBounds(0, 93, 100, 93);
		botonMountain.setIcon(new ImageIcon("C:\\Users\\Juan\\Documents\\GitHub\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\juego\\botonMountain.png"));
		panelPersonajes.add(botonMountain);
		
		botonDragon = new JButton("");
		botonDragon.setBounds(0, 186, 100, 96);
		botonDragon.setIcon(new ImageIcon("C:\\Users\\Juan\\Documents\\GitHub\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\juego\\botonDragon.png"));
		panelPersonajes.add(botonDragon);
		
		botonInmaculado = new JButton("");
		botonInmaculado.setBounds(0, 279, 100, 94);
		botonInmaculado.setIcon(new ImageIcon("C:\\Users\\Juan\\Documents\\GitHub\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\juego\\botonInmaculado.png"));
		panelPersonajes.add(botonInmaculado);
		
		botonBronn = new JButton("");
		botonBronn.setBounds(0, 373, 100, 94);
		botonBronn.setIcon(new ImageIcon("C:\\Users\\Juan\\Documents\\GitHub\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\juego\\botonBronn.png"));
		panelPersonajes.add(botonBronn);
		
		botonGendry = new JButton("");
		botonGendry.setBounds(0, 468, 100, 94);
		botonGendry.setIcon(new ImageIcon("C:\\Users\\Juan\\Documents\\GitHub\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\juego\\botonGendry.png"));
		panelPersonajes.add(botonGendry);
		
		botonBarricada = new JButton("Barricada\r\n\r\n\r\n");
		botonBarricada.setBounds(400, 11, 90, 80);
		frame.getContentPane().add(botonBarricada);
		
		botonCampo = new JButton("Campo");
		botonCampo.setBounds(500, 11, 90, 80);
		frame.getContentPane().add(botonCampo);
		
		botonBomba = new JButton("Bomba");
		botonBomba.setBounds(600, 11, 89, 78);
		frame.getContentPane().add(botonBomba);
		
		lblPuntaje = new JLabel("Puntaje: 0");
		lblPuntaje.setBorder(null);
		lblPuntaje.setOpaque(true);
		lblPuntaje.setFont(new Font("Century", Font.PLAIN, 17));
		lblPuntaje.setBounds(128, 11, 139, 31);
		frame.getContentPane().add(lblPuntaje);
		
		lblMonedas = new JLabel("Monedas: 0");
		lblMonedas.setOpaque(true);
		lblMonedas.setFont(new Font("Century", Font.PLAIN, 17));
		lblMonedas.setBounds(127, 53, 139, 31);
		frame.getContentPane().add(lblMonedas);
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setIcon(new ImageIcon("C:\\Users\\Juan\\Documents\\GitHub\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\juego\\fondo.jpg"));
		labelFondo.setBounds(0, 0, 1000, 562);
		frame.getContentPane().add(labelFondo);
		
		///--- ACCIONES DE LOS BOTONES ----
		botonYgritte.addActionListener(new ActionListener() 
 		{
 			public void actionPerformed(ActionEvent arg0) 
 			{
 				FabricaDeDefensa.getInstancia().construirYgritte(); 
 				juego.restarOro(costosDeDefensa.costoYgritte());	
 					
 			}
 		});
		
		botonMountain.addActionListener(new ActionListener() 
 		{
 			public void actionPerformed(ActionEvent e) 
 			{
 				FabricaDeDefensa.getInstancia().construirMountain();
 				juego.restarOro(costosDeDefensa.costoMountain());
 			}
 		});
		
		botonDragon.addActionListener(new ActionListener() 
 		{
 			public void actionPerformed(ActionEvent e) 
 			{
 				FabricaDeDefensa.getInstancia().construirDragon();
 				juego.restarOro(costosDeDefensa.costoDragon());
 					
 			}
 		});
		
 		botonInmaculado.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent e)
 			{
 				FabricaDeDefensa.getInstancia().construirInmaculado();
 				juego.restarOro(costosDeDefensa.costoInmaculado());
 					
 			}
 		});
		
 		botonGendry.addActionListener(new ActionListener() 
 		{
 			public void actionPerformed(ActionEvent e) 
 			{
 				FabricaDeDefensa.getInstancia().construirGendry();
 				juego.restarOro(costosDeDefensa.costoGendry());
 			}
 		});
 		
 		botonBronn.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent arg0) 
 			{
 				FabricaDeDefensa.getInstancia().construirBronn();
 				juego.restarOro(costosDeDefensa.costoBronn());
 			}
 		});
		
		///-----------BOTONES PREMIOS
		botonPremioBomba = new JButton("Bomba");
 		botonPremioBomba.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				juego.agregarBomba();
				botonBomba.setEnabled(true);
				panelCeldaPremios.remove(botonPremioBomba);
			}
 		});
 		
 		botonPremioBarricada = new JButton("Barr");
 		botonPremioBarricada.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				juego.agregarBarricada();
 				botonBarricada.setEnabled(true);
 				panelCeldaPremios.remove(botonPremioBarricada);
 			}
 		});
 		
 		botonPremioOro = new JButton("Oro");
 		botonPremioOro.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				juego.sumarOro(1000);
 				panelCeldaPremios.remove(botonPremioOro);
 			}
 		});
 		
 		botonPremioCuracion = new JButton("+++");
 		botonPremioCuracion.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				juego.curarDefensas();
 				panelCeldaPremios.remove(botonPremioCuracion);
 			}
 		});
 		
 		botonPremioDanioDoble = new JButton("DD");
 		botonPremioDanioDoble.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				juego.danioDoble();
 				panelCeldaPremios.remove(botonPremioDanioDoble);
 			}
 		});
 		
 		botonPremioCampoProtector = new JButton("CPro");
 		botonPremioCampoProtector.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				
 			}
 		});
		

		///---------------
		juego = new Juego(this, ALTO, ANCHO);
		GameObjectGrafico[][] graficos = juego.getCeldasGraficas();
		
		for(int i = 0; i < ANCHO; i++) {
			for (int j = 0; j < ALTO; j++) {
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
	}
	
	public void puntaje(int puntaje){
		
		labelPuntaje.setText("Puntaje: "+puntaje);
	}
	
	public void agregarObjetoMovil(int x, int y, GameObject obj) {
		
		JLabel labelEnemigo = new JLabel();
		obj.getGrafico().setLabel(labelEnemigo);
		ImageIcon icono = obj.getGrafico().getImagen();
		labelEnemigo.setIcon(obj.getGrafico().getImagen());
		labelEnemigo.setBounds(x*ANCHO_IMG, y*ALTO_IMG,icono.getIconHeight(),icono.getIconWidth());
		panelEnemigos.add(labelEnemigo);
		repintar();
	}

	public void moverGrafico(ObjetoMovil o) {
		aAgregar.add(o);
	}

	public void run(){
		boolean estado=true;
		while(estado){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(ObjetoMovil o : aAgregar){
				moviles.add(o);
			}
			aAgregar.clear();
			
			for(ObjetoMovil o : aBorrar){
				moviles.remove(o);
			}
			aBorrar.clear();
			
			for(ObjetoMovil o : moviles) {
				if(!o.getGrafico().moverGrafico(o.getVelocidad())){
					aBorrar.add(o);
					o.getGrafico().Lock(false);
				}
			}
			repintar();
		}
	}
	
	private void repintar() {
		panelMapa.repaint();

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
	
	public void dibujarDefensa(int x, int y, GameObject obj) {
		JLabel labelCelda = buscarLabel(x, y, panelCeldas);
		JLabel labelNuevo = new JLabel(obj.getGrafico().getImagen());
		ImageIcon icono = obj.getGrafico().getImagen();
		obj.getGrafico().setLabel(labelNuevo);
		labelNuevo.setBounds(labelCelda.getX(), labelCelda.getY(), icono.getIconHeight(), icono.getIconWidth());
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
	
	public void oroActual(int oro) {
		lblMonedas.setText("Monedas: "+oro);
		//btnJorgito.setEnabled((oro < costosDeDefensa.costoJorgito()) ? false : true);
		
		botonYgritte.setEnabled((oro < costosDeDefensa.costoYgritte()) ? false : true);
		
		botonMountain.setEnabled((oro < costosDeDefensa.costoMountain()) ? false : true); 
		
		botonDragon.setEnabled((oro < costosDeDefensa.costoDragon()) ? false : true);
		
		botonInmaculado.setEnabled((oro < costosDeDefensa.costoInmaculado()) ? false : true);
		
		botonGendry.setEnabled((oro < costosDeDefensa.costoGendry()) ? false : true);
		
		botonBronn.setEnabled((oro < costosDeDefensa.costoBronn()) ? false : true);
		
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
	
	public void habilitarBomba() {
		botonBomba.setEnabled(true);
	}
	
	public MouseListener listenBomba() {
		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel labelCelda = (JLabel) e.getComponent();
				labelCelda.setIcon ( new ImageIcon("/res/imagenes/premios/objetosPreciosos/iconoBomba.png"));
				panelMapa.add(labelCelda);
				int x= labelCelda.getBounds().x / ANCHO_IMG;
				int y= labelCelda.getBounds().y / ALTO_IMG;
				juego.detonarBomba(x,y);
				repintar();
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



	public void agregarPremioBomba(int x, int y) {
		botonPremioBomba.setBounds(x*ANCHO_IMG, y*ALTO_IMG, ANCHO_IMG, ALTO_IMG);
		panelCeldaPremios.add(botonPremioBomba);
	}

	public void agregarPremioBarricada(int x, int y) {
		botonPremioBarricada.setBounds(x*ANCHO_IMG, y*ALTO_IMG, ANCHO_IMG, ALTO_IMG);
		panelCeldaPremios.add(botonPremioCuracion);
	}
	
	public void agregarPremioCuracion(int x, int y) {
		botonPremioCuracion.setBounds(x*ANCHO_IMG, y*ALTO_IMG, ANCHO_IMG, ALTO_IMG);
		panelCeldaPremios.add(botonPremioCuracion);
		
	}

	public void agregarPremioOro(int x, int y) {
		botonPremioOro.setBounds(x*ANCHO_IMG, y*ALTO_IMG, ANCHO_IMG, ALTO_IMG);
		panelCeldaPremios.add(botonPremioOro);
		
	}

	public void agregarPremioDanioDoble(int x, int y) {
		botonPremioDanioDoble.setBounds(x*ANCHO_IMG, y*ALTO_IMG, ANCHO_IMG, ALTO_IMG);
		panelCeldaPremios.add(botonPremioDanioDoble);
	}

	public void agregarPremioCampoProtector(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}