package EJ6;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.RepaintManager;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


public class VentanaPrincipal {

	final int anchoLienzo = 400;
	final int altoLienzo = 400;
	
	//La ventana principal, en este caso, guarda todos los componentes:
	JFrame ventana;
	
	//Paneles:
	JPanel pIzquierda;
	JPanel pDerechaArriba;
	JPanel pDerechaAbajo;
	
	//Botones;
	MiBoton[][] botones = new MiBoton[4][4];

	
 	
	//Variables para pintar
	private JLabel lienzo;
	private BufferedImage canvas;
	
	//Slider
	JSlider selectorTamanio;
	
	//Colores:
	Color colores [] = {Color.BLACK,Color.BLUE, Color.GREEN, Color.GRAY,Color.RED};
	Color ultimoColor = Color.WHITE; //Inicialmente no hay color
	
	
	
	//Constructor, marca el tamaño y el cierre del frame
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 900, 500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Método que inicializa todos los componentes de la ventana
	 */
	public void inicializarComponentes(){
		
		//Definimos el layout:
		ventana.setLayout(new GridBagLayout());
		
		//IZQUIERDA
		pIzquierda = new JPanel();
		pIzquierda.setBackground(Color.LIGHT_GRAY);
		pIzquierda.setLayout(new GridBagLayout());
		GridBagConstraints settings = new GridBagConstraints();
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.weightx = 2;
		settings.weighty = 1;
		settings.gridheight = 2;
		settings.fill = GridBagConstraints.BOTH;
		ventana.getContentPane().add(pIzquierda,settings);
		
		
		//AÑADIMOS EL LIENZO A EL PANEL DE LA IZQUIERDA.
		lienzo = new JLabel();
		lienzo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//Inicializamos el canvas, y sacamos el graphics.: 
		canvas = new BufferedImage(anchoLienzo, altoLienzo, BufferedImage.TYPE_INT_ARGB);
		nuevoCanvas();
		lienzo.setIcon(new ImageIcon(canvas));

		pIzquierda.add(lienzo);
		
		
		// PANEL SUPERIOR DERECHA
		pDerechaArriba = new JPanel();
		pDerechaArriba.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30), BorderFactory.createTitledBorder("botones")));
		pDerechaArriba.setBackground(Color.CYAN);
		pDerechaArriba.setLayout(new GridLayout(4,4,3,3));
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 0;
		settings.weightx = 1;
		settings.weighty = 1;
		settings.fill = GridBagConstraints.BOTH;
		ventana.getContentPane().add(pDerechaArriba,settings);
		
		Font fuente = new Font("Serif", Font.BOLD | Font.ITALIC, 15);
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {			
				botones[i][j] = new MiBoton(i, j);
				pDerechaArriba.add(botones[i][j]);
			}
		}
		
		
		//PANEL INFERIOR DERECHA
		pDerechaAbajo = new JPanel();
		pDerechaAbajo.setBorder(BorderFactory.createTitledBorder("ControlColor"));
		pDerechaAbajo.setBackground(Color.GRAY);
		pDerechaAbajo.setLayout(new GridBagLayout());
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 1;
		settings.weightx = 1;
		settings.weighty = 1;
		settings.fill = GridBagConstraints.BOTH;
		ventana.getContentPane().add(pDerechaAbajo,settings);
		
	}
	
	/**
	 * Método que inicializa todos los listeners del programa.
	 */
	public void inicializarListeners(){
		
		
		
	}
	

	public void nuevoCanvas(){
		Graphics graficos = canvas.getGraphics();
		graficos.setColor(Color.WHITE);
		graficos.fillRect(0, 0, anchoLienzo, altoLienzo);
		graficos.dispose();
		lienzo.repaint();
	}
	
	
	
	
	/**
	 * Método que realiza todas las llamadas necesarias para inicializar la ventana correctamente.
	 */
	public void inicializar(){
		ventana.setVisible(true);
		inicializarComponentes();	
		inicializarListeners();		
	}
}
