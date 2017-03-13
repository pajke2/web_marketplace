package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Ad implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String detail;
	private int categoryId;
	private Date postingDate;
	private int userId;
	private double price;
	private boolean saleSubjectType;
	private boolean saleSubjectCondition;
	
	private List<String> images;
	private Category category;
	
	
	public Ad() {
		super();
	}


	public Ad(int id, String title, String detail, int categoryId, Date postingDate, int userId, double price,
			boolean saleSubjectType, boolean saleSubjectCondition, List<String> images, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.detail = detail;
		this.categoryId = categoryId;
		this.postingDate = postingDate;
		this.userId = userId;
		this.price = price;
		this.saleSubjectType = saleSubjectType;
		this.saleSubjectCondition = saleSubjectCondition;
		this.images = images;
		this.category = category;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public Date getPostingDate() {
		return postingDate;
	}


	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public boolean isSaleSubjectType() {
		return saleSubjectType;
	}


	public void setSaleSubjectType(boolean saleSubjectType) {
		this.saleSubjectType = saleSubjectType;
	}


	public boolean isSaleSubjectCondition() {
		return saleSubjectCondition;
	}


	public void setSaleSubjectCondition(boolean saleSubjectCondition) {
		this.saleSubjectCondition = saleSubjectCondition;
	}


	public List<String> getImages() {
		return images;
	}


	public void setImages(List<String> images) {
		this.images = images;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPostingDateFormated() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		return sdf.format(postingDate);
	}
	
	public String getPostingDateFormated2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(postingDate);
	}
	
}
