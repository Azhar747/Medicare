package com.KitchenStory.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.KitchenStory.Entity.Product;
import com.KitchenStory.Entity.Users;

public interface ProductsRepo extends CrudRepository<Product, Long>{
	
	@Query("from Product where category_id=:id")
	public List<Product> searchprd(int id);
   
	
    @Query("from Product where ID=:id")	
	public List<Product> searchprdbyid(Long id);
    
    @Query(value="select * from Products p where p.id like %:keyword% or p.name like %:keyword% or p.Description like %:keyword%",nativeQuery = true)
	public List<Product> findbykeyword(@Param("keyword") String keyword);
	
	
}
