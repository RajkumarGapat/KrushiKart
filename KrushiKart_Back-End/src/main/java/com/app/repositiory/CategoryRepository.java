package com.app.repositiory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Categorys;
import com.app.pojos.Products;

@Repository
public interface CategoryRepository extends JpaRepository<Categorys, Long>{

	Optional<Categorys> findByCategoryNameIgnoreCase(String catname);
	
	


}
