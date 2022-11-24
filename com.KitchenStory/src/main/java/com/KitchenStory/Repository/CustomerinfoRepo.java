package com.KitchenStory.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.KitchenStory.Entity.Customerinfo;

@Repository
public interface CustomerinfoRepo extends CrudRepository<Customerinfo, Long> {
	

}
