package dataBase;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class DataBase {

	private static String username = "root";
	private static String password = "root";
	private static String ipAdress = "localhost";
	private static String port = "3306";
	private static String dataBaseName = "web_advertisement";
	
	public static Connection openConnection() {
		
		try {
			Connection conn;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://"+ipAdress+":"+port+"/"+dataBaseName, username, password);
			return conn;
			
		} catch (Exception e) {
			System.out.println("DataBase connection problems"+e);
			return null;
		}
	}
	
	public static void closeConnection(Connection conn) {

		try {
			if (conn != null) {
				conn.close();
				System.out.println("Connection closed"+(new Date()));
			}
		} catch (Exception e) {
			System.out.println("Closing connection problems"+(new Date()));
		}
	}
	
}
