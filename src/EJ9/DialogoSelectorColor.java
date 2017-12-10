package EJ9;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.ImageCapabilities;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DialogoSelectorColor extends JDialog {

	JLabel titulo;
	String[] colores = {"Rojo", "Verde", "Azul"};
	JLabel[] tituloColores = new JLabel[3];
	JSlider[] sliderColores = new JSlider[3];
	
	BufferedImage muestra;
	JLabel muestrilla;
	
	JButton aceptar;
	
	private static final long serialVersionUID = 1L;

	public DialogoSelectorColor() {
		super();
		setModal(true);
		setBounds(0, 0, 400, 600);
		annadirElementos();
		annadirListeners();
	}

	private void annadirElementos() {
		this.setLayout(new GridBagLayout());
		
		titulo = new JLabel("Selecciona tu color:");
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.insets = new Insets(0, 0, 50, 0);
		this.add(titulo, settings);
		
		for (int i = 1; i < (colores.length * 2); i = i + 2) {
			tituloColores[i / 2] = new JLabel("Nivel de " +  colores[i / 2] + ":");			
			settings = new GridBagConstraints();
			settings.gridx = 0;
			settings.gridy = i;
			settings.insets = new Insets(0, 0, 20, 0);
			this.add(tituloColores[i / 2], settings);
			
			sliderColores[i / 2] = new JSlider(0, 255, 0);
			sliderColores[i / 2].setOpaque(false);
			sliderColores[i / 2].setMajorTickSpacing(255);
			sliderColores[i / 2].setMinorTickSpacing(10);
			sliderColores[i / 2].setPaintTicks(true);
			sliderColores[i / 2].setPaintLabels(true);
			settings.gridx = 0;
			settings.gridy = i + 1;
			settings.insets = new Insets(0, 0, 15, 0);
			this.add(sliderColores[i / 2], settings);
		}		
		
			muestra = new BufferedImage(200, 60, BufferedImage.TYPE_INT_RGB);
			muestrilla = new JLabel(new ImageIcon(muestra));
			muestrilla.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			settings = new GridBagConstraints();
			settings.gridx = 0;
			settings.gridy = 7;
			settings.insets = new Insets(0, 0, 50, 0);
			this.add(muestrilla, settings);
			
			aceptar = new JButton("Aceptar");
			settings = new GridBagConstraints();
			settings.gridx = 0;
			settings.gridy = 8;
			settings.insets = new Insets(0, 0, 50, 0);
			this.add(aceptar, settings);
			
		
	}

	private void annadirListeners() {
	
		for (int i = 0; i < sliderColores.length; i++) {
			sliderColores[i].addChangeListener(new ChangeListener() {
			
				@Override
				public void stateChanged(ChangeEvent e) {

					int red = sliderColores[0].getValue();
					int green = sliderColores[1].getValue();
					int blue = sliderColores[2].getValue();
					
					Graphics graficos = muestra.getGraphics();
					graficos.setColor(new Color(red, green, blue));
					graficos.fillRect(0, 0, muestra.getWidth(), muestra.getHeight());
					graficos.dispose();
					DialogoSelectorColor.this.repaint();
					
					
				}
			});
		}
		
		aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogoSelectorColor.this.dispose();
			}
		});
		
	}

}
