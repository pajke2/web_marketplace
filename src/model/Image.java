package model;

import java.io.Serializable;

public class Image implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String path;
	private int adId;
	
	public Image() {
		super();
	}
	
	public Image(int id, String path, int adId) {
		super();
		this.id = id;
		this.path = path;
		this.adId = adId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}
	
}
