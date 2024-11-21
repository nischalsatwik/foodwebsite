package com.webapp.login.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.webapp.login.model.FoodItems;

@Repository
public interface FoodItemrepo extends JpaRepository<FoodItems, Integer> {
	List<FoodItems> findAllByUsername(String username);
	FoodItems findByUsernameAndName(String username,String name);
}
