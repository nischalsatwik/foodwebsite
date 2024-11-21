package com.webapp.login.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.login.model.Creds;
import com.webapp.login.model.Logindetails;
import com.webapp.login.service.Createservice;
import com.webapp.login.service.Loginservice;

@RestController
@RequestMapping("/")
@CrossOrigin
public class Logincontroller {

    @Autowired
    private Loginservice service;
    @Autowired
    private Createservice service2;
    @GetMapping("/")
    public String greet()
    {
    	return "Hello";
    }
   
    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody Creds cred){
        boolean isValid = service.isValidUser(cred.getUsername(), cred.getPassword());
        System.out.println(isValid);
        Map<String, String> response = new HashMap<>();
        if (isValid) {
        	String username=cred.getUsername();
        	String password=cred.getPassword();
        	Logindetails login=service2.getdetails(username,password);
        	System.out.println(login);
        	String firstname=login.getFirstname();
        	String lastname=login.getLastname();
        	response.put("firstname",firstname);
        	response.put("lastname", lastname);
        	return new ResponseEntity<>(response,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/login")
	public List<Creds> getuser()
	{
		return service.getall();
	}
    
}