package UserInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ControlDataBase.CheckAccount;
import ControlDataBase.MyConnection;

public class Login extends JPanel {
	private int width, height;
	private JTextField user;
	private JTextField password;
	private JButton btnLogin;

	public Login(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		setSize(this.width, this.height);

		addComponent();
	}

	public void addComponent() {
		// set layout
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridBagLayout());
		// a welcome string
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;

		add(new JLabel("<html><h1><strong>Login</strong></h1></html>"), gbc);
		// add some main component
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new java.awt.Insets(5, 0, 5, 0);

		user = new JTextField("User name");
		password = new JTextField("Password");
		btnLogin = createbtnLogin();

		JPanel buttons = new JPanel(new GridBagLayout());
		buttons.add(user, gbc);
		buttons.add(password, gbc);
		buttons.add(btnLogin, gbc);

		gbc.weighty = 10;
		add(buttons, gbc);

	}

	public JButton createbtnLogin() {
		JButton btn = new JButton("Login");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UserName = user.getText();
				String Password = password.getText();
				if(CheckAccount.check(UserName, Password)) {
					JOptionPane.showMessageDialog(null, "success", "Message",
							JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "cannot find", "Message",
							JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		return btn;
	}
}
