package UserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 567, 378);
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
		btnNewButton.setBounds(158, 72, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Author");
		btnNewButton_1.setBounds(158, 117, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Book");
		btnNewButton_2.setBounds(158, 163, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblModify = new JLabel("Modify");
		lblModify.setBounds(185, 11, 46, 14);
		contentPane.add(lblModify);
	}
}
