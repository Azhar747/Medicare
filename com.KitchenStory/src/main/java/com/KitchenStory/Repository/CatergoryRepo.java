package com.KitchenStory.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.KitchenStory.Entity.Category;

@Repository
public interface CatergoryRepo extends CrudRepository<Category, Integer> {
	
	@Query("select id from Category where name=:listcat")
    public Category findnamebyId(Category listcat);
	
	@Transactional
    @Modifying
	@Query("update Category set name=:name where ID=:id")
    public void updatebyId(String name,int id);
	

}
