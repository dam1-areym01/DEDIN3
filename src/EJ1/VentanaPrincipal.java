package EJ1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.PageAttributes.ColorType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class VentanaPrincipal {

	JFrame ventana;

	JPanel panelSup;
	JPanel panelInf;

	JLabel lienzo;
	BufferedImage canvas;

	JButton bPinta;
	JSlider bSlider;
	
	int colorAnterior;
	Color[] colores = { Color.BLACK, Color.BLUE, Color.GREEN, Color.GRAY, Color.RED };

	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 400, 500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializarComponentes() {

		ventana.setLayout(new GridBagLayout());

		panelSup = new JPanel();
		panelSup.setLayout(new GridBagLayout());
		panelSup.setBackground(Color.YELLOW);
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.weightx = 1;
		settings.weighty = 1;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(panelSup, settings);

		lienzo = new JLabel();
		lienzo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelSup.add(lienzo);

		canvas = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
		Graphics graficos = canvas.getGraphics();
		graficos.setColor(Color.WHITE);
		graficos.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		graficos.dispose();

		lienzo.setIcon(new ImageIcon(canvas));
		lienzo.repaint();

		Border bordeInf = BorderFactory.createTitledBorder("Controles");

		panelInf = new JPanel();
		panelInf.setLayout(new GridBagLayout());
		panelInf.setBorder(bordeInf);
		panelInf.setBackground(Color.CYAN);
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.ipady = 50;
		settings.weightx = 1;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(panelInf, settings);

		bPinta = new JButton("Pinta");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		panelInf.add(bPinta, settings);
		
		bSlider = new JSlider(0, 300, 150);
		bSlider.setOpaque(false);
		settings.gridx = 0;
		settings.gridy = 1;
		settings.insets = new Insets(10, 0, 0, 0);
		panelInf.add(bSlider, settings);

	}

	public void inicializarListeners() {

		bPinta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Graphics graficos = canvas.getGraphics();

				int colorAleatorio;
				Random rd = new Random();

				do {
					colorAleatorio = rd.nextInt(5);
				} while (colorAnterior == colorAleatorio);

				graficos.setColor(colores[colorAleatorio]);
				graficos.fillRect((canvas.getHeight() / 2) - 50, (canvas.getWidth() / 2) - 50, 100, 100);
				graficos.dispose();
				lienzo.repaint();

				colorAnterior = colorAleatorio;

				JOptionPane.showMessageDialog(null, "Valor de: " + bSlider.getValue());
				
			}
		});
	}

	public void inicializar() {
		// IMPORTANTE, PRIMERO HACEMOS LA VENTANA VISIBLE Y LUEGO INICIALIZAMOS LOS
		// COMPONENTES.
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}
}
