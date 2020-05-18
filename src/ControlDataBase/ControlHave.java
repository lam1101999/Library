package ControlDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ControlHave {
	public static int insert(String tag_ID, String book_ID) {
		Connection conn = new MyConnection().getConnection();
		int rs = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("Insert into have values (?,?)");
			stmt.setString(1, tag_ID);
			stmt.setString(2,book_ID);
			rs = stmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}
	
	public static int edit(String Book_ID, String newTag) {
		Connection conn = new MyConnection().getConnection();
		int rs = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE have SET Tag_ID = ? Where Book_ID = ?");
			stmt.setString(1, newTag);
			stmt.setString(2, Book_ID);

			rs = stmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}
}
