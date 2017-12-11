public class Utilidades {

	public void actualizarCanvasVacio() {
		Graphics graficos = canvas.getGraphics(); 
		lienzo.setIcon(new ImageIcon(canvas)); 
		graficos.setColor(Color.WHITE); 
		graficos.fillRect(0, 0, canvas.getHeight(), canvas.getWidth());
		graficos.dispose();
		lienzo.repaint();
	}

	public void crearBorde() {
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY), "JUEGO", TitledBorder.CENTER, TitledBorder.TOP));	
	}
	
	public void cargarFichero() {
		File sFichero = new File("Ficheros");
		JFileChooser archivo = new JFileChooser();
			archivo.setCurrentDirectory(sFichero);
			archivo.setSelectedFile(sFichero);
			archivo.setDialogTitle("Seleccione tema...");
			archivo.setFileFilter(new FileNameExtensionFilter("txt", "txt"));
			int fileSelected = archivo.showOpenDialog(ventana);
	}
	
	public void guardarFichero() {
		File sFichero = new File("Ficheros");
		JFileChooser archivo = new JFileChooser(sFichero);
			archivo.setSelectedFile(new File(sFichero));
			archivo.setDialogTitle("Guardar imagen...");
			archivo.setFileFilter(new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif"));
			int fileSelected = archivo.showSaveDialog(ventana);
	}
	
	public void opcionesFileChooser() {
		JFileChooser.APPROVE_OPTION;
		JFileChooser.CANCEL_OPTION;
		JFileChooser.ERROR_OPTION;
	}
	
	public void slider() {
		slider = new JSlider (0, 500, 250);
		slider.setOpaque(false);
		slider.setMajorTickSpacing(100);
		slider.setMinorTickSpacing(100);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
	}

	public ImageIcon cargarIconoBoton(String rutaImagen, int alto, int ancho) {
		BufferedImage bufferAuxiliar = null;
		try {
			bufferAuxiliar = ImageIO.read(new File(rutaImagen));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ImageIcon(bufferAuxiliar.getScaledInstance(alto, ancho, BufferedImage.SCALE_SMOOTH));
	}
	
	
	
}