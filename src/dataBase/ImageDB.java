package dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import model.Image;

public class ImageDB {

	public static List<Image> findAdImages(int adId) {
		List<Image> images = new LinkedList<Image>();
		
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.createStatement();
				String query = "SELECT * FROM IMAGE WHERE AD_ID ="+adId;
				rs = stmt.executeQuery(query);
				while(rs.next()) {
					int id = rs.getInt("ID");
					String path = rs.getString("PATH");
					Image img = new Image(id,path,adId);
					images.add(img);
					
				}
			} catch (Exception e) {
				System.out.println("ResultSet problem (findAdImages method) "+(new Date()));
				return null;
			} finally {
				DataBase.closeConnection(conn);
			}
			
		} else {
			System.out.println("DataBase connection problem (findAdImgaes method) "+(new Date()));
			return null;
		}
	
	
		return images;
	}
	
	public static boolean deleteImage(int imageId) {
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			System.out.println("Successful connection with database "+(new Date()));
			Statement stmt = null;
			try {
				stmt = conn.createStatement();
				String query = "DELETE FROM IMAGE WHERE ID = "+imageId;
				stmt.executeUpdate(query);
				return true;
			} catch (Exception e) {
				System.out.println("Execute query problem (deleteImage method) "+(new Date()));
				return false;
			}
		}
		return false;
	}
	
	public static boolean insertImage(String path, int adId) {
		
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			System.out.println("Successful connection with database (insertImage method) "+(new Date()));
			Statement stmt = null;
			try {
				stmt = conn.createStatement();
				String query = "INSERT INTO IMAGE (PATH, AD_ID) VALUES ("+"'"+path+"'"+","+adId+")";
				stmt.executeUpdate(query);
				return true;
				
			} catch (Exception e) {
				System.out.println("Execute query problem (insertImage method) "+(new Date()));
				return false;
			}
		} else {
			System.out.println("DataBase connection problems (insertImage method) "+new Date());
			return false;
		}
	}
	
}
