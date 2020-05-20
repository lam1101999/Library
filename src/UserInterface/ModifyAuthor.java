package UserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import ControlDataBase.ControlAuthor;
import ControlDataBase.ControlTag;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class ModifyAuthor extends JFrame {

	private JTextField txtAuthor;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane1,scrollPane2;
	private JLabel txtAuthor_ID;
	private JTextField txtBirthyear;
	private JTextArea txtDescription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyAuthor frame = new ModifyAuthor();
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
	public ModifyAuthor() {

		this.setSize(720, 480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
                this.setResizable(false);
                

		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 720, 480);
                contentPane.setBackground(Color.BLACK);
		this.getContentPane().add(contentPane);
		contentPane.setLayout(null);

		JLabel lblModifyAuthor = new JLabel("Modify Author");
		lblModifyAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifyAuthor.setBounds(292, 11, 200, 45);
                lblModifyAuthor.setForeground(Color.WHITE);
                lblModifyAuthor.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblModifyAuthor);

		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setBounds(44, 95, 85, 14);
                lblName.setForeground(Color.WHITE);
		contentPane.add(lblName);

		JLabel lblStatus = new JLabel("Author ID");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setBounds(44, 56, 85, 14);
                lblStatus.setForeground(Color.WHITE);
		contentPane.add(lblStatus);

		txtAuthor_ID = new JLabel("");
		txtAuthor_ID.setBounds(118, 56, 107, 14);
                txtAuthor_ID.setForeground(Color.WHITE);
		contentPane.add(txtAuthor_ID);

		txtAuthor = new JTextField();
		txtAuthor.setBounds(118, 92, 148, 20);
                txtAuthor.setBorder(null);
		contentPane.add(txtAuthor);
		txtAuthor.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String authorName = txtAuthor.getText();
				String description = txtDescription.getText();
				String birthyear = txtBirthyear.getText();
				int k = ControlAuthor.insert(authorName, description, birthyear);
				if (k == 1) {
					JOptionPane.showMessageDialog(null, "insert success", "Message", JOptionPane.WARNING_MESSAGE);
					txtAuthor.setText("");
					txtDescription.setText("");
					txtBirthyear.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "insert not success", "Message", JOptionPane.WARNING_MESSAGE);
				}
				load_Author();
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

				int k = ControlAuthor.delete(ID);
				if (k == 1) {
					JOptionPane.showMessageDialog(null, "delete success", "Message", JOptionPane.WARNING_MESSAGE);
					txtAuthor.setText("");
					txtAuthor.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "delete not success", "Message", JOptionPane.WARNING_MESSAGE);
				}
				load_Author();
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
				String newAuthor = txtAuthor.getText();
				String newDescription = txtDescription.getText();
				String newBirthyear = txtBirthyear.getText();

				int k = ControlAuthor.edit(ID, newAuthor, newDescription, newBirthyear);
				if (k == 1) {
					JOptionPane.showMessageDialog(null, "edit success", "Message", JOptionPane.WARNING_MESSAGE);
					txtAuthor.setText("");
					txtAuthor.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "edit not success", "Message", JOptionPane.WARNING_MESSAGE);
				}
				load_Author();
			}
		});
		btnEdit.setBounds(44, 367, 148, 35);
                btnEdit.setBackground(Color.WHITE);
		contentPane.add(btnEdit);

		JButton btnCancel = new JButton("Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ModifyInformation modify = new ModifyInformation();
				modify.setTitle("Modify");
				modify.setVisible(true);
			}
		});
		btnCancel.setBounds(556, 375, 118, 35);
                btnCancel.setBackground(Color.WHITE);
		contentPane.add(btnCancel);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				int selectedRow = table.getSelectedRow();
				txtAuthor_ID.setText(d.getValueAt(selectedRow, 0).toString());
				txtAuthor.setText(d.getValueAt(selectedRow, 1).toString());
				txtDescription.setText(d.getValueAt(selectedRow, 2).toString());
				txtBirthyear.setText(d.getValueAt(selectedRow, 3).toString());
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Author_ID", "Name", "Description", "Birthyear"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(2).setPreferredWidth(200);

		scrollPane1 = new JScrollPane(table);
		scrollPane1.setBounds(276, 56, 398, 308);
                scrollPane1.setBorder(null);
		contentPane.add(scrollPane1);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(44, 129, 71, 14);
                lblDescription.setForeground(Color.WHITE);
		contentPane.add(lblDescription);
		
		txtDescription = new JTextArea();
		scrollPane2 = new JScrollPane(txtDescription,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		scrollPane2.setBounds(118, 124, 148, 94);
                scrollPane2.setBorder(null);
		contentPane.add(scrollPane2);
		
		JLabel lblBirthyear = new JLabel("Birthyear");
		lblBirthyear.setBounds(44, 234, 71, 14);
                lblBirthyear.setForeground(Color.WHITE);
		contentPane.add(lblBirthyear);
		
		txtBirthyear = new JTextField();
		txtBirthyear.setBounds(118, 231, 148, 20);
                txtBirthyear.setBorder(null);
		contentPane.add(txtBirthyear);
		txtBirthyear.setColumns(10);
		
		
		load_Author();

	}

	public void load_Author() {
		DefaultTableModel d = (DefaultTableModel) table.getModel();
		d.setRowCount(0);
		Vector v = ControlAuthor.findAll();
		for (int i = 0; i < v.size(); i++) {
			d.addRow((Vector) v.get(i));
		}

	}
}
