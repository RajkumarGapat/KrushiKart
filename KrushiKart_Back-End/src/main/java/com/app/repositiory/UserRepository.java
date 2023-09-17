package com.app.repositiory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	
//	@Query("select distinct u from User u join fetch u.roles where u.userName=:nm")
//	Optional<User> findByUserName(@Param("nm") String userName);
//	boolean existsByUserName(String userName);
//	boolean existsByEmail(String email);
//	@Query("select  u from User u where u.userName=:nm")
//	Optional<User> fetchUserDetails(@Param("nm") String userName);
	
	Optional<User> findByEmail(String userName);

}
