package es.eoi;

import java.util.Date;

public class FingerPrint {
	private int id;
	private Date scandate;
	private String finger;
	private String image;
	private User user;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getScandate() {
		return scandate;
	}
	public void setScandate(Date scandate) {
		this.scandate = scandate;
	}
	public String getFinger() {
		return finger;
	}
	public void setFinger(String finger) {
		this.finger = finger;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "FingerPrint [id=" + id + ", scandate=" + scandate + ", finger=" + finger + ", image=" + image
				+ ", user=" + user + "]";
	}
	
	
	
	
}
