package UserInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;

import ControlDataBase.ControlAccount;
import Keeptrack.CurrentAccount;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame{

	private JPanel contentPanel;
	private JTextField txtUser;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		contentPanel = new JPanel();
		contentPanel.setBackground(UIManager.getColor("Table.selectionBackground"));
		contentPanel.setForeground(UIManager.getColor("Table.selectionBackground"));
		contentPanel.setBounds(0, 0, 484, 261);
		this.getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel Welcome = new JLabel("Login");
		Welcome.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 30));
		Welcome.setHorizontalAlignment(SwingConstants.CENTER);
		Welcome.setBounds(173, 11, 147, 43);
		contentPanel.add(Welcome);
		
		JLabel User = new JLabel("User:");
		User.setFont(new Font("Tahoma", Font.PLAIN, 15));
		User.setHorizontalAlignment(SwingConstants.LEFT);
		User.setBounds(31, 76, 57, 35);
		contentPanel.add(User);
		
		JLabel Password = new JLabel("Password:");
		Password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Password.setBounds(31, 122, 72, 32);
		contentPanel.add(Password);
		
		txtUser = new JTextField();
		txtUser.setBounds(132, 76, 233, 32);
		contentPanel.add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(132, 122, 233, 32);
		contentPanel.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tempUserName = txtUser.getText();
				String tempPassword = String.copyValueOf(txtPassword.getPassword());
				if (ControlAccount.check(tempUserName, tempPassword)) {
					dispose();
					CurrentAccount.setCurrentAccount(ControlAccount.find(tempUserName));
					ChooseFunction chooseFunction = new ChooseFunction();
					chooseFunction.setTitle("Welcome");
					chooseFunction.setVisible(true);// making the frame visible
				} else {
					JOptionPane.showMessageDialog(null, "not match any user", "Message", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(132, 177, 89, 32);
		contentPanel.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(276, 177, 89, 32);
		contentPanel.add(btnCancel);
	}
}
