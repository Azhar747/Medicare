package com.Medicare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Medicare.Entity.Users;
import com.Medicare.Repository.UserRepo;
@Service
public class Userserivce {
   
	@Autowired
	UserRepo userrepo;
	
	public void Usersave(Users user) {
		
		userrepo.save(user);
		
	}
	public List<Users> getallusers() {
		List<Users> listuser = new ArrayList<>();
		userrepo.findAll().forEach(m -> listuser.add(m));
		return listuser;
	
		
	}
	
	public List<Users> findbykeyword(String keyword){
		
		return userrepo.findbykeyword(keyword);
		
	}
	public void removeUserById(Long id) { 
		userrepo.deleteById(id);;
	}
	
	
	public void updateById(Long id,String firstname,String lastname,String email ) { 
		userrepo.updateuserbyId(id,firstname,lastname,email);;
	}
}
