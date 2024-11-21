package com.webapp.login.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.login.model.Creds;
@Repository

public interface Loginrepo extends JpaRepository<Creds, Integer> {
	 Creds findByUsernameAndPassword(String username,String password); 
}
