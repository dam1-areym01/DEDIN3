package EJ6;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MiBoton extends JButton {

	int columna;
	int fila;

	public MiBoton(int columna, int fila) {
		super(fila + "-" + columna);
		this.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 15));
		this.setText(fila + "-" + columna);
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MiBoton.this, MiBoton.this.getText());
			}
		});

	}

}
