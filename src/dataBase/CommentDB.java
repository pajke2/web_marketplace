package dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import model.AdComment;

public class CommentDB {

	public static List<AdComment> adComments(int adId) {
		List<AdComment> comments = new LinkedList<AdComment>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Connection conn = DataBase.openConnection();
		
		if (conn != null) {
			System.out.println("Successful connection with database (adComment method) "+(new Date()));
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.createStatement();
				String query = "SELECT * FROM AD_COMMENT WHERE AD_ID = "+adId;
				rs = stmt.executeQuery(query);
				while(rs.next()) {
					int id = rs.getInt("ID");
					int userId = rs.getInt("USER_ID");
					String commentText = rs.getString("COMMENT_TEXT");
					Date commentDate = sdf.parse(rs.getString("COMMENT_DATE"));
					
					AdComment adCom = new AdComment(id,userId,commentText,commentDate,adId);
					comments.add(adCom);
				}
			} catch (Exception e) {
				System.out.println("Execute query problem (adComments method) "+(new Date()));
				return null;
			} finally {
				DataBase.closeConnection(conn);
			}
		} else {
			System.out.println("Database connection problems (AdComments method) "+(new Date()));
			return null;
		}
		return comments;
	}
	
}
