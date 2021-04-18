package trythis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

	Connection con = null;

	// for creating connnction to database
	public Connection getConnecion() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/job_portal", "root", "1254");
			if (con != null) {
				System.out.println("connection estabilshed successfully");

			} else {
				System.out.println("Connection could not connect");
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}

}
