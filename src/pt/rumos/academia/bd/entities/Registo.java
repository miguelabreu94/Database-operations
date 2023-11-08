package pt.rumos.academia.bd.entities;

import java.util.Date;

public class Registo {

	private String email;
	private Date data;
	private String username;
	private String password;
	
	public Registo() {}
	
	public Registo(String email, Date data, String username, String password) {
		this.email = email;
		this.data = data;
		this.username = username;
		this.password = password;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s", email, data, username, password);
	}
	
}
