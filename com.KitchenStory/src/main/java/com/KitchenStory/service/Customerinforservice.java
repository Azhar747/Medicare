package com.KitchenStory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KitchenStory.Entity.Customerinfo;
import com.KitchenStory.Entity.Product;
import com.KitchenStory.Repository.CustomerinfoRepo;
@Service
public class Customerinforservice {
	
	@Autowired
	CustomerinfoRepo custinfoser;
	public void  savecustinfo(Customerinfo cust) {
		 
		 custinfoser.save(cust);
		
	}
	
	public List<Customerinfo > getallcustomer(){
	
		List<Customerinfo> listcust = new ArrayList<>();
		custinfoser.findAll().forEach(m -> listcust.add(m));
		return listcust;
		
	}
}
