package UserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ControlDataBase.ControlAccount;
import ControlDataBase.ControlAuthor;
import ControlDataBase.ControlHave;
import ControlDataBase.ControlHave_Job;
import ControlDataBase.ControlTag;
import ControlDataBase.MyConnection;
import Entity.Job;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class ManageAccount extends JFrame {

	private JTextField txtAccount_ID;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane1;
	private JLabel txtAuthor_ID;
	private JPasswordField txtPassword;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhoneNumber;
	private JTextField txtEmail;
	private JComboBox comboBoxJob;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageAccount frame = new ManageAccount();
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
	public ManageAccount() {

		this.setSize(880, 460);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
                this.setResizable(false);

		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 880, 460);
                contentPane.setBackground(Color.BLACK);
		this.getContentPane().add(contentPane);
		contentPane.setLayout(null);

		JLabel lblModifyAccount = new JLabel("Manage Account");
		lblModifyAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifyAccount.setBounds(292, 5, 250, 45);
                lblModifyAccount.setForeground(Color.WHITE);
                lblModifyAccount.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblModifyAccount);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setBounds(10, 81, 85, 14);
                lblPassword.setForeground(Color.WHITE);
		contentPane.add(lblPassword);

		JLabel lblAccount = new JLabel("Account ID");
		lblAccount.setHorizontalAlignment(SwingConstants.LEFT);
		lblAccount.setBounds(10, 56, 85, 14);
                lblAccount.setForeground(Color.WHITE);
		contentPane.add(lblAccount);

		txtAccount_ID = new JTextField();
		txtAccount_ID.setBounds(105, 53, 148, 20);
                txtAccount_ID.setBorder(null);
		contentPane.add(txtAccount_ID);
		txtAccount_ID.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account_ID = txtAccount_ID.getText();
				String password = txtPassword.getText();
				String name = txtName.getText();
				String address = txtAddress.getText();
				String phone_Number = txtPhoneNumber.getText();
				String email = txtEmail.getText();
				Job job = (Job) comboBoxJob.getSelectedItem();
				int k = ControlAccount.insert(account_ID, password, name, address, phone_Number, email);
				int j = ControlHave_Job.insert(job.getJob_ID(), account_ID);

				if (k == 1) {
					JOptionPane.showMessageDialog(null, "insert success", "Message", JOptionPane.WARNING_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "insert not success", "Message", JOptionPane.WARNING_MESSAGE);
				}
				load_Account();
			}
		});
		btnAdd.setBounds(44, 275, 148, 35);
                btnAdd.setBackground(Color.WHITE);
		contentPane.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				int selectedRow = table.getSelectedRow();
				String ID = d.getValueAt(selectedRow, 0).toString();

				int k = ControlAccount.delete(ID);
				if (k == 1) {
					JOptionPane.showMessageDialog(null, "delete success", "Message", JOptionPane.WARNING_MESSAGE);
					txtAccount_ID.setText("");
					txtAccount_ID.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "delete not success", "Message", JOptionPane.WARNING_MESSAGE);
				}
				load_Account();
			}
		});
		btnDelete.setBounds(44, 321, 148, 35);
                btnDelete.setBackground(Color.WHITE);
		contentPane.add(btnDelete);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				int selectedRow = table.getSelectedRow();
				String ID = d.getValueAt(selectedRow, 0).toString();
				String password = txtPassword.getText();
				String name = txtName.getText();
				String address = txtAddress.getText();
				String phoneNumber = txtPhoneNumber.getText();
				String email = txtEmail.getText();
				Job job = (Job) comboBoxJob.getSelectedItem();

				int k = ControlAccount.edit(ID, password, name, address, phoneNumber, email);
				int j = ControlHave_Job.edit(job.getJob_ID(), ID);
				if (k == 1) {
					JOptionPane.showMessageDialog(null, "edit success", "Message", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "edit not success", "Message", JOptionPane.WARNING_MESSAGE);
				}
				load_Account();
			}
		});
		btnEdit.setBounds(44, 367, 148, 35);
                btnEdit.setBackground(Color.WHITE);
		contentPane.add(btnEdit);

		JButton btnCancel = new JButton("Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ChooseFunction chooseFunction = new ChooseFunction();
				chooseFunction.setTitle("Welcome");
				chooseFunction.setVisible(true);// making the frame visible
			}
		});
		btnCancel.setBounds(738, 367, 118, 35);
                btnCancel.setBackground(Color.WHITE);
		contentPane.add(btnCancel);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				int selectedRow = table.getSelectedRow();
				txtAccount_ID.setText(d.getValueAt(selectedRow, 0).toString());
				txtPassword.setText(d.getValueAt(selectedRow, 1).toString());
				txtName.setText(d.getValueAt(selectedRow, 2).toString());
				txtAddress.setText(d.getValueAt(selectedRow, 3).toString());
				txtPhoneNumber.setText(d.getValueAt(selectedRow, 4).toString());
				txtEmail.setText(d.getValueAt(selectedRow, 5).toString());
				try {
					Connection conn = new MyConnection().getConnection();
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(
							"select * from job where Name = '" + d.getValueAt(selectedRow, 6).toString() + "'");
					rs.next();
					for (int i = 0; i < comboBoxJob.getItemCount(); i++) {
						Job temp = (Job) comboBoxJob.getItemAt(i);
						if (temp.getJob_ID().equals(rs.getString("Job_ID"))) {
							comboBoxJob.setSelectedIndex(i);
						}
					}

				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Account_ID", "Password", "Name", "Address", "Phone Number", "Email", "Role" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(96);
		table.getColumnModel().getColumn(1).setPreferredWidth(87);
		table.getColumnModel().getColumn(2).setPreferredWidth(104);
		table.getColumnModel().getColumn(3).setPreferredWidth(113);
		table.getColumnModel().getColumn(4).setPreferredWidth(92);
		table.getColumnModel().getColumn(5).setPreferredWidth(71);

		scrollPane1 = new JScrollPane(table);
		scrollPane1.setBounds(263, 49, 593, 308);
		contentPane.add(scrollPane1);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 106, 71, 14);
                lblName.setForeground(Color.WHITE);
		contentPane.add(lblName);

		JLabel lblPhone = new JLabel("Phone Number");
		lblPhone.setBounds(10, 156, 85, 14);
                lblPhone.setForeground(Color.WHITE);
		contentPane.add(lblPhone);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 131, 60, 14);
                lblAddress.setForeground(Color.WHITE);
		contentPane.add(lblAddress);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 181, 46, 14);
                lblEmail.setForeground(Color.WHITE);
		contentPane.add(lblEmail);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(105, 78, 148, 20);
                txtPassword.setBorder(null);
		contentPane.add(txtPassword);

		txtName = new JTextField();
		txtName.setBounds(105, 103, 148, 20);
                txtName.setBorder(null);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setBounds(105, 128, 148, 20);
                txtAddress.setBorder(null);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setBounds(105, 153, 148, 20);
                txtPhoneNumber.setBorder(null);
		contentPane.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(105, 178, 148, 20);
                txtEmail.setBorder(null);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblRole = new JLabel("Job");
		lblRole.setBounds(10, 213, 46, 14);
                lblRole.setForeground(Color.WHITE);
		contentPane.add(lblRole);

		comboBoxJob = new JComboBox();
		comboBoxJob.setBounds(105, 213, 148, 20);
                comboBoxJob.setBorder(null);
		contentPane.add(comboBoxJob);
		comboBoxJob.removeAllItems();
		try {
			Connection conn = new MyConnection().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from job");
			while (rs.next()) {
				comboBoxJob.addItem(new Job(rs.getString("Job_ID"), rs.getString("Name")));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		load_Account();

	}

	public void load_Account() {
		DefaultTableModel d = (DefaultTableModel) table.getModel();
		d.setRowCount(0);
		Vector v = ControlAccount.findAll();
		for (int i = 0; i < v.size(); i++) {
			d.addRow((Vector) v.get(i));
		}

	}
}
