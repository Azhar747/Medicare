package com.KitchenStory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KitchenStory.Entity.Category;
import com.KitchenStory.Repository.CatergoryRepo;

@Service
public class CatergoryService {
	@Autowired
	CatergoryRepo catrepo;
	
	public void savecat(Category cat) {
		
		 catrepo.save(cat);
	}
	
	public List<Category> getallcat() {
		List<Category> listcat = new ArrayList<>();
		catrepo.findAll().forEach(m -> listcat.add(m));
		return listcat;
				
		
	}
	public void removeCategoryById(int id) { 
		catrepo.deleteById(id);
		
	}
	public void updateCategoryById(String name,int id) { 
		catrepo.updatebyId(name,id);
		
	}


}
