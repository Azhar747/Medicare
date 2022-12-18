package com.Medicare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Medicare.Entity.Admin;
import com.Medicare.Repository.AdminRepo;


@Service
public class Adminservice {
	
	@Autowired
	AdminRepo adminrepo;
	
	public Admin logincheck(String username, String password ) {
		
		Admin admin = adminrepo.getuserbynameandpassword(username, password);
		
		return admin;
		
		
	}
	
	public void updatepass(String username, String newpass) {
		
		adminrepo.udpatepass(username, newpass);
		
		
		
	}
     
}
