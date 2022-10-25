package es.eoi;

import java.util.List;

public class Address {
	private int id;
	private String name;
	private String address;
	private String number;
	private String apartment;
	private String zipcode;
	private List<User> usuarios;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getApartment() {
		return apartment;
	}
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public List<User> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", address=" + address + ", number=" + number + ", apartment="
				+ apartment + ", zipcode=" + zipcode + ", usuarios=" + usuarios + "]";
	}
	
	

}
