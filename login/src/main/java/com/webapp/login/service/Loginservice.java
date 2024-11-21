package com.webapp.login.service;
import com.webapp.login.model.Creds;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.login.repo.Loginrepo;
@Service
public class Loginservice {
  @Autowired
  private Loginrepo repo;
   public boolean isValidUser(String username,String password)
   {	
	   Creds cred=repo.findByUsernameAndPassword(username, password);
	   if(cred.getUsername().trim().equals(username.trim())&&cred.getPassword().trim().equals(password.trim())) {
		   return true;
	   }
	   return false;
   }
   public List<Creds> getall()
   {
	  return repo.findAll();
   }
}