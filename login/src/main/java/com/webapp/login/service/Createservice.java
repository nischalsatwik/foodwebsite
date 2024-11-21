package com.webapp.login.service;
import com.webapp.login.model.Creds;
import com.webapp.login.model.Logindetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.login.repo.Createrepo;
import com.webapp.login.repo.Loginrepo;
@Service
public class Createservice {
  @Autowired
  private Createrepo repo;
  @Autowired
  private Loginrepo loginrepo;
   public void addnew(Logindetails newuser)
   {	
	  Creds cred=new Creds();
	  cred.setUsername(newuser.getUsername());
	  cred.setPassword(newuser.getPassword());
	  loginrepo.save(cred);
	  repo.save(newuser);
	  
   }
   public List<Logindetails> getall()
   {
	  return repo.findAll();
   }
   public Logindetails getdetails(String username, String password)
   {
	   return repo.findByUsernameAndPassword(username,password);
   }
   public Logindetails getuserdetails(String username)
   {
	   return repo.findByUsername(username);
   }
   public Logindetails updateprof(String username,Logindetails userdetails)
   {
	  Logindetails user= repo.findByUsername(username);
	  user.setFirstname(userdetails.getFirstname());
	  user.setLastname(userdetails.getLastname());
	  user.setNumber(userdetails.getNumber());
	  user.setEmail(userdetails.getEmail());
	  return repo.save(user);
	   
   }
   public int getamount(String username)
   {
	   Logindetails user=repo.findByUsername(username);
	   int amount=user.getMoney();
	   return amount;
   }
   public void updateamount(String username,int addedamount)
   {
	   Logindetails user=repo.findByUsername(username);
	   user.setMoney(user.getMoney()+addedamount);
	   repo.save(user);
   }
   public void updatewalletamount(String username,int addedamount)
   {
	   Logindetails user=repo.findByUsername(username);
	   user.setMoney(user.getMoney()-addedamount);
	   repo.save(user);
   }
   public boolean uploadimage(byte[] imageData, String username) {
       Logindetails img = repo.findByUsername(username);
       
       if (img != null) {
img.setImageData(imageData);
           try {
               repo.save(img);
               return true;
           } 
catch (Exception e){
        System.err.println("Error while saving image: " + e.getMessage());
               return false;
           }
     
       
   }
       return false;
	}
   public Logindetails getImage(String username) {
       return repo.findByUsername(username);
   }
   public boolean deleteimage(String username)
   {
   	Logindetails img=repo.findByUsername(username);
   	if(img!=null)
   	{
   		System.out.println("before"+img);
   		img.setImageData(null);
   		repo.save(img);
   		System.out.println("after"+img);
   		return true;
   	}
   	return false;
   }
}
