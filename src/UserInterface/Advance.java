package UserInterface;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ControlDataBase.RunQuery;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Advance extends JFrame {
	private Label l;
	private TextField txtQuery;
	private JButton btnrun;
	private TextArea txtResult;

	public Advance() {
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		BorderLayout layout = new BorderLayout();
		getContentPane().setLayout(layout);

		l = new Label("Query");
		txtQuery = new TextField();
		btnrun = new JButton("Run");
		btnrun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtQuery.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Please input query string", "Message",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				String SQL = txtQuery.getText();
				StringBuilder results;
				results = (new RunQuery(SQL)).executeQuery();
				txtResult.setText(results.toString());
			}
		});

		txtResult = new TextArea();

		getContentPane().add(l, BorderLayout.WEST);
		getContentPane().add(txtQuery, BorderLayout.CENTER);
		getContentPane().add(btnrun, BorderLayout.EAST);
		getContentPane().add(txtResult, BorderLayout.SOUTH);

	}
}
