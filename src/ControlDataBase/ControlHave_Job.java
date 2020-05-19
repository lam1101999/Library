package ControlDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ControlHave_Job {
	public static int insert(String job_ID, String account_Id) {
		Connection conn = new MyConnection().getConnection();
		int rs = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("Insert into have_job values (?,?)");
			stmt.setString(1, job_ID);
			stmt.setString(2, account_Id);
			rs = stmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	public static int edit(String job_ID, String account_ID) {
		Connection conn = new MyConnection().getConnection();
		int rs = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE have_job SET Job_ID = ? Where Account_ID = ?");
			stmt.setString(1, job_ID);
			stmt.setString(2, account_ID);

			rs = stmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}
}
