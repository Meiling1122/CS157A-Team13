package cs157aProject;

import java.sql.*;

public class MySQLConn {
	
	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException{
		String hostName = "localhost";
		String dbname = "cs157ateam13project";
	    String userName = "root";
	    String password = "CS157A_is_Fun!";
	    return getMySQLConnection(hostName, dbname, userName, password);
	}
	
	 public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) 
			 throws SQLException, ClassNotFoundException {
	   
	     Class.forName("com.mysql.jdbc.Driver");
	     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
	     Connection conn = DriverManager.getConnection(connectionURL, userName, password);
	     return conn;
	 }
}
