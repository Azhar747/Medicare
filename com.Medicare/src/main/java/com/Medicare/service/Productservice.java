package com.Medicare.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Medicare.Entity.Category;
import com.Medicare.Entity.Product;
import com.Medicare.Repository.ProductsRepo;

@Service
public class Productservice {
	@Autowired
	ProductsRepo prdrepo;

	public void saveproduct(Product p) {

		prdrepo.save(p);
	}

	public List<Product> getallPrd() {
		List<Product> listprd = new ArrayList<>();
		prdrepo.findAll().forEach(m -> listprd.add(m));
		return listprd;

	}

	public List<Product> getprdbycat(int id) {
		List<Product> listprd = new ArrayList<>();
		listprd = prdrepo.searchprd(id);
		return listprd;
	}

	public Optional<Product> getprdbyid(Long id) {

		Optional<Product> listprd ;
		listprd = prdrepo.findById(id);
		System.out.println("from product service" + listprd);
		System.out.println("from product service id=" + id);
		return listprd;

	}
	public void removeProductById(Long id) { 
		prdrepo.deleteById(id);
	}
	
	public List<Product> findbykeyword(String keyword) {
		return prdrepo.findbykeyword(keyword);
	}

	public void updateprdbyid(Long id, String Description,double price,double weight) {

		prdrepo.updateprdbyId(id, Description, price, weight);
	}
	
}
