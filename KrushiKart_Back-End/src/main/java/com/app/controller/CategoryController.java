package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Categorys;
import com.app.pojos.Products;
import com.app.service.CategoryInterface;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	private CategoryInterface categoryImpl;
	
	@GetMapping("/view")
	public List<Categorys> getAllCategorysList(){
		return categoryImpl.getAllCategoryInfo();
	}
	
	@PostMapping("/add")
	public void addNewProduct(@RequestBody Categorys categoryObj) {
		categoryImpl.addNewCategoryInToList(categoryObj);
	}
	
	@PutMapping("/update")
	public void updateCategoryInfo(@RequestBody Categorys catObj) {
		categoryImpl.updateCategoryDetils(catObj);
	}
	@DeleteMapping("/{categoryID}")
	public void daleteCategory(@PathVariable Long categoryID ) {
		categoryImpl.deleteCategoryById(categoryID);
	}
//	@GetMapping("/{catName}")
//	public List<Products> getAllProductByCategory(@PathVariable String catName){
//		return categoryImpl.getAllProductByCategory(catName);
//	}
}
