package UserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.geometry.Insets;

public class ChooseFunction extends JPanel {
	private int width, height;
	private JButton btnBorrow;
	private JButton btnModify;
	private JButton btnControl;

	public ChooseFunction(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		setSize(this.width, this.height);

		addComponent();

	}

	private void addComponent() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;

		add(new JLabel("<html><h1><strong>Welcome to Sparta's library</strong></h1></html>"), gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new java.awt.Insets(5, 0, 5, 0);

		btnBorrow = createBtnBorrow();
		btnModify = createBtnModify();
		btnControl = createBtnControl();
		

		JPanel buttons = new JPanel(new GridBagLayout());
		buttons.add(btnBorrow, gbc);
		buttons.add(btnModify, gbc);
		buttons.add(btnControl, gbc);

		gbc.weighty = 10;
		add(buttons, gbc);

	}
	
	private JButton createBtnBorrow() {
		JButton btn = new JButton("Borrow Book");
		btn.setPreferredSize(new Dimension(500, 50));
		return btn;
	}
	
	private JButton createBtnModify() {
		JButton btn = new JButton("Modify Book");
		return btn;
	}
	
	private JButton createBtnControl() {
		JButton btn = new JButton("This is my Library");
		return btn;
	}
}
