package com.webapp.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.login.model.FoodItems;
import com.webapp.login.repo.FoodItemrepo;

import jakarta.transaction.Transactional;

@Service
public class FoodItemService {
@Autowired
private FoodItemrepo repo;
public boolean deletefooditem(String username,String name)
{
	System.out.println("inside service"+"username="+username+" "+"name="+name);
	FoodItems masteritem=repo.findByUsernameAndName(username,name);
	if(masteritem!=null)
	{
	repo.delete(masteritem);
	return true;
	}
	return false;
}
@Transactional
public void additem(FoodItems item)
{
	String username=item.getUsername();
	String name=item.getName();
	FoodItems fooditem=repo.findByUsernameAndName(username,name);
	System.out.println(fooditem);
	if(fooditem!=null)
	{
		
		item.setQuantity(item.getQuantity()+fooditem.getQuantity());
		item.setPrice(item.getQuantity()*item.getPrice());
		repo.save(item);
		repo.delete(fooditem);
	}
	repo.save(item);
}
public List<FoodItems> getitems(String username) {
	
return repo.findAllByUsername(username);

}
public FoodItems getfooditem(String username,String name)
{
	return repo.findByUsernameAndName(username, name);
}

}
