package com.isrc.repositories;

import com.isrc.models.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserVO, Integer> {
	
	UserVO findByUsername(String findByUsername);
	
	@Query
	(nativeQuery = true, value = "SELECT Count(id) FROM Users WHERE username = ?1 AND password = ?2") 
     public int checklogin(String UserName, String Password);

}
