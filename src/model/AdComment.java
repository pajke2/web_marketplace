package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdComment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private int userId;
	private String commentText;
	private Date commentDate;
	private int adId;
	
	public AdComment() {
		super();
	}

	public AdComment(int id, int userId, String commentText, Date commentDate, int adId) {
		super();
		this.id = id;
		this.userId = userId;
		this.commentText = commentText;
		this.commentDate = commentDate;
		this.adId = adId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}
	
	public String getCommentDateFormated() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		return sdf.format(commentDate);
	}
} 
