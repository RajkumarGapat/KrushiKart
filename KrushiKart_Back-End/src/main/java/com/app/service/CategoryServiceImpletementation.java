package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.pojos.Categorys;
import com.app.pojos.Products;
import com.app.repositiory.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpletementation implements CategoryInterface {
	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public List<Categorys> getAllCategoryInfo() {

		return categoryRepo.findAll();
	}

	@Override
	public ResponseEntity<Categorys> addNewCategoryInToList(Categorys categoryObj) {

		categoryRepo.save(categoryObj);
		return new ResponseEntity<Categorys>(categoryObj, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Categorys> updateCategoryDetils(Categorys catObj) {

		categoryRepo.save(catObj);
		return new ResponseEntity<Categorys>(catObj, HttpStatus.OK);

	}

	@Override
	public void deleteCategoryById(Long categoryID) {
		categoryRepo.deleteById(categoryID);

	}

//	@Override
//	public List<Products> getAllProductByCategory(String catName) {
//		
//		return categoryRepo.getAllProducts(catName);
//	}

}
