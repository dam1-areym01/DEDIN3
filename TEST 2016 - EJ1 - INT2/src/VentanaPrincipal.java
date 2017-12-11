
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaPrincipal {

	// La ventana principal, en este caso, guarda todos los componentes:
	JFrame ventana;

	// Paneles
	JPanel pSuperior;
	JPanel pJuego;
	JPanel pInferior;

	// Panel Superior
	JLabel lMenu;
	JPanel pSeparadorSuperior;
	JButton bConfigurar;
	JButton bNuevo;
	JButton bCerrar;

	// Panel Central
	JButton[] botoneraJuego = new JButton[8];

	// Panel Inferior
	JLabel lSeleccion;
	JPanel pSeparadorInferior;
	JButton[] botoneraColores = new JButton[3];
	String[] colores = { "Verde", "Rojo", "Cyan" };

	// Variables
	File sFichero = new File("Ficheros");
	ArrayList<String> temario = new ArrayList<>();
	int i;

	// Constructor, marca el tamaño y el cierre del frame
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 800, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Método que inicializa todos los componentes de la ventana
	 */
	public void inicializarComponentes() {

		ventana.setLayout(new GridBagLayout());

		// Panel Superior

		pSuperior = new JPanel(new GridBagLayout());
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.weightx = 1;
		settings.ipady = 10;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(pSuperior, settings);

		lMenu = new JLabel("MENU");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.insets = new Insets(0, 20, 0, 0);
		pSuperior.add(lMenu, settings);

		pSeparadorSuperior = new JPanel();
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 0;
		settings.weightx = 10; // Ojo
		pSuperior.add(pSeparadorSuperior, settings);

		bConfigurar = new JButton("Configurar");
		settings = new GridBagConstraints();
		settings.gridx = 2;
		settings.gridy = 0;
		settings.insets = new Insets(0, 5, 0, 5);
		pSuperior.add(bConfigurar, settings);

		bNuevo = new JButton("Nuevo");
		bNuevo.setEnabled(false);
		settings = new GridBagConstraints();
		settings.gridx = 3;
		settings.gridy = 0;
		settings.insets = new Insets(0, 5, 0, 5);
		pSuperior.add(bNuevo, settings);

		bCerrar = new JButton("Cerrar");
		settings = new GridBagConstraints();
		settings.gridx = 4;
		settings.gridy = 0;
		settings.insets = new Insets(0, 5, 0, 20);
		pSuperior.add(bCerrar, settings);

		// Panel de Juego

		pJuego = new JPanel(new GridLayout(2, 4, 10, 10));
		pJuego.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY), "JUEGO",
				TitledBorder.CENTER, TitledBorder.TOP));
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.weightx = 1;
		settings.weighty = 1;
		settings.ipady = 10;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(pJuego, settings);

		for (int i = 0; i < botoneraJuego.length; i++) {
			botoneraJuego[i] = new JButton("");
			botoneraJuego[i].setEnabled(false);
			pJuego.add(botoneraJuego[i]);
		}

		// Panel Inferior

		pInferior = new JPanel(new GridBagLayout());
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 2;
		settings.weightx = 1;
		settings.ipady = 20;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(pInferior, settings);

		lSeleccion = new JLabel("Seleccionar Tema");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.insets = new Insets(0, 20, 0, 0);
		pInferior.add(lSeleccion, settings);

		pSeparadorInferior = new JPanel();
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 0;
		settings.weightx = 10; // Ojo
		pInferior.add(pSeparadorInferior, settings);

		for (int i = 0; i < botoneraColores.length; i++) {
			botoneraColores[i] = new JButton(colores[i]);
			settings = new GridBagConstraints();
			settings.gridx = 2 + i;
			settings.gridy = 0;
			settings.insets = new Insets(0, 5, 0, 5);
			if (botoneraColores[i] == botoneraColores[2]) {
				settings.insets = new Insets(0, 5, 0, 20);
			}
			pInferior.add(botoneraColores[i], settings);
		}

	}

	/**
	 * Método que inicializa todos los listeners del programa.
	 */
	public void inicializarListeners() {

		// Botones Panel Superior
		
		bConfigurar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarFicheroTXT();
			}

		});
		
		bNuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < botoneraJuego.length; i++) {
					botoneraJuego[i].setEnabled(true);					
				}
			}
		});
		
		bCerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
		
		// Botones Panel Juego
		
		for (i = 0; i < botoneraJuego.length; i++) {
			botoneraJuego[i].addActionListener(new ActionListener() {
				
				int aux = i;
				@Override
				public void actionPerformed(ActionEvent e) {
					
				try {
					if (temario.size() > 0) {
					Random rd = new Random();
					int aleatorio = rd.nextInt(temario.size() - 1);				
					botoneraJuego[aux].setText(temario.get(aleatorio));
					temario.remove(aleatorio);
					} 	
				}catch (IllegalArgumentException e2) {
					// e2.printStackTrace();
					botoneraJuego[aux].setText("NO HAY + PALABRAS");
				}
				
				}
			});
		}
		
		// Botones Panel Inferior
		
		for (i = 0; i < botoneraColores.length; i++) {
			botoneraColores[i].addActionListener(new ActionListener() {

				int aux = i;

				@Override
				public void actionPerformed(ActionEvent e) {

					switch (aux) {
					case 0:
						for (int i = 0; i < botoneraJuego.length; i++) {
							botoneraJuego[i].setBackground(Color.GREEN);
							botoneraJuego[i].setOpaque(true);
						}
						break;
					case 1:
						for (int i = 0; i < botoneraJuego.length; i++) {
							botoneraJuego[i].setBackground(Color.RED);
							botoneraJuego[i].setOpaque(true);
						}
						break;
					case 2:
						for (int i = 0; i < botoneraJuego.length; i++) {
							botoneraJuego[i].setBackground(Color.CYAN);
							botoneraJuego[i].setOpaque(true);
						}
						break;
					}

				}
			});

		}

	}

	public void cargarFicheroTXT() {
		
		JFileChooser archivo = new JFileChooser();
		archivo.setCurrentDirectory(sFichero);
		archivo.setSelectedFile(sFichero);
		archivo.setDialogTitle("Seleccione tema...");
		archivo.setFileFilter(new FileNameExtensionFilter("txt", "txt"));
		int fileSelected = archivo.showOpenDialog(ventana);
		if (fileSelected == JFileChooser.APPROVE_OPTION) {
			
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				
				fr = new FileReader(archivo.getSelectedFile().getAbsolutePath());
				br = new BufferedReader(fr);
				
				String linea = br.readLine();
				while (linea != null) {
					temario.add(linea);
					linea = br.readLine();
				}
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			bNuevo.setEnabled(true);
		}

		
	}
	
	/**
	 * Método que realiza todas las llamadas necesarias para inicializar la ventana
	 * correctamente.
	 */	
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}

}
