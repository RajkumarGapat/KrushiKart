package com.app.repositiory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Role;
import com.app.pojos.User;

public interface UserRepositiory extends JpaRepository<User,Long>{
	

	List<User> findByUserRole(Role roleCustomer);

	Optional<User> findByEmail(String email);

	Optional<User> findById(int userId);

	void deleteById(Integer id);

}
