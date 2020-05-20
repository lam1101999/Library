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
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;

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
		
		this.setSize(460, 270);
		this.setLocationRelativeTo(null);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
                this.setResizable(false);
		
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBounds(0, 0, 460, 270);
		this.getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel Welcome = new JLabel("Login");
		Welcome.setFont(new Font("Tahoma", Font.BOLD, 25));
                Welcome.setForeground(Color.WHITE);
		Welcome.setHorizontalAlignment(SwingConstants.CENTER);
		Welcome.setBounds(173, 11, 147, 43);
		contentPanel.add(Welcome);
		
		JLabel User = new JLabel("User");
		User.setFont(new Font("Tahoma", Font.BOLD, 15));
		User.setHorizontalAlignment(SwingConstants.LEFT);
                User.setForeground(Color.WHITE);
		User.setBounds(31, 76, 57, 35);
		contentPanel.add(User);
		
		JLabel Password = new JLabel("Password");
		Password.setFont(new Font("Tahoma", Font.BOLD, 15));
                Password.setForeground(Color.WHITE);
		Password.setBounds(31, 122, 80, 32);
		contentPanel.add(Password);
		
		txtUser = new JTextField();
		txtUser.setBounds(150, 76, 233, 32);
                txtUser.setBorder(null);
		contentPanel.add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(150, 122, 233, 32);
                txtPassword.setBorder(null);
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
		btnLogin.setBounds(150, 177, 89, 32);
		contentPanel.add(btnLogin);
                btnLogin.setBackground(Color.WHITE);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(294, 177, 89, 32);
                btnCancel.setBackground(Color.WHITE);
		contentPanel.add(btnCancel);
	}
}
