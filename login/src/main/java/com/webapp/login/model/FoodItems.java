package com.webapp.login.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id 	;

@Entity
public class FoodItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String name;
	private String username;
   private int price;
   private int quantity;
   
   public FoodItems()
   {
	   
   }
public String getUsername()
{
	return username;
}
public void setUsername(String username)
{
	this.username=username;
}
public int getId() {
	return Id;
}

public void setId(int id) {
	Id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

@Override
public String toString() {
	return "FoodItems [Id=" + Id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
}
   
  

}
