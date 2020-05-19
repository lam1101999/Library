package ControlDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
				if (UserName.equals(TempUserName) && Password.equals(TempPassword))
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
			String query = "select * from account where Account_ID = '" + ID + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String tempAccount_ID = rs.getString(1);
				String tempPassword = rs.getString(2);
				String tempName = rs.getString(3);
				String[] jobs = findJob(tempAccount_ID);
				String tempAddress = rs.getString(4);
				int tempPhone_Number = Integer.parseInt(rs.getString(5));
				String tempEmail = rs.getString(6);
				account = new Account(tempAccount_ID, null, tempName, jobs, tempAddress, tempPhone_Number, tempEmail);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return account;
	}

	public static String[] findJob(String ID) {
		ArrayList<String> list = new ArrayList<>();
		Connection conn = new MyConnection().getConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "select ac.Name, j.Name " + "from account ac "
					+ "join have_job h on h.Account_ID = ac.Account_ID "
					+ "join job j on j.Job_ID = h.Job_ID where ac.Account_ID = '" + ID + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				list.add(rs.getString(2));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		String[] jobs = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			jobs[i] = list.get(i);
		}
		return jobs;
	}

	public static Vector findAll() {
		Connection conn = new MyConnection().getConnection();
		Vector v = new Vector();
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"SELECT a.Account_ID,a.Password,a.Name,a.Address,a.Phone_Number,a.Email , j.Name\r\n"
							+ "FROM account a \r\n" + "Join have_job h on a.Account_ID = h.Account_ID \r\n"
							+ "Join job j on h.Job_ID = j.Job_ID");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Vector v2 = new Vector();
				v2.add(rs.getString(1));
				v2.add(rs.getString(2));
				v2.add(rs.getString(3));
				v2.add(rs.getString(4));
				v2.add(rs.getString(5));
				v2.add(rs.getString(6));
				v2.add(rs.getString(7));
				v.add(v2);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return v;
	}

	public static int insert(String account_ID, String password, String name, String address, String phone_Number,
			String email) {
		Connection conn = new MyConnection().getConnection();
		int rs = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("Insert into account values (?,?,?,?,?,?)");
			stmt.setString(1, account_ID);
			stmt.setString(2, password);
			stmt.setString(3, name);
			stmt.setString(4, address);
			stmt.setString(5, phone_Number);
			stmt.setString(6, email);
			rs = stmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	public static int edit(String ID, String password, String name, String address, String phoneNumber, String email) {
		Connection conn = new MyConnection().getConnection();
		int rs = 0;
		try {
			PreparedStatement stmt = conn
					.prepareStatement("UPDATE account SET Password = ?, Name = ?, Address = ?, Phone_Number = ?, Email = ? Where Account_ID = ?");
			stmt.setString(1, password);
			stmt.setString(2, name);
			stmt.setString(3, address);
			stmt.setString(4, phoneNumber);
			stmt.setString(5, email);
			stmt.setString(6, ID);

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
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM account WHERE Account_ID=?");
			stmt.setString(1, ID);

			rs = stmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}
}
