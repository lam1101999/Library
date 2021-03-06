package UserInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;

import ControlDataBase.ControlTag;
import Entity.Tag;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModifyTag extends JFrame {

	private JTextField txtTag;
	private JPanel contentPanel;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel txtTag_ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyTag window = new ModifyTag();
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
	public ModifyTag() {
		initialize();
		load_Tag();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setSize(700, 480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
                this.setResizable(false);
                
		contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 700, 480);
                contentPanel.setBackground(Color.BLACK);
		this.getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JLabel lblModifyInformation = new JLabel("Modify Information");
		lblModifyInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifyInformation.setBounds(292, 11, 250, 45);
                lblModifyInformation.setForeground(Color.WHITE);
                lblModifyInformation.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPanel.add(lblModifyInformation);

		JLabel lblNewLabel = new JLabel("Tag name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(44, 95, 64, 14);
                lblNewLabel.setForeground(Color.WHITE);
		contentPanel.add(lblNewLabel);

		JLabel lblStatus = new JLabel("Tag ID");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setBounds(44, 56, 46, 14);
                lblStatus.setForeground(Color.WHITE);
		contentPanel.add(lblStatus);
		
		txtTag_ID = new JLabel("");
		txtTag_ID.setBounds(118, 56, 86, 14);
                txtTag_ID.setForeground(Color.WHITE);
		contentPanel.add(txtTag_ID);

		txtTag = new JTextField();
		txtTag.setBounds(118, 92, 86, 20);
                txtTag.setBorder(null);
		contentPanel.add(txtTag);
		txtTag.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tag = txtTag.getText();
				int k = ControlTag.insert( tag);
				if (k == 1) {
					JOptionPane.showMessageDialog(null, "insert success", "Message", JOptionPane.WARNING_MESSAGE);
					txtTag.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "insert not success", "Message", JOptionPane.WARNING_MESSAGE);
				}
				load_Tag();
			}
		});
		btnAdd.setBounds(44, 178, 148, 35);
                btnAdd.setBackground(Color.WHITE);
		contentPanel.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				int selectedRow = table.getSelectedRow();
				String ID = d.getValueAt(selectedRow, 0).toString();

				int k = ControlTag.delete(ID);
				if (k == 1) {
					JOptionPane.showMessageDialog(null, "delete success", "Message", JOptionPane.WARNING_MESSAGE);
					txtTag.setText("");
					txtTag.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "delete not success", "Message", JOptionPane.WARNING_MESSAGE);
				}
				load_Tag();
			}
		});
		btnDelete.setBounds(44, 224, 148, 35);
                btnDelete.setBackground(Color.WHITE);
		contentPanel.add(btnDelete);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				int selectedRow = table.getSelectedRow();
				String ID = d.getValueAt(selectedRow, 0).toString();
				String newTag = txtTag.getText();

				int k = ControlTag.edit(ID, newTag);
				if (k == 1) {
					JOptionPane.showMessageDialog(null, "edit success", "Message", JOptionPane.WARNING_MESSAGE);
					txtTag.setText("");
					txtTag.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "edit not success", "Message", JOptionPane.WARNING_MESSAGE);
				}
				load_Tag();
			}
		});
		btnEdit.setBounds(44, 270, 148, 35);
                btnEdit.setBackground(Color.WHITE);
		contentPanel.add(btnEdit);

		JButton btnCancel = new JButton("Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ModifyInformation modify = new ModifyInformation();
				modify.setTitle("Modify");
				modify.setVisible(true);
			}
		});
		btnCancel.setBounds(536, 373, 118, 35);
                btnCancel.setBackground(Color.WHITE);
		contentPanel.add(btnCancel);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				int selectedRow = table.getSelectedRow();
				txtTag_ID.setText(d.getValueAt(selectedRow, 0).toString());
				txtTag.setText(d.getValueAt(selectedRow, 1).toString());
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Tag_ID", "Name" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
                
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(252, 64, 402, 298);
		contentPanel.add(scrollPane);
		
		

	}

	public void load_Tag() {
		DefaultTableModel d = (DefaultTableModel) table.getModel();
		d.setRowCount(0);
		Vector v = ControlTag.findAll();
		for (int i = 0; i < v.size(); i++) {
			d.addRow((Vector) v.get(i));
		}
	}
}
