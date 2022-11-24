package com.KitchenStory.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.KitchenStory.Entity.Product;

public interface ProductsRepo extends CrudRepository<Product, Long>{
	
	@Query("from Product where category_id=:id")
	public List<Product> searchprd(int id);
   
	
    @Query("from Product where ID=:id")	
	public List<Product> searchprdbyid(Long id);
	
	
}
