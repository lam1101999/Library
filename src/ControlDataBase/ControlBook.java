package ControlDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ControlBook {
	public static int insert(String bookName, String year, String author_ID) {
		Connection conn = new MyConnection().getConnection();
		int rs = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("Insert into book values (?,?,?)");
			stmt.setString(1, bookName);
			stmt.setString(2, year);
			stmt.setString(3, author_ID);
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
			PreparedStatement stmt = conn
					.prepareStatement("SELECT b.Book_ID, b.Name,b.Year,a.Name,t.Name FROM book b \r\n"
							+ "join author a on a.Author_ID = b.Author_ID \r\n"
							+ "join have h on h.Book_ID =b.Book_ID\r\n" + "join tag t on t.Tag_ID = h.Tag_ID");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Vector v2 = new Vector();
				v2.add(rs.getString(1));
				v2.add(rs.getString(2));
				v2.add(rs.getString(3));
				v2.add(rs.getString(4));
				v2.add(rs.getString(5));

				v.add(v2);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return v;
	}

	public static int edit(String Book_ID, String newName, String newYear, String newAuthor_ID) {
		Connection conn = new MyConnection().getConnection();
		int rs = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE book SET Name = ?, Year = ?, Author_ID = ? Where Book_ID = ?");
			stmt.setString(1, newName);
			stmt.setString(2, newYear);
			stmt.setString(3, newAuthor_ID);
			stmt.setString(4, Book_ID);

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
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM book WHERE Book_ID=?");
			stmt.setString(1, ID);

			rs = stmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}
}
