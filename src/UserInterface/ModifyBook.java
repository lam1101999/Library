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

import ControlDataBase.ControlAuthor;
import ControlDataBase.ControlBook;
import ControlDataBase.ControlHave;
import ControlDataBase.ControlTag;
import ControlDataBase.MyConnection;
import Entity.Author;
import Entity.Tag;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JComboBox;

public class ModifyBook extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane1;
	private JTextField txtName, txtYear, txtBook_ID;
	private JComboBox comboBoxAuthor, comboBoxTag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyBook frame = new ModifyBook();
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
	public ModifyBook() {

		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		contentPane = new JPanel();
		contentPane.setBounds(0, 11, 684, 461);
		this.getContentPane().add(contentPane);
		contentPane.setLayout(null);

		JLabel lblModifyBook = new JLabel("Modify Book");
		lblModifyBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifyBook.setBounds(292, 11, 148, 45);
		contentPane.add(lblModifyBook);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(44, 95, 85, 14);
		contentPane.add(lblNewLabel);

		JLabel lblStatus = new JLabel("Book_ID:");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setBounds(44, 56, 85, 14);
		contentPane.add(lblStatus);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookName = txtName.getText();
				String year = txtYear.getText();
				Author author = (Author) comboBoxAuthor.getSelectedItem();
				Tag tag = (Tag) comboBoxTag.getSelectedItem();
				int k = ControlBook.insert(bookName, year, author.getAuthor_ID());

				Connection conn = new MyConnection().getConnection();
				PreparedStatement stmt;
				try {
					stmt = conn.prepareStatement("SELECT * FROM book where Name = ?");
					stmt.setString(1, bookName);
					ResultSet rs = stmt.executeQuery();
					String book_ID = null;
					while (rs.next()) {
						book_ID = rs.getString("Book_ID");
					}
					if (book_ID != null) {
						int j = ControlHave.insert(tag.getTag_ID(), book_ID);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (k == 1) {
					JOptionPane.showMessageDialog(null, "insert success", "Message", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "insert not success", "Message", JOptionPane.WARNING_MESSAGE);
				}
				load_Book();
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

				int k = ControlBook.delete(ID);
				if (k == 1) {
					JOptionPane.showMessageDialog(null, "delete success", "Message", JOptionPane.WARNING_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "delete not success", "Message", JOptionPane.WARNING_MESSAGE);
				}
				load_Book();
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
				String newName = txtName.getText();
				String newYear = txtYear.getText();
				Author author = (Author) comboBoxAuthor.getSelectedItem();
				Tag tag = (Tag) comboBoxTag.getSelectedItem();

				int k = ControlBook.edit(ID, newName, newYear, author.getAuthor_ID());
				int j = ControlHave.edit(ID, tag.getTag_ID());
				if (k == 1 && j == 1) {
					JOptionPane.showMessageDialog(null, "edit success", "Message", JOptionPane.WARNING_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "edit not success", "Message", JOptionPane.WARNING_MESSAGE);
				}
				load_Book();
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
				txtBook_ID.setText(d.getValueAt(selectedRow, 0).toString());
				txtName.setText(d.getValueAt(selectedRow, 1).toString());
				txtYear.setText(d.getValueAt(selectedRow, 2).toString());

				try {
					Connection conn = new MyConnection().getConnection();
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(
							"select * from author where Name = '" + d.getValueAt(selectedRow, 3).toString() + "'");
					rs.next();
					for (int i = 0; i < comboBoxAuthor.getItemCount(); i++) {
						Author temp = (Author) comboBoxAuthor.getItemAt(i);
						if (temp.getAuthor_ID().equals(rs.getString("Author_ID"))) {
							comboBoxAuthor.setSelectedIndex(i);
						}
					}

				} catch (SQLException ex) {
					ex.printStackTrace();
				}

				try {
					Connection conn = new MyConnection().getConnection();
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(
							"select * from tag where Name = '" + d.getValueAt(selectedRow, 4).toString() + "'");
					rs.next();
					for (int i = 0; i < comboBoxTag.getItemCount(); i++) {
						Tag temp = (Tag) comboBoxTag.getItemAt(i);
						if (temp.getTag_ID().equals(rs.getString("Tag_ID"))) {
							comboBoxTag.setSelectedIndex(i);
						}
					}

				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			}
		});
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Book_ID", "Name", "Year", "Author", "Tag" }) {
					Class[] columnTypes = new Class[] { Integer.class, String.class, Integer.class, String.class,
							String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});

		scrollPane1 = new JScrollPane(table);
		scrollPane1.setBounds(276, 56, 398, 308);
		contentPane.add(scrollPane1);

		JLabel lblDescription = new JLabel("Year:");
		lblDescription.setBounds(44, 129, 71, 14);
		contentPane.add(lblDescription);

		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(44, 161, 46, 14);
		contentPane.add(lblAuthor);

		JLabel lblTag = new JLabel("Tag:");
		lblTag.setBounds(44, 196, 46, 14);
		contentPane.add(lblTag);

		txtName = new JTextField();
		txtName.setBounds(125, 92, 100, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtYear = new JTextField();
		txtYear.setBounds(125, 126, 100, 20);
		contentPane.add(txtYear);
		txtYear.setColumns(10);

		comboBoxAuthor = new JComboBox();
		comboBoxAuthor.setBounds(125, 158, 100, 20);
		comboBoxAuthor.removeAllItems();
		try {
			Connection conn = new MyConnection().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from author");
			while (rs.next()) {
				comboBoxAuthor.addItem(new Author(rs.getString("Author_ID"), rs.getString("Name")));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		contentPane.add(comboBoxAuthor);

		comboBoxTag = new JComboBox();
		comboBoxTag.setBounds(125, 193, 100, 20);
		comboBoxTag.removeAllItems();
		try {
			Connection conn = new MyConnection().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tag");
			while (rs.next()) {
				comboBoxTag.addItem(new Tag(rs.getString("Tag_ID"), rs.getString("Name")));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		contentPane.add(comboBoxTag);

		txtBook_ID = new JTextField();
		txtBook_ID.setBounds(125, 53, 100, 20);
		contentPane.add(txtBook_ID);
		txtBook_ID.setColumns(10);

		load_Book();

	}

	public void load_Book() {
		DefaultTableModel d = (DefaultTableModel) table.getModel();
		d.setRowCount(0);
		Vector v = ControlBook.findAll();
		for (int i = 0; i < v.size(); i++) {
			d.addRow((Vector) v.get(i));
		}

	}
}
