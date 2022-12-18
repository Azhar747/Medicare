package com.Medicare.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Medicare.Entity.Users;

@Repository
public interface UserRepo extends CrudRepository<Users, Long> {
	
	@Query(value="select * from Users u where u.firstname like %:keyword% or u.lastname like %:keyword% or u.email like %:keyword%",nativeQuery = true)
	public List<Users> findbykeyword(@Param("keyword") String keyword);
	
	@Transactional
    @Modifying
	@Query("update Users set firstname=:firstname,lastname=:lastname,email=:email where ID=:id")
    public void updateuserbyId(Long id, String firstname,String lastname,String email);

}
