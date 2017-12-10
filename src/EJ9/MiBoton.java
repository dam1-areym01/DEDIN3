package EJ9;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MiBoton extends JButton {

	int columna_;
	int fila_;
	VentanaPrincipal ventana_;

	public MiBoton(VentanaPrincipal ventana, int columna, int fila) {
		super(fila + "-" + columna);
		
		this.fila_ = fila;
		this.columna_ = columna;
		this.ventana_ = ventana;
		
		this.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 15));
		this.setText(fila + "-" + columna);
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			// JOptionPane.showMessageDialog(MiBoton.this, MiBoton.this.getText());
				Graphics graficos = ventana_.getGraficos();
				graficos.setColor(ventana_.getBotonColorido(fila, columna).getForeground());
				graficos.fillRect(fila_*100, columna_*100, 100, 100);
				graficos.dispose();
				ventana_.ventana.repaint();
			}
		});

	}

}
