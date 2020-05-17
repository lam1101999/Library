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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ModifyAuthor extends JFrame {

	private JTextField txtAuthor;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
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

		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 684, 461);
		this.getContentPane().add(contentPane);
		contentPane.setLayout(null);

		JLabel lblModifyBook = new JLabel("Modify Author");
		lblModifyBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifyBook.setBounds(292, 11, 148, 45);
		contentPane.add(lblModifyBook);

		JLabel lblNewLabel = new JLabel("Author name:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(44, 95, 85, 14);
		contentPane.add(lblNewLabel);

		JLabel lblStatus = new JLabel("Author_ID:");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setBounds(44, 56, 85, 14);
		contentPane.add(lblStatus);

		txtAuthor_ID = new JLabel("");
		txtAuthor_ID.setBounds(118, 56, 107, 14);
		contentPane.add(txtAuthor_ID);

		txtAuthor = new JTextField();
		txtAuthor.setBounds(118, 92, 148, 20);
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
		contentPane.add(btnAdd);

		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(44, 321, 148, 43);
		contentPane.add(btnNewButton);

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
		btnEdit.setBounds(44, 375, 148, 35);
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
		btnCancel.setBounds(515, 375, 118, 35);
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

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(276, 56, 398, 308);
		contentPane.add(scrollPane);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(44, 129, 71, 14);
		contentPane.add(lblDescription);
		
		txtDescription = new JTextArea();
		txtDescription.setBounds(118, 124, 148, 94);
		contentPane.add(txtDescription);
		
		JLabel lblBirthyear = new JLabel("Birthyear");
		lblBirthyear.setBounds(44, 234, 46, 14);
		contentPane.add(lblBirthyear);
		
		txtBirthyear = new JTextField();
		txtBirthyear.setBounds(118, 231, 148, 20);
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
