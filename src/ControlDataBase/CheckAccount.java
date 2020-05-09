package ControlDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckAccount {

	public static boolean check(String UserName, String Password) {
		Connection conn = new MyConnection().getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from account");
			while (rs.next()) {
				String TempUserName = rs.getString(1);
				String TempPassword = rs.getString(2);
				if(UserName.equals(TempUserName) && Password.equals(TempPassword))
					return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
