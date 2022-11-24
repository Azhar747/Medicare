package com.KitchenStory.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.KitchenStory.Entity.Customerinfo;
import com.KitchenStory.Entity.Product;
import com.KitchenStory.service.CartSize;
import com.KitchenStory.service.Customerinforservice;
import com.KitchenStory.service.Productservice;


@Controller
public class CartController {

	@Autowired
	Productservice productService;
	
	@Autowired
	Customerinforservice custserv;
	
	@GetMapping("veiwproduct/addToCart/{id}")
	public String addToCart(@PathVariable int id) {
		CartSize.cart.add(productService.getprdbyid((long) id).get());
		
		
		return "redirect:/shop";
		
	}
	
	@GetMapping("/cart")
	public String cartGet(Model model) {
		List<Product>listprd=CartSize.cart;
		int index=0;
		model.addAttribute("cartCount", CartSize.cart.size());
		model.addAttribute("total", CartSize.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("listprd", listprd);
		model.addAttribute("index", index);
		System.out.println("Products in Cart" +CartSize.cart);
        System.out.println("Cart Size"+CartSize.cart.size());
        
       
     
 
		return "cart";
			
	}
	
	@GetMapping("removeItem/{index}")
	public String cartItemRemove(@PathVariable int index) {
		CartSize.cart.remove(index);
		return "redirect:/cart";
		
	}
	@GetMapping("/checkout")
	public String checkout(Model model) {
		model.addAttribute("total", CartSize.cart.stream().mapToDouble(Product::getPrice).sum());
		return "checkout";
		
	}
	
	@PostMapping("/pay")
	public String payNow(Model model,Customerinfo cust) {
		cust.setAmount(CartSize.cart.stream().mapToDouble(Product::getPrice).sum());
		custserv.savecustinfo(cust);
		
		Long orderid=cust.getID();
		model.addAttribute("result","congratulations..!!,your order is now booked");
		LocalDate localDate = LocalDate.now();
		model.addAttribute("localDate",localDate);
		model.addAttribute("listprd", CartSize.cart);
		model.addAttribute("total", CartSize.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("orderid",orderid);
		return "pay";
		
		
	}
	@GetMapping("custreport")
	public String salesreport(Model m) {
	    List<Customerinfo> listcust= custserv.getallcustomer();
	    m.addAttribute("listcust", listcust);
		return "custreport";
		
}
	
}