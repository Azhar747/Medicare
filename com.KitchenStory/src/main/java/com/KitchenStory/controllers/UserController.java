package com.KitchenStory.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.KitchenStory.Entity.Users;
import com.KitchenStory.service.Userserivce;

@Controller
public class UserController {
	
	@Autowired
	Userserivce userser;
	
	@PostMapping("/Adduser")
	public String adduser() {
		return "AddUser.html";
		
	}
	@GetMapping("/User")
	public String user(Model m ) {
		List<Users>listuser= userser.getallusers();
		m.addAttribute("listuser", listuser);
		return "User.html";
		}
		
	
	@PostMapping("/SaveUser")
	public String saveuser(Users user) {
		
		userser.Usersave(user);
		
		return "Saveuser.html";
		
	}
	
	@PostMapping("/searchuser")
	public String searchuser(Model m ,@RequestParam("keyword") String keyword) {
		if(keyword.isEmpty()) {
			System.out.println("the keyword is empty ");
			List<Users>listuser= userser.getallusers();
			m.addAttribute("listuser", listuser);
			
		}
		else {
			System.out.println(keyword);
			List<Users> listuser= userser.findbykeyword(keyword);
			m.addAttribute("listuser", listuser);
		}
			
		
			return "User.html";
	}
		
	@GetMapping("/deleteuserconfirm/{id}")
	public String deleteprdconfirm(@PathVariable("id") int id,Model m) {
		m.addAttribute("id", id);
		return "deleteuserconfirm";

	}
	@GetMapping("/deleteUser/{id}")
	public String deleteuser(@PathVariable("id") Long id) {
		
		userser.removeUserById(id);
		return "redirect:/User";

	}
	
	
	@GetMapping("updateuser/{id}")
	public String updateuser(@PathVariable("id") int id,Model m) {
		
		m.addAttribute("id", id);
		return "Updateuser.html";
	}
	
	@PostMapping("/updateconfirmuser")
	public String updateuser(@RequestParam("id") Long id,@RequestParam String firstname, String lastname,String email) {
		
		userser.updateById(id,firstname,lastname,email);
		return "Updateconfirm.html";
	}
	
		
			
		
	}
	
	
	
	
	
