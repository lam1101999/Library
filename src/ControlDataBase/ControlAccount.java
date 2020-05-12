package ControlDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Entity.Account;

public class ControlAccount {

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
	public static Account find(String ID) {
		Account account = null;
		Connection conn = new MyConnection().getConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from account where Account_ID = '"+ID+"'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String tempAccount_ID = rs.getString(1);
				String tempPassword = rs.getString(2);
				String tempName = rs.getString(3);
				String tempAddress = rs.getString(4);
				int tempPhone_Number = Integer.parseInt(rs.getString(5));
				String tempEmail = rs.getString(6);
				account = new Account(tempAccount_ID, tempName, tempAddress, tempPhone_Number, tempEmail);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return account;
	}
}
