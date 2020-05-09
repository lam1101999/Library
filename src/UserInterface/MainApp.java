package UserInterface;

import javax.swing.JFrame;

public class MainApp extends JFrame {
	public MainApp(int width, int height) {

		add(new Login(width, height));
		setSize(width, height);
		setTitle("books");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MainApp(800, 500);
	}
}
