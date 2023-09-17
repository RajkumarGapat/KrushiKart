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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProductDto;
import com.app.pojos.Categorys;

import com.app.pojos.Products;
import com.app.service.ProductInterface;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/prod")
public class ProductController {

	@Autowired
	private ProductInterface prodImpl;

	@GetMapping
	public List<Products> getDatailsOfSeeds() {

		return prodImpl.getAllSeedsData();
	}

	@PostMapping("/add/{catName}")
	public void addNewProduct(@RequestBody Products Obj,@PathVariable String catName) {
		prodImpl.addNewSeeds(Obj,catName);
	}

	@DeleteMapping("/{prodId}")
	public void deleteProductById(@PathVariable Long prodId) {
		prodImpl.removeSeedDetails(prodId);
	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping
	public void updateProductInfo(@RequestBody Products prodId) {
		prodImpl.updateSeedProdDetails(prodId);
	}
	@GetMapping("/{catName}")
	public List<Products> getAllProductByCategory(@PathVariable String catName){
		return prodImpl.getAllProductByProducts(catName);
	}
	@GetMapping("/prod/{prodID}")
	public Products getProductById(@PathVariable Long prodID) {
		return prodImpl.getProductById(prodID);
	}
	
}
