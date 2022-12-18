package com.Medicare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Medicare.Entity.Category;
import com.Medicare.service.CatergoryService;

@Controller
public class SaveCategory {
	@Autowired
	CatergoryService catserv;
	@PostMapping("/SaveCategory")
	public String savecat(@ModelAttribute("cat") Category cat,Model m) {
		
		catserv.savecat(cat);
		List<Category> listcat = catserv.getallcat();
		m.addAttribute("listcat", listcat);
		return "redirect:/login";
	}
	

}
