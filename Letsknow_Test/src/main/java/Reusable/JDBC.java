package Reusable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class JDBC {
	private static JDBC obj = new JDBC();

	private JDBC() {
	}

	public static JDBC getInstance() {
		return obj;
	}

	Connection conn = null;
	Statement stmt = null;
	static Logger log = Logger.getLogger(JDBC.class.getName());

	public void openConnection(String driver, String path, String user, String pass)
			throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		// Open a connection
		log.info("Open Connection,Connecting to database...");
		conn = DriverManager.getConnection(path, user, pass);
	}

	public ResultSet executeQuery(String query) throws SQLException {
		// Execute a query
		log.info("Creating statement......");
		stmt = conn.createStatement();
		String sql;
		sql = query;
		ResultSet rs = stmt.executeQuery(sql);

		// Extract data from result set
		/*
		 * try { while(rs.next()) { //Retrieve by column name int id =
		 * rs.getInt("id"); String first = rs.getString("first"); String last =
		 * rs.getString("last");
		 * 
		 * // Display values System.out.print("ID: " + id);
		 * System.out.print(", First: " + first); System.out.println(", Last: "
		 * + last);
		 * 
		 * } } catch (SQLException e) { // TODO Auto-generated catch block
		 * log.error("Error handled");
		 * 
		 * }
		 */
		try {
			rs.first();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error("Error handled");
		}

		return rs;

	}

	public void closeConnection() {

		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se2) {
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		log.info("Connection Closed...");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		JDBC obj = JDBC.getInstance();
		obj.openConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/EMP", "root", "admin");
		obj.openConnection("com.mysql.jdbc.Driver", "jdbc:mysql://http://10.71.12.108:3306/letsknow", "root", "admin");
		obj.executeQuery("SELECT id, first, last FROM Employees");
		obj.closeConnection();

	}

}
