package dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.sql.StatementEvent;

import model.Ad;
import model.Category;
import model.Image;

public class AdDB {

	public static List<Ad> allAds(){
		List<Ad> ads = new LinkedList<Ad>();	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			System.out.println("Successful connection"+(new Date()));

			try {
				Statement stmt = null;
				ResultSet rs = null;
				
				stmt = conn.createStatement();
				String query = "SELECT * FROM AD ORDER BY POSTING_DATE DESC";
				rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					int id = rs.getInt("ID");
					
					Statement stmt2 = null;
					ResultSet rs2 = null;
					stmt2 = conn.createStatement();
					String query2 = "SELECT * FROM IMAGE WHERE AD_ID ="+id;
					rs2 = stmt2.executeQuery(query2);
					
					List<String> images = new LinkedList<String>();
				
					while(rs2.next()) {
						String path = rs2.getString("PATH");
						images.add(path);
					}
					
					String title = rs.getString("TITLE");
					String detail = rs.getString("DETAIL");
					int categoryId = rs.getInt("CATEGORY_ID");
					
					Statement stmt3 = null;
					ResultSet rs3 = null;
					stmt3 = conn.createStatement();
					String query3 = "SELECT * FROM CATEGORY WHERE ID ="+categoryId;
					rs3 = stmt3.executeQuery(query3);
					rs3.next();
					String categoryName = rs3.getString("CATEGORY_NAME");
					String categoryDescription = rs3.getString("DESCRIPTION");
					Category cat1 = new Category(categoryId,categoryName,categoryDescription);
					
					Date postingDate = sdf.parse(rs.getString("POSTING_DATE"));
					int userId = rs.getInt("USER_ID");
					double price = rs.getDouble("PRICE");
					boolean saleSubjectType = rs.getBoolean("SALE_SUBJECT_TYPE");
					boolean saleSubjectCondition = rs.getBoolean("SALE_SUBJECT_CONDITION");
					
					Ad a1 = new Ad(id,title,detail,categoryId,postingDate,userId,price,saleSubjectType,saleSubjectCondition,images,cat1);
					ads.add(a1);
				}
				
			} catch (Exception e) {
				System.out.println("ResultSet problem "+e+" "+(new Date()));
				return null;
			} finally {
				DataBase.closeConnection(conn);
			}
			
		} else {
			System.out.println("Connection problem"+(new Date()));
			return null;
		}
		
		return ads;
		
	}
	
	public static List<Ad> activeAds() {
		List<Ad> activeAds = new LinkedList<Ad>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			System.out.println("Succesfull connection for active ads"+(new Date()));
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				stmt = conn.createStatement();
				String query = "SELECT * FROM AD WHERE POSTING_DATE > (NOW() - INTERVAL 30 DAY) ORDER BY POSTING_DATE DESC";
				rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					int id = rs.getInt("ID");
					
					Statement stmt2 = null;
					ResultSet rs2 = null;
					stmt2 = conn.createStatement();
					String query2 = "SELECT * FROM IMAGE WHERE AD_ID ="+id;
					rs2 = stmt2.executeQuery(query2);
					
					List<String> images = new LinkedList<String>();
				
					while(rs2.next()) {
						String path = rs2.getString("PATH");
						images.add(path);
					}
					
					String title = rs.getString("TITLE");
					String detail = rs.getString("DETAIL");
					int categoryId = rs.getInt("CATEGORY_ID");
					
					Statement stmt3 = null;
					ResultSet rs3 = null;
					stmt3 = conn.createStatement();
					String query3 = "SELECT * FROM CATEGORY WHERE ID ="+categoryId;
					rs3 = stmt3.executeQuery(query3);
					rs3.next();
					String categoryName = rs3.getString("CATEGORY_NAME");
					String categoryDescription = rs3.getString("DESCRIPTION");
					Category cat1 = new Category(categoryId,categoryName,categoryDescription);
					
					Date postingDate = sdf.parse(rs.getString("POSTING_DATE"));
					int userId = rs.getInt("USER_ID");
					double price = rs.getDouble("PRICE");
					boolean saleSubjectType = rs.getBoolean("SALE_SUBJECT_TYPE");
					boolean saleSubjectCondition = rs.getBoolean("SALE_SUBJECT_CONDITION");
					
					Ad a1 = new Ad(id,title,detail,categoryId,postingDate,userId,price,saleSubjectType,saleSubjectCondition,images,cat1);
					activeAds.add(a1);
				}
			} catch (Exception e) {
				System.out.println("Result set problem "+e+(new Date()));
				return null;
			} finally {
				DataBase.closeConnection(conn);
			}
			
			
		} else {
			System.out.println("Connection problems"+(new Date()));
			return null;
		}
		
		return activeAds;
	}
	
	public static List<Ad> expiredAds() {
		List<Ad> expiredAds = new LinkedList<Ad>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			System.out.println("Succesfull connection for active ads"+(new Date()));
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				stmt = conn.createStatement();
				String query = "SELECT * FROM AD WHERE POSTING_DATE < (NOW() - INTERVAL 30 DAY) ORDER BY POSTING_DATE DESC";
				rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					int id = rs.getInt("ID");
					
					Statement stmt2 = null;
					ResultSet rs2 = null;
					stmt2 = conn.createStatement();
					String query2 = "SELECT * FROM IMAGE WHERE AD_ID ="+id;
					rs2 = stmt2.executeQuery(query2);
					
					List<String> images = new LinkedList<String>();
				
					while(rs2.next()) {
						String path = rs2.getString("PATH");
						images.add(path);
					}
					
					String title = rs.getString("TITLE");
					String detail = rs.getString("DETAIL");
					int categoryId = rs.getInt("CATEGORY_ID");
					
					Statement stmt3 = null;
					ResultSet rs3 = null;
					stmt3 = conn.createStatement();
					String query3 = "SELECT * FROM CATEGORY WHERE ID ="+categoryId;
					rs3 = stmt3.executeQuery(query3);
					rs3.next();
					String categoryName = rs3.getString("CATEGORY_NAME");
					String categoryDescription = rs3.getString("DESCRIPTION");
					Category cat1 = new Category(categoryId,categoryName,categoryDescription);
					
					Date postingDate = sdf.parse(rs.getString("POSTING_DATE"));
					int userId = rs.getInt("USER_ID");
					double price = rs.getDouble("PRICE");
					boolean saleSubjectType = rs.getBoolean("SALE_SUBJECT_TYPE");
					boolean saleSubjectCondition = rs.getBoolean("SALE_SUBJECT_CONDITION");
					
					Ad a1 = new Ad(id,title,detail,categoryId,postingDate,userId,price,saleSubjectType,saleSubjectCondition,images,cat1);
					expiredAds.add(a1);
				}
			} catch (Exception e) {
				System.out.println("Result set problem "+e+(new Date()));
				return null;
			} finally {
				DataBase.closeConnection(conn);
			}
			
			
		} else {
			System.out.println("Connection problems"+(new Date()));
			return null;
		}
		
		return expiredAds;
	}
	
	public static List<Ad> searchAds(String parameter) {
		List<Ad> ads = new LinkedList<Ad>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			System.out.println("Succesful connection "+(new Date()));
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				stmt = conn.createStatement();
				String parameter1 = "%" + parameter +"%";
				String query = "SELECT * FROM AD WHERE TITLE LIKE "+"'"+parameter1+"'";
				rs = stmt.executeQuery(query);
				while(rs.next()) {
					int id = rs.getInt("ID");
					
					Statement stmt2 = null;
					ResultSet rs2 = null;
					stmt2 = conn.createStatement();
					String query2 = "SELECT * FROM IMAGE WHERE AD_ID ="+id;
					rs2 = stmt2.executeQuery(query2);
					
					List<String> images = new LinkedList<String>();
				
					while(rs2.next()) {
						String path = rs2.getString("PATH");
						images.add(path);
					}
					
					String title = rs.getString("TITLE");
					String detail = rs.getString("DETAIL");
					int categoryId = rs.getInt("CATEGORY_ID");
					
					Statement stmt3 = null;
					ResultSet rs3 = null;
					stmt3 = conn.createStatement();
					String query3 = "SELECT * FROM CATEGORY WHERE ID ="+categoryId;
					rs3 = stmt3.executeQuery(query3);
					rs3.next();
					String categoryName = rs3.getString("CATEGORY_NAME");
					String categoryDescription = rs3.getString("DESCRIPTION");
					Category cat1 = new Category(categoryId,categoryName,categoryDescription);
					
					Date postingDate = sdf.parse(rs.getString("POSTING_DATE"));
					int userId = rs.getInt("USER_ID");
					double price = rs.getDouble("PRICE");
					boolean saleSubjectType = rs.getBoolean("SALE_SUBJECT_TYPE");
					boolean saleSubjectCondition = rs.getBoolean("SALE_SUBJECT_CONDITION");
					
					Ad a1 = new Ad(id,title,detail,categoryId,postingDate,userId,price,saleSubjectType,saleSubjectCondition,images,cat1);
					ads.add(a1);
				}
			} catch (Exception e) {
				System.out.println("Result set problems "+e+" "+(new Date()));
				return null;
			} finally {
				DataBase.closeConnection(conn);
			}
		} else {
			System.out.println("Conncetion problems "+(new Date()));
			return null;
		}
		return ads;
	}
	
	public static Ad adDetails(int adId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			System.out.println("Successful connection "+(new Date()));
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.createStatement();
				String query = "SELECT * FROM AD WHERE ID = "+adId;
				rs = stmt.executeQuery(query);
				rs.next();
				
				
					Statement stmt2 = null;
					ResultSet rs2 = null;
					stmt2 = conn.createStatement();
					String query2 = "SELECT * FROM IMAGE WHERE AD_ID ="+adId;
					rs2 = stmt2.executeQuery(query2);
					
					List<String> images = new LinkedList<String>();
				
					while(rs2.next()) {
						String path = rs2.getString("PATH");
						images.add(path);
					}
				
					String title = rs.getString("TITLE");
					String detail = rs.getString("DETAIL");
					int categoryId = rs.getInt("CATEGORY_ID");
					
					Statement stmt3 = null;
					ResultSet rs3 = null;
					stmt3 = conn.createStatement();
					String query3 = "SELECT * FROM CATEGORY WHERE ID ="+categoryId;
					rs3 = stmt3.executeQuery(query3);
					rs3.next();
					String categoryName = rs3.getString("CATEGORY_NAME");
					String categoryDescription = rs3.getString("DESCRIPTION");
					Category cat1 = new Category(categoryId,categoryName,categoryDescription);
					
					Date postingDate = sdf.parse(rs.getString("POSTING_DATE"));
					int userId = rs.getInt("USER_ID");
					double price = rs.getDouble("PRICE");
					boolean saleSubjectType = rs.getBoolean("SALE_SUBJECT_TYPE");
					boolean saleSubjectCondition = rs.getBoolean("SALE_SUBJECT_CONDITION");
					
					Ad a1 = new Ad(adId,title,detail,categoryId,postingDate,userId,price,saleSubjectType,saleSubjectCondition,images,cat1);
					return a1;
					
			} catch (Exception e) {
				System.out.println("ResultSet problem "+e+" "+(new Date()));
				return null;
			} finally {
				DataBase.closeConnection(conn);
			}
		} else {
			System.out.println("Connection problems "+(new Date()));
			return null;
		}
	}
	
	public static List<Ad> categoryAds(int categoryId) {
		List<Ad> adsFromCategory = new LinkedList<Ad>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			System.out.println("Successful connection "+(new Date()));
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				stmt = conn.createStatement();
				String query = "SELECT * FROM AD WHERE CATEGORY_ID ="+categoryId;
				rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					
					int id = rs.getInt("ID");
					
					Statement stmt2 = null;
					ResultSet rs2 = null;
					stmt2 = conn.createStatement();
					String query2 = "SELECT * FROM IMAGE WHERE AD_ID ="+id;
					rs2 = stmt2.executeQuery(query2);
					
					List<String> images = new LinkedList<String>();
				
					while(rs2.next()) {
						String path = rs2.getString("PATH");
						images.add(path);
					}
					
					String title = rs.getString("TITLE");
					String detail = rs.getString("DETAIL");
					
					Statement stmt3 = null;
					ResultSet rs3 = null;
					stmt3 = conn.createStatement();
					String query3 = "SELECT * FROM CATEGORY WHERE ID ="+categoryId;
					rs3 = stmt3.executeQuery(query3);
					rs3.next();
					String categoryName = rs3.getString("CATEGORY_NAME");
					String categoryDescription = rs3.getString("DESCRIPTION");
					Category cat1 = new Category(categoryId,categoryName,categoryDescription);
					
					Date postingDate = sdf.parse(rs.getString("POSTING_DATE"));
					int userId = rs.getInt("USER_ID");
					double price = rs.getDouble("PRICE");
					boolean saleSubjectType = rs.getBoolean("SALE_SUBJECT_TYPE");
					boolean saleSubjectCondition = rs.getBoolean("SALE_SUBJECT_CONDITION");
					
					Ad a1 = new Ad(id,title,detail,categoryId,postingDate,userId,price,saleSubjectType,saleSubjectCondition,images,cat1);
					adsFromCategory.add(a1);
				}
			} catch (Exception e) {
				System.out.println("ResultSet problem "+e+" "+(new Date()));
				return null;
			} finally {
				DataBase.closeConnection(conn);
			}
			
		} else {
			System.out.println("Conncetion problem "+(new Date()));
			return null;
		}
		
		return adsFromCategory;
	}
	
	public static List<Ad> userAds(int userId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Ad> userAds = new LinkedList<Ad>();
		
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.createStatement();
				String query = "SELECT * FROM AD WHERE USER_ID = "+userId;
				rs = stmt.executeQuery(query);
				while(rs.next()) {
					
					int id = rs.getInt("ID");
					
					Statement stmt2 = null;
					ResultSet rs2 = null;
					stmt2 = conn.createStatement();
					String query2 = "SELECT * FROM IMAGE WHERE AD_ID ="+id;
					rs2 = stmt2.executeQuery(query2);
					
					List<String> images = new LinkedList<String>();
				
					while(rs2.next()) {
						String path = rs2.getString("PATH");
						images.add(path);
					}
					
					String title = rs.getString("TITLE");
					String detail = rs.getString("DETAIL");
					int categoryId = rs.getInt("CATEGORY_ID");
					
					Statement stmt3 = null;
					ResultSet rs3 = null;
					stmt3 = conn.createStatement();
					String query3 = "SELECT * FROM CATEGORY WHERE ID ="+categoryId;
					rs3 = stmt3.executeQuery(query3);
					rs3.next();
					String categoryName = rs3.getString("CATEGORY_NAME");
					String categoryDescription = rs3.getString("DESCRIPTION");
					Category cat1 = new Category(categoryId,categoryName,categoryDescription);
					
					Date postingDate = sdf.parse(rs.getString("POSTING_DATE"));
					double price = rs.getDouble("PRICE");
					boolean saleSubjectType = rs.getBoolean("SALE_SUBJECT_TYPE");
					boolean saleSubjectCondition = rs.getBoolean("SALE_SUBJECT_CONDITION");
					
					Ad a1 = new Ad(id,title,detail,categoryId,postingDate,userId,price,saleSubjectType,saleSubjectCondition,images,cat1);
					userAds.add(a1);
				}
			} catch (Exception e) {
				System.out.println("ResultSet problem while userAds method "+(new Date()));
			} finally {
				DataBase.closeConnection(conn);
			}
		} else {
			System.out.println("Connection problems while userAds method "+(new Date()));
			return null;
		}
		return userAds;
	}
	
	public static boolean createNewAd(String title, String detail, int categoryId,int userId,double price,String saleSubjectType, String saleSubjectCondition) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			Statement stmt = null;
			try {
				stmt = conn.createStatement();
				
				
				if (saleSubjectType.equals("product")) {
					saleSubjectType = "true";
				} else {
					saleSubjectType = "false";
				}
				
				if (saleSubjectCondition.equals("new")) {
					saleSubjectCondition = "true";
				} else {
					saleSubjectCondition = "false";
				}
				
				String postingDate = "'"+sdf.format(new Date())+"'";
				
				String query = "INSERT INTO AD (TITLE,DETAIL,CATEGORY_ID,POSTING_DATE,USER_ID,PRICE,SALE_SUBJECT_TYPE,SALE_SUBJECT_CONDITION) VALUES ("+"'"+title+"'"+","+"'"+detail+"'"+","+categoryId+","+postingDate+","+userId+","+price+","+saleSubjectType+","+saleSubjectCondition+")";
				stmt.executeUpdate(query);
			} catch (Exception e) {
				System.out.println("Execute problems "+e+" "+(new Date()));
				return false;
			} finally {
				DataBase.closeConnection(conn);
			}
		} else {
			System.out.println("Connection problems while creating new ad "+(new Date()));
			return false;
		}
		return true;
	}
	
	public static Ad findAdById(int adId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			System.out.println("Connection succesful (findAdById) "+(new Date()));
			
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				stmt = conn.createStatement();
				String query = "SELECT * FROM AD WHERE ID = "+adId;
				rs = stmt.executeQuery(query);
				rs.next();
				
				Statement stmt2 = null;
				ResultSet rs2 = null;
				stmt2 = conn.createStatement();
				String query2 = "SELECT * FROM IMAGE WHERE AD_ID ="+adId;
				rs2 = stmt2.executeQuery(query2);
				
				List<String> images = new LinkedList<String>();
			
				while(rs2.next()) {
					String path = rs2.getString("PATH");
					images.add(path);
				}
				
				String title = rs.getString("TITLE");
				String detail = rs.getString("DETAIL");
				int categoryId = rs.getInt("CATEGORY_ID");
				
				Statement stmt3 = null;
				ResultSet rs3 = null;
				stmt3 = conn.createStatement();
				String query3 = "SELECT * FROM CATEGORY WHERE ID ="+categoryId;
				rs3 = stmt3.executeQuery(query3);
				rs3.next();
				String categoryName = rs3.getString("CATEGORY_NAME");
				String categoryDescription = rs3.getString("DESCRIPTION");
				Category cat1 = new Category(categoryId,categoryName,categoryDescription);
				
				Date postingDate = sdf.parse(rs.getString("POSTING_DATE"));
				int userId = rs.getInt("USER_ID");
				double price = rs.getDouble("PRICE");
				boolean saleSubjectType = rs.getBoolean("SALE_SUBJECT_TYPE");
				boolean saleSubjectCondition = rs.getBoolean("SALE_SUBJECT_CONDITION");
				
				Ad a1 = new Ad(adId,title,detail,categoryId,postingDate,userId,price,saleSubjectType,saleSubjectCondition,images,cat1);
				return a1;
				
			} catch (Exception e) {
				System.out.println("ResultSet problems (findAdById) "+(new Date()));
				return null;
			} finally {
				DataBase.closeConnection(conn);
			}
			
		} else {
			System.out.println("Connection problems (findAdById) "+(new Date()));
			return null;
		}
	}
	
	public static boolean editAd(int adId, String title, String detail, int categoryId, String postingDate, int userId, double price, String saleSubjectType, String saleSubjectCondition) {
	
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			System.out.println("Connection successfull (editAd) "+(new Date()));
			Statement stmt = null;
			
			try {

				stmt = conn.createStatement();
				String query = "UPDATE AD SET TITLE = "+"'"+title+"'"+", DETAIL ="+"'"+detail+"'"+", CATEGORY_ID ="+categoryId+", POSTING_DATE ="+"'"+postingDate+"'"+", USER_ID ="+userId+", PRICE ="+price+", SALE_SUBJECT_TYPE = "+saleSubjectType+", SALE_SUBJECT_CONDITION ="+saleSubjectCondition+" WHERE ID ="+adId;
				stmt.executeUpdate(query);
				return true;
			} catch (Exception e) {
				System.out.println("Problem with execute query (editAd) "+(new Date()));
				return false;
			} finally {
				DataBase.closeConnection(conn);
			}
		} else {
			System.out.println("Connection problems (editAd) "+(new Date()));
			return false;
		}
	
	}
	
	public static boolean deleteAd(int adId) {
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			System.out.println("Successful connection "+(new Date()));
			Statement stmt = null;
			try {
				stmt = conn.createStatement();
				String query = "DELETE FROM AD WHERE ID = "+adId;
				stmt.executeUpdate(query);
				
			} catch (Exception e) {
				System.out.println("Execute query problem (deleteAd method) "+new Date());
			}
		} else {
			System.out.println("Connection problem (deleteAd method) "+(new Date()));
			return false;
		}
		return true;
	}
	
}
