package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Categorys;
import com.app.pojos.Products;

public interface CategoryInterface {

	List<Categorys> getAllCategoryInfo();

	ResponseEntity<Categorys> addNewCategoryInToList(Categorys categoryObj);

	ResponseEntity<Categorys> updateCategoryDetils(Categorys catObj);

	void deleteCategoryById(Long categoryID);

	//List<Products> getAllProductByCategory(String catName);

}
