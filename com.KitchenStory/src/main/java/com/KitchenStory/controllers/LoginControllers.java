package com.KitchenStory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.KitchenStory.Entity.Admin;
import com.KitchenStory.Entity.Category;
import com.KitchenStory.service.Adminservice;
import com.KitchenStory.service.CatergoryService;

@Controller
public class LoginControllers {

	@Autowired
	CatergoryService catser;

	@Autowired
	Adminservice aserv;

	@GetMapping("/")
	public String greet() {

		return "index.html";
	}

	@SuppressWarnings("null")
	@PostMapping(value = "/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model m) {

		Admin admin = aserv.logincheck(username, password);

		if (admin == null) {

			return "Logout";
		} else if (admin.getPassword().equals(password)) {

			List<Category> listcat = catser.getallcat();
			m.addAttribute("listcat", listcat);
			return "Login";
		} else {
			return "Logout";
		}

	}

	@PostMapping("/Category")
	public String Category(Model model) {

		return "Category.html";
	}

	@GetMapping(value = "/login")
	public String getcat(Model m) {

		List<Category> listcat = catser.getallcat();
		m.addAttribute("listcat", listcat);
		return "Login";
	}

	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		catser.removeCategoryById(id);
		return "redirect:/login";

	}

	@GetMapping("/deleteconfirm/{id}")
	public String deleteCategorconfirm(@PathVariable("id") int id, Model m) {

		m.addAttribute("id", id);
		return "deletecofirm";

	}

	@GetMapping("/changepass")
	public String changepass() {

		return "changepass.html";
	}

	@PostMapping("/confirmpass")
	public String confirmpass(@RequestParam("oldpass") String oldpass, @RequestParam("newpass") String newpass,
			@RequestParam("username") String username, Model m) {

		Admin admin = aserv.logincheck(username, oldpass);
		if (admin == null) {

			return "checkpass";
		} else {
			aserv.updatepass(username, newpass);
			return "passchanged";
		}

	}
	
	@GetMapping("updatecat/{id}")
	public String updatecat(@PathVariable("id") int id,Model m) {
		
		m.addAttribute("id", id);
		return "updatecat.html";
	}
	
	@PostMapping("/updateconfirm")
	public String updateconfirm(@RequestParam("id") int id,@RequestParam String name) {
		
		catser.updateCategoryById(name, id);
		return "Updateconfirm.html";
	}
	
		
		
	

}
