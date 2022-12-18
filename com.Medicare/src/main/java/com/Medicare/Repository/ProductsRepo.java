package com.Medicare.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.Medicare.Entity.Category;
import com.Medicare.Entity.Product;
import com.Medicare.Entity.Users;

public interface ProductsRepo extends CrudRepository<Product, Long>{
	
	@Query("from Product where category_id=:id")
	public List<Product> searchprd(int id);
   
	
    @Query("from Product where ID=:id")	
	public List<Product> searchprdbyid(Long id);
    
    @Query(value="select * from Products p where p.id like %:keyword% or p.name like %:keyword% or p.Description like %:keyword%",nativeQuery = true)
	public List<Product> findbykeyword(@Param("keyword") String keyword);
    
    @Transactional
    @Modifying
    @Query("update Product set Description=:Description,price=:price,weight=:weight,flag=:flag where ID=:id")
    public void updateprdbyId(Long id, String Description,double price,double weight,String flag);
    
    @Query("from Product where flag=:flag")	
	public List<Product> searchprdbyflag(String flag);
	
}
