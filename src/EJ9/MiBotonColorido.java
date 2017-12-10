package EJ9;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

public class MiBotonColorido extends JButton {

	int columna_;
	int fila_;

	public MiBotonColorido(int columna, int fila) {
		super(columna + "-" + fila);

		this.fila_ = fila;
		this.columna_ = columna;

		this.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 15));
		this.setText(columna + "-" + fila);
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				DialogoSelectorColor dialogo = new DialogoSelectorColor();
				dialogo.setVisible(true);
				dialogo.dispose();
				
//				 JOptionPane.showMessageDialog(MiBoton.this, MiBoton.this.getText());
//				Color seleccionado = JColorChooser.showDialog(MiBotonColorido.this, "Selecciona un color para " + columna + "-" + fila,
//						MiBotonColorido.this.getForeground());
//				
//				if (seleccionado != null) {
//					MiBotonColorido.this.setForeground(seleccionado);
//				}
			}
		});

	}

}
