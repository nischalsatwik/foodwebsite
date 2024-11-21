package com.webapp.login.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.webapp.login.model.Logindetails;
import com.webapp.login.service.Createservice;

@RestController
@RequestMapping("/")
@CrossOrigin
public class Createcontorller {

    @Autowired
    private Createservice service;
    @GetMapping("/create")
	public List<Logindetails> getuser()
	{
		return service.getall();
	}
    @PostMapping("/create")
    public ResponseEntity<Map<String,String>> login(@RequestBody Logindetails newuser){
    	System.out.println(newuser);
        service.addnew(newuser);
        Map<String, String> response = new HashMap<>();
        response.put("succesfully added details", "created new user");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/profile{username}")
    public ResponseEntity<Map<String,Logindetails>> getprofile(@PathVariable String username){
    	Logindetails user=service.getuserdetails(username);
    	Map<String, Logindetails> response = new HashMap<>();
    	response.put("User",user);
    	return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/profile{username}")
    public ResponseEntity<Map<String,String>> updateprofile(@PathVariable String username, @RequestBody Logindetails userdetails)
    {
    	Logindetails user=service.updateprof(username,userdetails);
    	Map<String, String> response1 = new HashMap<>();
    	if(user!=null)
  	  {
    		response1.clear();
    		response1.put("hi","done");
    		return new ResponseEntity<>(response1,HttpStatus.OK);
  	  }
  	  
  		  response1.put("failed","done");
  		  return new ResponseEntity<>(response1,HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/wallet{username}")
    public ResponseEntity<Map<String,Integer>> getamount(@PathVariable String username)
    {
    	
    	Map<String,Integer> response=new HashMap<>();
    	response.put("money",Integer.valueOf(service.getamount(username)));
    	return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/wallet{username}")
    public ResponseEntity<Map<String,String>> updateamount(@PathVariable String username, @RequestBody Logindetails data)
    {
    	int addedamount=data.getMoney();
    	service.updateamount(username,addedamount);
    	Map<String,String> response=new HashMap<>();
    	response.put("money","updated");
    	return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/updatewallet{username}")
    public ResponseEntity<Map<String,String>> updatewalletamount(@PathVariable String username, @RequestBody Logindetails data)
    {
    	int addedamount=data.getMoney();
    	System.out.println("iniside updatewallet"+"addedamount="+addedamount);
    	service.updatewalletamount(username,addedamount);
    	Map<String,String> response=new HashMap<>();
    	response.put("money","updated");
    	return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/uploadingimage/{username}")
    public ResponseEntity<Map<String, String>> uploadImage(
        @RequestParam("imageFile") MultipartFile imageFile, 
        @PathVariable String username) throws IOException {
        
        Map<String, String> response = new HashMap<>();
        
        if (imageFile == null || imageFile.isEmpty()) {
            response.put("error", "Image file is missing or empty");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        byte[] imageBytes = imageFile.getBytes();
        boolean isValid = service.uploadimage(imageBytes, username);
        
        if (isValid) {
            response.put("status", "Image uploaded successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("error", "Failed to upload image");
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        }
    }
    @GetMapping("/profile-pic/{username}")
    public ResponseEntity<byte[]> getImageProductId(@PathVariable String username) {
        Logindetails img = service.getImage(username);
        
        if (img == null || img.getImageData() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        byte[] imageFile = img.getImageData();
        
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageFile);
    }
    @DeleteMapping("/deleteimage/{username}")
    public ResponseEntity<Map<String,String>> deleteimage(@PathVariable String username)
    {
  	  boolean done=service.deleteimage(username);
  	  Map<String,String> maps=new HashMap<>();
  	  if(done)
  	  {
  		  maps.put("imagge","deleted");
  		  return new ResponseEntity<>(maps, HttpStatus.OK);
  	  }
  	  else {
  		  maps.put("some","problem");
  		  return new ResponseEntity<>(maps, HttpStatus.BAD_GATEWAY);
  	  }
    }
}

