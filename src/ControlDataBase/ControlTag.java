package ControlDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import Entity.Tag;

public class ControlTag {
	public static int insert(String Tag) {
		Connection conn = new MyConnection().getConnection();
		int rs = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("Insert into Tag values (?)");
			stmt.setString(1, Tag);
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
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Tag");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Vector v2 = new Vector();
				v2.add(rs.getString("Tag_ID"));
				v2.add(rs.getString("Name"));
				v.add(v2);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return v;
	}

	public static int edit(String ID, String newTag) {
		Connection conn = new MyConnection().getConnection();
		int rs = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE tag SET Name = ? Where Tag_ID = ?");
			stmt.setString(1, newTag);
			stmt.setString(2, ID);

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
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM tag WHERE Tag_ID=?");
			stmt.setString(1, ID);

			rs = stmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}
}
