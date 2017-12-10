package EJ3;

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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VentanaPrincipal {

	JFrame ventana;

	JPanel panelSup;
	JPanel panelInf;

	JLabel lienzo;
	BufferedImage canvas;

	JButton bPinta;

	JLabel anchoL;
	JSlider bSliderAncho;
	JLabel altoL;
	JSlider bSliderAlto;

	JSlider bSliderPosX;
	JSlider bSliderPosY;

	JSlider bSliderR;
	JSlider bSliderG;
	JSlider bSliderB;

	int posX, posY;
	int ancho, alto;
	int red, green, blue;

	int colorAnterior;
	Color[] colores = { Color.BLACK, Color.BLUE, Color.GREEN, Color.GRAY, Color.RED };

	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 1000, 1000);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializarComponentes() {

		ventana.setLayout(new GridBagLayout());

		// Panel Superior

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

		canvas = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
		Graphics graficos = canvas.getGraphics();
		graficos.setColor(Color.WHITE);
		graficos.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		graficos.dispose();

		lienzo.setIcon(new ImageIcon(canvas));
		lienzo.repaint();

		// Panel Inferior

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

		bPinta = new JButton("Reestablecer");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		panelInf.add(bPinta, settings);

		bSliderAncho = new JSlider(0, 500, 250);
		bSliderAncho.setOpaque(false);
		bSliderAncho.setMajorTickSpacing(100);
		bSliderAncho.setMinorTickSpacing(100);
		bSliderAncho.setPaintTicks(true);
		bSliderAncho.setPaintLabels(true);
		settings.gridx = 0;
		settings.gridy = 1;
		settings.insets = new Insets(10, 0, 0, 0);
		panelInf.add(bSliderAncho, settings);

		bSliderAlto = new JSlider(0, 500, 250);
		bSliderAlto.setOpaque(false);
		bSliderAlto.setMajorTickSpacing(100);
		bSliderAlto.setMinorTickSpacing(100);
		bSliderAlto.setPaintTicks(true);
		bSliderAlto.setPaintLabels(true);
		settings.gridx = 0;
		settings.gridy = 2;
		settings.insets = new Insets(10, 0, 0, 0);
		panelInf.add(bSliderAlto, settings);

		bSliderPosX = new JSlider(-250, 250, 0);
		bSliderPosX.setOpaque(false);
		bSliderPosX.setMajorTickSpacing(100);
		bSliderPosX.setMinorTickSpacing(100);
		bSliderPosX.setPaintTicks(true);
		bSliderPosX.setPaintLabels(true);
		settings.gridx = 1;
		settings.gridy = 1;
		settings.insets = new Insets(10, 20, 0, 0);
		panelInf.add(bSliderPosX, settings);

		bSliderPosY = new JSlider(-250, 250, 0);
		bSliderPosY.setOpaque(false);
		bSliderPosY.setMajorTickSpacing(100);
		bSliderPosY.setMinorTickSpacing(100);
		bSliderPosY.setPaintTicks(true);
		bSliderPosY.setPaintLabels(true);
		settings.gridx = 1;
		settings.gridy = 2;
		settings.insets = new Insets(10, 20, 0, 0);
		panelInf.add(bSliderPosY, settings);

		bSliderR = new JSlider(0, 255, 0);
		bSliderR.setOpaque(false);
		bSliderR.setMajorTickSpacing(100);
		bSliderR.setMinorTickSpacing(100);
		bSliderR.setPaintTicks(true);
		bSliderR.setPaintLabels(true);
		settings.gridx = 2;
		settings.gridy = 1;
		settings.insets = new Insets(10, 20, 0, 0);
		panelInf.add(bSliderR, settings);

		bSliderG = new JSlider(0, 255, 0);
		bSliderG.setOpaque(false);
		bSliderG.setMajorTickSpacing(100);
		bSliderG.setMinorTickSpacing(100);
		bSliderG.setPaintTicks(true);
		bSliderG.setPaintLabels(true);
		settings.gridx = 2;
		settings.gridy = 2;
		settings.insets = new Insets(10, 20, 0, 0);
		panelInf.add(bSliderG, settings);

		bSliderB = new JSlider(0, 255, 0);
		bSliderB.setOpaque(false);
		bSliderB.setMajorTickSpacing(100);
		bSliderB.setMinorTickSpacing(100);
		bSliderB.setPaintTicks(true);
		bSliderB.setPaintLabels(true);
		settings.gridx = 2;
		settings.gridy = 3;
		settings.insets = new Insets(10, 20, 0, 0);
		panelInf.add(bSliderB, settings);

	}

	public void actualizarCanvasVacio() {
		Graphics graficos = canvas.getGraphics();
		lienzo.setIcon(new ImageIcon(canvas));
		graficos.setColor(Color.WHITE);
		graficos.fillRect(0, 0, canvas.getHeight(), canvas.getWidth());
		graficos.dispose();
		lienzo.repaint();
	}

	public void inicializarListeners() {

		bPinta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				Graphics graficos = canvas.getGraphics();

				actualizarCanvasVacio();
				graficos.setColor(Color.BLACK);
				graficos.fillRect((canvas.getHeight() / 2) - 125, (canvas.getWidth() / 2) - 125, 250, 250);
				// graficos.fillRect(x, y, width, height);
				graficos.dispose();
				lienzo.repaint();
			}
		});

		bSliderAlto.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				cambiar();
			}
		});

		bSliderAncho.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				cambiar();

			}
		});

		bSliderPosX.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				cambiar();

			}
		});

		bSliderPosY.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				cambiar();

			}
		});

		bSliderR.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				cambiar();
			}
		});

		bSliderG.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				cambiar();
			}
		});

		bSliderB.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				cambiar();
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

	public void cambiar() {
		posX = bSliderPosX.getValue();
		posY = bSliderPosY.getValue();
		ancho = bSliderAncho.getValue();
		alto = bSliderAlto.getValue();

		red = bSliderR.getValue();
		green = bSliderG.getValue();
		blue = bSliderB.getValue();

		Color personalizado = new Color(red, green, blue);

		System.out.println(posX + " " + posY + " " + ancho + " " + alto);

		Graphics graficos = canvas.getGraphics();
		graficos.fillRect(0, 0, 500, 500);
		graficos.setColor(Color.BLACK);
		graficos.setColor(personalizado);
		graficos.fillRect((canvas.getWidth() / 2) - (ancho / 2) + posX, (canvas.getHeight() / 2) - (alto / 2) + posY, ancho, alto);
		graficos.dispose();
		lienzo.repaint();
	}
}
