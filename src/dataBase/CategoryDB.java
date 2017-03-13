package dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Category;

public class CategoryDB {
	public static List<Category> allCategories() {
		List<Category> allCat = new ArrayList<Category>();
		
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.createStatement();
				String query = "SELECT * FROM CATEGORY";
				rs = stmt.executeQuery(query);
				while(rs.next()) {
					int id = rs.getInt("ID");
					String categoryName = rs.getString("CATEGORY_NAME");
					String description = rs.getString("DESCRIPTION");
					Category cat = new Category(id,categoryName,description);
					allCat.add(cat);
				}
			} catch (Exception e) {
				System.out.println("ResultSet problem "+e+" "+(new Date()));
				return null;
			} finally {
				DataBase.closeConnection(conn);
			}
		} else {
			System.out.println("Connection problems with database "+(new Date()));
			return null;
		}
		return allCat;
	}
}
