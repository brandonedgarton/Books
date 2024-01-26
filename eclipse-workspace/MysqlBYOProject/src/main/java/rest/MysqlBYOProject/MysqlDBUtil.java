package rest.MysqlBYOProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public final class MysqlDBUtil {
	
	private static java.sql.Connection con = null;
	private static String url;
	private static String serverName;
	private static String portNumber;
	private static String userName;
	private static String password;
	private static String database;
	private static String driver;
	
	//Private so cannot be instantiated
	private MysqlDBUtil() {
		
	}
	
	//Static block loads when application first loads
	static {
		//Pulls jdbc properties
		ResourceBundle rb = ResourceBundle.getBundle("jdbc");
		url = rb.getString("mariadb.url");
		serverName = rb.getString("mariadb.serverName");
		portNumber = rb.getString("mariadb.portNumber");
		userName = rb.getString("mariadb.userName");
		password = rb.getString("mariadb.password");
		database = rb.getString("mariadb.database");
		driver = rb.getString("mariadb.driver");
	}
	
	public static Connection getConnection() {
		try {
			String connectionURL = url + serverName + ":" + portNumber + "/" +database;
			
			Class.forName(driver);
			con = DriverManager.getConnection(connectionURL, userName, password);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error Trace in getConnection() : " + e.getMessage());
		}
		return con;
	}

}
