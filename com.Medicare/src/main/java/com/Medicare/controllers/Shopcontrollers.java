package com.Medicare.controllers;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Medicare.Entity.Category;
import com.Medicare.Entity.Product;
import com.Medicare.service.CartSize;
import com.Medicare.service.CatergoryService;
import com.Medicare.service.Productservice;

@Controller
public class Shopcontrollers {

	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/img";

	@Autowired
	CatergoryService catser;

	@Autowired
	Productservice prdser;

	@GetMapping("/shop")
	public String shop(Model m) {

		List<Category> listcat = new ArrayList<>();
		listcat = catser.getallcat();
		m.addAttribute("listcat", listcat);

		List<Product> listprd = new ArrayList<>();
		listprd = prdser.getprdbyflag("Yes");
		Path imgpath = Paths.get(uploadDir);
		m.addAttribute("listprd", listprd);
		System.out.println(uploadDir);
		m.addAttribute("cartCount", CartSize.cart.size());

		m.addAttribute("uploadDir", imgpath);

		return "Shop.html";
	}

	@GetMapping("veiwproduct/{id}")
	public String viewproduct(@PathVariable("id") int id, Model m) {
		List<Category> listcat = new ArrayList<>();
		listcat = catser.getallcat();
		m.addAttribute("listcat", listcat);

		m.addAttribute("listprd", prdser.getprdbyid((long) id).get()) ; // used .get() beacuse we used optional
		m.addAttribute("cartCount", CartSize.cart.size());
		Path imgpath = Paths.get(uploadDir);
		m.addAttribute("uploadDir", imgpath);
		System.out.println(uploadDir);

		return "viewproduct.html";
	}

	@PostMapping("/searchprd")
	public String serprdbycat(@RequestParam("listprd") String keyword, Model m) {

		List<Category> listcat = new ArrayList<>();
        System.out.println( "the keyword is " +keyword);
		listcat = catser.getallcat();
		m.addAttribute("listcat", listcat);

		List<Product> listprd = prdser.findbykeyword(keyword);
		Path imgpath = Paths.get(uploadDir);
		m.addAttribute("cartCount", CartSize.cart.size());
		m.addAttribute("uploadDir", imgpath);
		m.addAttribute("listprd", listprd);
		return "Shop.html";
	}

}
