package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.dto.ProductDto;
import com.app.pojos.Categorys;

import com.app.pojos.Products;

public interface ProductInterface {
	
	ResponseEntity<Categorys> addNewSeeds(Products seedObj,String catName);

	

	void removeSeedDetails(Long seedId);

	void updateSeedProdDetails(Products seedObj);

	List<Products> getAllSeedsData();



	List<Products> getAllProductByProducts(String catName);



	Products getProductById(Long prodID);

}
