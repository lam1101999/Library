package UserInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import ControlDataBase.ControlAccount;
import ControlDataBase.MyConnection;
import Keeptrack.CurrentAccount;

public class Login extends JFrame {
	private int width, height;
	private JTextField user;
	private JTextField password;
	private JButton btnLogin;
	private JPanel contentPane;
	private static Login login = null;


	public Login(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		setSize(this.width, this.height);
		setTitle("Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		

		addComponent();
	}

	private void addComponent() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// set layout
		contentPane.setLayout(new GridBagLayout());
		// a welcome string
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;

		contentPane.add(new JLabel("<html><h1><strong>Login</strong></h1></html>"), gbc);
		// add some main component
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new java.awt.Insets(5, 0, 5, 0);

		user = new JTextField("");
		password = new JTextField("");
		btnLogin = createbtnLogin();

		contentPane.add(user, gbc);
		contentPane.add(password, gbc);
		contentPane.add(btnLogin, gbc);

		gbc.weighty = 10;


	}

	private JButton createbtnLogin() {
		JButton btn = new JButton("Login");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UserName = user.getText();
				String Password = password.getText();
				if (ControlAccount.check(UserName, Password)) {
					dispose();
					CurrentAccount.setCurrentAccount(ControlAccount.find(UserName));
					ChooseFunction chooseFunction = new ChooseFunction(Login.this.width, Login.this.height);
					chooseFunction.setTitle("Welcome");
					chooseFunction.setVisible(true);// making the frame visible
				} else {
					JOptionPane.showMessageDialog(null, "cannot find", "Message", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		return btn;
	}


}
