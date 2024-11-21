package com.webapp.login.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id 	;
import jakarta.persistence.Lob;

@Entity
public class Logindetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String username;
   private String email;
   private String number;
   private String firstname;
   private String lastname;
   private String password;
   private int money=0;
   @Lob
	@Column(name = "imageData", columnDefinition = "LONGBLOB")
	 private byte[] imageData;
   public Logindetails()
   {
	   
   }
   
   public String getUsername() {
	return username;
}
   public int getMoney()
   {
	   return money;
   }
   public void setMoney(int money)
   {
	   this.money=money;
   }
public int getId()
{
	return Id;
}
public void setId(int Id)
{
	this.Id=Id;
}
public void setUsername(String username) {
	this.username = username;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public byte[] getImageData() {
	return imageData;
}

public void setImageData(byte[] imageData) {
	this.imageData = imageData;
}

@Override
public String toString() {
	return "Logindetails [username=" + username + ", email=" + email + ", number=" + number + ", Firstname=" + firstname
			+ ", Lastname=" + lastname + ", password=" + password + ", imageData= "+imageData+ "]";
}



}
