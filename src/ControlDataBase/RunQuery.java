package ControlDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class RunQuery {
	private String query ;
	
	public static void main(String[] args) {
		StringBuilder rs = (new RunQuery("select * from author")).executeQuery();
		System.out.println(rs.toString());
	}
	public RunQuery(String query) {
		this.query = query;
	}

	public StringBuilder executeQuery() {
		StringBuilder results = new StringBuilder();
		try {
			// Connect to database
			Connection conn = MyConnection.getConnection();
			// Run query
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// fetch result
			ResultSetMetaData metaData = rs.getMetaData();
			int numberOfColumns = metaData.getColumnCount();

			for (int i = 1; i <= numberOfColumns; i++) {
				String result = String.format("%-50s", metaData.getColumnName(i));
				results.append(result).append("\t");
			}
			results.append("\n");

			while (rs.next()) {
				for (int i = 1; i <= numberOfColumns; i++) {
					String result = String.format("%-50s", rs.getString(i));
					results.append(result).append("\t");
				}
				results.append("\n");
			}

			// close connection
			conn.close();
			return results;
		} catch (Exception ex) {
			ex.printStackTrace();
			results.append("wrong query!");
			return results;
		}

	}

	
}
