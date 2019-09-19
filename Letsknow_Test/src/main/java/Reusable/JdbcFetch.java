package Reusable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class JdbcFetch {
	String actualname;
	String actualPassword;
	JDBC obj = JDBC.getInstance();
	Logger log = Logger.getLogger(" ");

	public String Username(String firstName) throws SQLException, ClassNotFoundException {
		obj.openConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:8090/letsknow/#/login", "root", "root");
		log.info("In username method.....");
		ResultSet rs = obj.executeQuery("select user_name from USER where first_name = '" + firstName + "'");
		log.info("Fetching value from database");
		actualname = rs.getString("user_name");
		log.info(rs + " is available in database");
		return actualname;
	}

	public String Password(String firstName) throws SQLException {
		log.info("In password method.....");
		ResultSet rs = obj.executeQuery("select password from USER where first_name = '" + firstName + "'");
		actualPassword = rs.getString("PASSWORD");
		log.info(rs + " is available in database");
		return actualPassword;

	}

}
