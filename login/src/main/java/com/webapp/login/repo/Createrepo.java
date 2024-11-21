package com.webapp.login.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.login.model.Logindetails;
@Repository

public interface Createrepo extends JpaRepository<Logindetails, Integer> {
	Logindetails findByUsernameAndPassword(String username,String password); 
	Logindetails findByUsername(String username);
}
