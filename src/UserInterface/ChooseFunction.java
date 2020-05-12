package UserInterface;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Keeptrack.CurrentAccount;

public class ChooseFunction extends JFrame {
	private static int width, height;
	private JButton btnBorrow;
	private JButton btnModify;
	private JButton btnControl;
	private JPanel contentPane;

	public ChooseFunction(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		setSize(this.width, this.height);
		setTitle("Activity");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		addComponent();

	}

	private void addComponent() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// set layout
		contentPane.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;

		contentPane.add(new JLabel("<html><h1><strong>Welcome "+ CurrentAccount.getCurrentAccount().getName()+" to Sparta's library</strong></h1></html>"), gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new java.awt.Insets(5, 0, 5, 0);

		btnBorrow = createBtnBorrow();
		btnModify = createBtnModify();
		btnControl = createBtnControl();

		contentPane.add(btnBorrow, gbc);
		contentPane.add(btnModify, gbc);
		contentPane.add(btnControl, gbc);

		gbc.weighty = 10;

	}

	private JButton createBtnBorrow() {
		JButton btn = new JButton("Borrow Book");
		btn.setPreferredSize(new Dimension(500, 50));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
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
