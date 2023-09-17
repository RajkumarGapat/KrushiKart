package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.custom_Exceptions.ProductNotExistsExceptions;
import com.app.dto.ProductDto;
import com.app.pojos.Categorys;

import com.app.pojos.Products;
import com.app.repositiory.CategoryRepository;
import com.app.repositiory.ProductRepository;
import com.app.repositiory.CategoryRepository;


@Service
@Transactional
public class ProdServiceInterface implements ProductInterface {
	
	@Autowired
	private ProductRepository Repo;
	@Autowired
	private CategoryRepository CatRepo;

	@Override
	public ResponseEntity<Categorys> addNewSeeds(Products prodObj, String Catname) {
		Categorys categorys = CatRepo.findByCategoryNameIgnoreCase(Catname).get();
		if(categorys !=null) {
			categorys.addProduct(prodObj);
			prodObj.addNewCategory(categorys);
			return new ResponseEntity<Categorys>(categorys,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Categorys>(categorys,HttpStatus.NO_CONTENT);
		}
	
	}

	@Override
	public void removeSeedDetails(Long prodId) {
		Repo.deleteById(prodId);
		
	}

	@Override
	public void updateSeedProdDetails(Products prodObj) {
		if(Repo.existsById(prodObj.getId())) {
			Repo.save(prodObj);
		}
		
	}

	@Override
	public List<Products> getAllSeedsData() {
		
		return Repo.findAll();
	}

	@Override
	public List<Products> getAllProductByProducts(String catName) {
		  Categorys categorys = CatRepo.findByCategoryNameIgnoreCase(catName).get();
		 return Repo.findByProdCategory(categorys);
	}

	@Override
	public Products getProductById(Long prodID) {
		Products product=Repo.findById(prodID).get();
		return product;
	}

	public Products findById(Long productId) throws ProductNotExistsExceptions {
		Optional<Products> optionalProduct=Repo.findById(productId);
		
		if(optionalProduct.isEmpty()) {
			throw new ProductNotExistsExceptions("product id is invalid"+productId);
		}
		
		return optionalProduct.get();
		
	}


}
