package com.Medicare.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Medicare.Entity.Customerinfo;

@Repository
public interface CustomerinfoRepo extends CrudRepository<Customerinfo, Long> {
	

}
