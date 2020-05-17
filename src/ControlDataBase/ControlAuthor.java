package ControlDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ControlAuthor {

	public static int insert(String AuthorName, String Description, String Year) {
		Connection conn = new MyConnection().getConnection();
		int rs = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("Insert into author values (?,?,?)");
			stmt.setString(1, AuthorName);
			stmt.setString(2, Description);
			stmt.setString(3, Year);
			rs = stmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	public static Vector findAll() {
		Connection conn = new MyConnection().getConnection();
		Vector v = new Vector();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM author");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Vector v2 = new Vector();
				v2.add(rs.getString("Author_ID"));
				v2.add(rs.getString("Name"));
				v2.add(rs.getString("Description"));
				v2.add(rs.getString("Birthyear"));
				v.add(v2);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return v;
	}

	public static int edit(String ID, String newAuthor, String newDescription, String newBirthyear) {
		Connection conn = new MyConnection().getConnection();
		int rs = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE author SET Name = ?, Description = ?, Birthyear = ? Where Author_ID = ?");
			stmt.setString(1, newAuthor);
			stmt.setString(2, newDescription);
			stmt.setString(3, newBirthyear);
			stmt.setString(4, ID);

			rs = stmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	public static int delete(String ID) {
		Connection conn = new MyConnection().getConnection();
		int rs = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM author WHERE Author_ID=?");
			stmt.setString(1, ID);

			rs = stmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}
}
