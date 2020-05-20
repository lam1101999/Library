package UserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlDataBase.ControlAccount;
import Keeptrack.CurrentAccount;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ModifyInformation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyInformation frame = new ModifyInformation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModifyInformation() {
		
		this.setSize(380, 460);
		this.setLocationRelativeTo(null);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
                this.setResizable(false);
		
		contentPane = new JPanel();
                contentPane.setBackground(Color.BLACK);
		contentPane.setBounds(0, 0, 380, 460);
		this.getContentPane().add(contentPane);
		contentPane.setLayout(null);
                
		
		JButton btnNewButton = new JButton("Tag");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModifyTag modifyTag = new ModifyTag();
				modifyTag.setTitle("Modify Tag");
				modifyTag.setVisible(true);
			}
		});
		btnNewButton.setBounds(105, 136, 157, 46);
                btnNewButton.setBackground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Author");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModifyAuthor modifyAuthor = new ModifyAuthor();
				modifyAuthor.setTitle("Modify Author");
				modifyAuthor.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(105, 193, 157, 44);
                btnNewButton_1.setBackground(Color.WHITE);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Book");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModifyBook modifyBook = new ModifyBook();
				modifyBook.setTitle("Modify Author");
				modifyBook.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(105, 248, 157, 44);
                btnNewButton_2.setBackground(Color.WHITE);
		contentPane.add(btnNewButton_2);
		
		JLabel lblModify = new JLabel("Modify");
                lblModify.setHorizontalAlignment(SwingConstants.CENTER);
		lblModify.setBounds(105, 26, 157, 46);
                lblModify.setFont(new Font("Tahoma", Font.BOLD, 25));
                lblModify.setForeground(Color.WHITE);
		contentPane.add(lblModify);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ChooseFunction chooseFunction = new ChooseFunction();
				chooseFunction.setTitle("Welcome");
				chooseFunction.setVisible(true);// making the frame visible
			}
		});
		btnBack.setBounds(105, 303, 157, 40);
                btnBack.setBackground(Color.WHITE);
		contentPane.add(btnBack);
	}
}
