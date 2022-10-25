package es.eoi;

import java.util.Date;
import java.util.List;

public class User {

	private int id;
	private String username;
	private String mail;
	private String password;
	private Date lastAcess;
	
	private FingerPrint huella;
	
	private List<Address> direcciones;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastAcess() {
		return lastAcess;
	}
	public void setLastAcess(Date lastAcess) {
		this.lastAcess = lastAcess;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", mail=" + mail + ", password=" + password
				+ ", lastAcess=" + lastAcess + "]";
	}
	public FingerPrint getHuella() {
		return huella;
	}
	public void setHuella(FingerPrint huella) {
		this.huella = huella;
	}
	public List<Address> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(List<Address> direcciones) {
		this.direcciones = direcciones;
	}

	
}
