package dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.User;

public class UserDB {

	public static boolean userRegistration(String firstName, String lastName, String email, String username, String password, String birthday, String sex, String city) {

		Connection conn = DataBase.openConnection();
		if (conn != null) {
			System.out.println("Successful connection "+(new Date()));
			Statement stmt = null;
			
			try {
				if (city != null) {
					city = "'"+city+"'";
				}
				if (sex.equals("m")) {
					sex = "true";
				} else if(sex.equals("z")) {
					sex = "false";
				} 
				stmt = conn.createStatement();
				String query ="INSERT INTO USER (FIRST_NAME,LAST_NAME,USERNAME,USER_PASSWORD,EMAIL,BIRTHDAY,SEX,CITY,ACTIVE) VALUES	("+"'"+firstName+"'"+","+"'"+lastName+"'"+","+"'"+username+"'"+","+"'"+password+"'"+","+"'"+email+"'"+","+"'"+birthday+"'"+","+sex+","+city+","+false+")";
				stmt.executeUpdate(query);
			} catch (Exception e) {
				System.out.println("Execute query error "+(new Date()));
				return false;
			} finally {
				DataBase.closeConnection(conn);
			}
		} else {
			System.out.println("Connection problem "+(new Date()));
			return false;
		}
		return true;
	}
	
	public static boolean activateUser(String username) {
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			Statement stmt = null;
			
			try {
				stmt = conn.createStatement();
				String parameter = "'"+username+"'";
				String query = "UPDATE USER SET ACTIVE = TRUE WHERE USERNAME = "+parameter;
				stmt.executeUpdate(query);
				
			} catch (Exception e) {
				System.out.println("Execute query error "+e+" "+(new Date()));
				return false;
			} finally {
				DataBase.closeConnection(conn);
			}
		} else {
			System.out.println("Connection problem "+(new Date()));
			return false;
		}
		return true;
	}
	
	public static User logInUser(String username, String password) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-DD-mm");
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			System.out.println("Successful connection while loging "+(new Date()));
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.createStatement();
				String parameter1 = "'"+username+"'";
				String parameter2 = "'"+password+"'";
				String query = "SELECT * FROM USER WHERE USERNAME = "+parameter1+" AND USER_PASSWORD = "+parameter2+" AND ACTIVE = TRUE";
				rs = stmt.executeQuery(query);
				rs.next();
				int id = rs.getInt("ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String email = rs.getString("EMAIL");
				Date birthDay = sdf.parse(rs.getString("BIRTHDAY"));
				boolean sex = rs.getBoolean("SEX");
				String city = rs.getString("CITY");
				boolean active = rs.getBoolean("ACTIVE");
				
				User u1 = new User(id,firstName,lastName,username,password,email,birthDay,sex,city,active);
				
				return u1;
				
			} catch (Exception e) {
				System.out.println("Connection problems while loging "+(new Date()));
				return null;
			} finally {
				DataBase.closeConnection(conn);
			}
		} else {
			System.out.println("Connection problems with database while loging "+(new Date()));
			return null;
		}
	}
	
	public static User findUserById(int userId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			System.out.println("Successful connection "+(new Date()));
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				stmt = conn.createStatement();
				String query = "SELECT * FROM USER WHERE ID = "+userId;
				rs = stmt.executeQuery(query);
				rs.next();
				
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("USER_PASSWORD");
				String email = rs.getString("EMAIL");
				Date birthDay = sdf.parse(rs.getString("BIRTHDAY"));
				boolean sex = rs.getBoolean("SEX");
				String city = rs.getString("CITY");
				boolean active = rs.getBoolean("ACTIVE");
				
				User u1 = new User(userId,firstName,lastName,username,password,email,birthDay,sex,city,active);
				return u1;
			} catch (Exception e) {
				System.out.println("ResultSet problem (findUserById method) ");
				return null;
			} finally {
				DataBase.closeConnection(conn);
			}
		} else {
			System.out.println("Connection problem (findUserById method) "+(new Date()));
			return null;
		}
	}
	
	public static boolean editUser(int userId, String firstName, String lastName, String email, String username, String birthday, String sex, String city) {
		
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			Statement stmt = null;
			try {
				stmt = conn.createStatement();
				String query = "UPDATE USER SET FIRST_NAME = "+"'"+firstName+"'"+", LAST_NAME = "+"'"+lastName+"'"+", EMAIL = "+"'"+email+"'"+", USERNAME = "+"'"+username+"'"+", BIRTHDAY = "+"'"+birthday+"'"+", SEX = "+sex+", CITY = "+"'"+city+"' WHERE ID = "+userId;
				stmt.executeUpdate(query);
			} catch (Exception e) {
				System.out.println("Execute query error (editUser method) "+(new Date()));
				return false;
			} finally {
				DataBase.closeConnection(conn);
			}
		} else {
			System.out.println("Database connection problem (editUser method) "+(new Date()));
			return false;
		}
		return true;
	}
	
}
