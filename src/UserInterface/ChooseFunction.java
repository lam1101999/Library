package UserInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import Keeptrack.CurrentAccount;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class ChooseFunction extends JFrame {

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

		this.setSize(380, 480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
                this.setResizable(false);
                
                contentPanel = new JPanel();
		contentPanel.setBackground(Color.BLACK);
                contentPanel.setBounds(0, 0, 380, 480);
                this.getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JLabel lblLibrary = new JLabel("Library");
		lblLibrary.setHorizontalAlignment(SwingConstants.CENTER);
                lblLibrary.setForeground(Color.WHITE);
		lblLibrary.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLibrary.setBounds(105, 26, 157, 46);
		contentPanel.add(lblLibrary);

		JButton btnBorrowBook = new JButton("Borrow Book");
		btnBorrowBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            String job = CurrentAccount.getCurrentAccount().getJob()[0];
                            if (job.equals("Student") || job.equals("Lecturer")) {
				dispose();
				BorrowBook borrowBook = new BorrowBook();
				borrowBook.setTitle("Borrow");
				borrowBook.setVisible(true);
                            } else
				JOptionPane.showMessageDialog(null, "You cannot access this!!!", "Message",
                                JOptionPane.WARNING_MESSAGE);
			}
                            
		});
		btnBorrowBook.setBounds(105, 136, 157, 46);
                btnBorrowBook.setBackground(Color.WHITE);
		contentPanel.add(btnBorrowBook);

		JButton btnModifyInformation = new JButton("Modify Information");
		btnModifyInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            String job = CurrentAccount.getCurrentAccount().getJob()[0];
                            if (job.equals("Staff")) {
				dispose();
				ModifyInformation modify = new ModifyInformation();
				modify.setTitle("Modify");
				modify.setVisible(true);
                            }else
				JOptionPane.showMessageDialog(null, "You cannot access this!!!", "Message",
				JOptionPane.WARNING_MESSAGE);
			}
		});
		btnModifyInformation.setBounds(105, 193, 157, 44);
                btnModifyInformation.setBackground(Color.WHITE);
		contentPanel.add(btnModifyInformation);

		JButton btnManageAccount = new JButton("Manage Account");
		btnManageAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            String job = CurrentAccount.getCurrentAccount().getJob()[0];
                            if (job.equals("Manager")) {
				dispose();
				ManageAccount manageAccount = new ManageAccount();
				manageAccount.setTitle("Account");
				manageAccount.setVisible(true);
                            }else
                                JOptionPane.showMessageDialog(null, "You cannot access this!!!", "Message",
                                JOptionPane.WARNING_MESSAGE);
			}
		});
		btnManageAccount.setBounds(105, 248, 157, 44);
                btnManageAccount.setBackground(Color.WHITE);
		contentPanel.add(btnManageAccount);

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
		btnLogout.setBounds(105, 358, 157, 44);
                btnLogout.setBackground(Color.WHITE);
		contentPanel.add(btnLogout);
                
                JButton btnAdvance = new JButton("Advance");
		btnAdvance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String job = CurrentAccount.getCurrentAccount().getJob()[0];
				if (job.equals("Manager")) {
					dispose();
					Advance advance = new Advance();
					advance.setTitle("Advance");
					advance.setVisible(true);
				} else
					JOptionPane.showMessageDialog(null, "You cannot access this!!!", "Message",
                                        JOptionPane.WARNING_MESSAGE);
			}
		});
		btnAdvance.setBounds(105, 303, 157, 44);
                btnAdvance.setBackground(Color.WHITE);
		contentPanel.add(btnAdvance);
	}

}
