package com.webapp.login.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.login.model.FoodItems;
import com.webapp.login.service.FoodItemService;

@RestController
@RequestMapping("/")
@CrossOrigin

public class FoodItemController {
	@Autowired
	private FoodItemService service;
 @PostMapping("/cart")
 public ResponseEntity<Map<String,String>> login(@RequestBody FoodItems Item){
     service.additem(Item);
     Map<String, String> response = new HashMap<>();
     response.put("succesfully added to cart", "created new user");
     return new ResponseEntity<>(response,HttpStatus.OK);
 }
 @GetMapping("/cartproducts{username}")
 public List<FoodItems> getitems(@PathVariable String username)
 {
	 
	 return service.getitems(username);
 }
 @DeleteMapping("/cartproducts/{username}/{name}")
 public ResponseEntity<Map<String,String>> deletefooditem(@PathVariable String username, @PathVariable String name)
 {
	 System.out.println("inside deletefooditem"+"username="+username+" "+"name="+name);
	 FoodItems fooditem=service.getfooditem(username, name);
	 System.out.println(fooditem);
	 Map<String,String> response=new HashMap<>();
	 if(service.deletefooditem(username,name))
	 {
	 response.put("successfully", "deleted");
	 return new ResponseEntity<>(response,HttpStatus.OK);
	 }
	 else {
		 response.put("something is wrong", "not deleted");
		 return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	 }
 }
}
