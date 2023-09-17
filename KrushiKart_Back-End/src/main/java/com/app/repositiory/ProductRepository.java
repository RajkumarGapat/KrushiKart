package com.app.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Categorys;
import com.app.pojos.Products;
@Repository
public interface ProductRepository extends JpaRepository<Products, Long>{

	List<Products> findByProdCategory(Categorys categorys);

}
