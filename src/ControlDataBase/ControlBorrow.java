package ControlDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ControlBorrow {

	public static Vector findAll(String account_ID) {
		Connection conn = new MyConnection().getConnection();
		Vector v = new Vector();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT b.Name, bo.BorrowDate, bo.ReturnDate\r\n"
					+ "FROM borrow bo\r\n" + "Join account a on a.Account_ID = bo.Account_ID \r\n"
					+ "Join book b on b.Book_ID = bo.Book_ID\r\n" + "Where bo.Is_Return = 0 AND bo.Account_ID = '"
					+ account_ID + "'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Vector v2 = new Vector();
				v2.add(rs.getString(1));
				v2.add(rs.getString(2));
				v2.add(rs.getString(3));

				v.add(v2);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return v;
	}

	public static int insert(String account_ID, String book_ID, java.sql.Date borrowDate, java.sql.Date returnDate) {
		Connection conn = new MyConnection().getConnection();
		int rs = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("Insert into borrow values (?,?,?,?,?,?)");
			stmt.setString(1, account_ID);
			stmt.setString(2, book_ID);
			stmt.setString(3, borrowDate.toString());
			stmt.setString(4, returnDate.toString());
			stmt.setString(5, String.valueOf(0));
			stmt.setString(6, String.valueOf(0));
			rs = stmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}
	
	public static int returnBook(String account_ID, String book_ID) {
		Connection conn = new MyConnection().getConnection();
		int rs = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE borrow SET Is_Return = ? Where Account_Id = ? AND Book_ID = ?");
			stmt.setString(1, String.valueOf(1));
			stmt.setString(2, account_ID);
			stmt.setString(3, book_ID);

			rs = stmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

}
