package UserInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import Keeptrack.CurrentAccount;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChooseFunction extends JFrame{

	private JPanel contentPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseFunction window = new ChooseFunction();
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
	public ChooseFunction() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblLibrary = new JLabel("Library");
		lblLibrary.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibrary.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblLibrary.setBounds(105, 26, 157, 46);
		getContentPane().add(lblLibrary);
		
		JButton btnBorrowBook = new JButton("Borrow Book");
		btnBorrowBook.setBounds(105, 106, 157, 46);
		getContentPane().add(btnBorrowBook);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.setBounds(105, 163, 157, 40);
		getContentPane().add(btnReturnBook);
		
		JButton btnModifyInformation = new JButton("Modify Information");
		btnModifyInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ModifyInformation modify = new ModifyInformation();
				modify.setTitle("Modify");
				modify.setVisible(true);
			}
		});
		btnModifyInformation.setBounds(105, 214, 157, 44);
		getContentPane().add(btnModifyInformation);
		
		JButton btnManageAccount = new JButton("Manage Account");
		btnManageAccount.setBounds(105, 269, 157, 44);
		getContentPane().add(btnManageAccount);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				CurrentAccount.resetAcccount();
				Login login = new Login();
				login.setTitle("Login");
				login.setVisible(true);
			}
		});
		btnLogout.setBounds(105, 324, 157, 40);
		getContentPane().add(btnLogout);
	}

}
