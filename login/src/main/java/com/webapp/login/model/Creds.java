package com.webapp.login.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Creds {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	@Column(name="username")
	private String username;
	@Column(name="pass")
	private String password;
	public Creds()
	{
		
	}
	public int getId()
	{
		return Id;
	}
	public void setId(int Id)
	{
		this.Id=Id;
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
		return "Creds [Id=" + Id + ", username=" + username + ", password=" + password + "]";
	}
}
