package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Controller
public class ProductController {

	@Autowired
	private ProductService ps;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
	    List<Product> listProducts = ps.listAll();
	    model.addAttribute("listProducts", listProducts);
	     
	    return "index";
	}
	
	@GetMapping("/new")
	public String addNewProduct(Model model) {
		Product product = new Product();
	    model.addAttribute("product", product);
	     
	    return "new_product";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("product") Product product) {
		
	    ps.save(product);
	     
	    return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editProduct(@PathVariable long id) {
		
	 Product product= ps.findOne(id);
	 ModelAndView mav = new ModelAndView("edit_product");
	 mav.addObject("product", product);
	 return mav;
	  
	}
	
	
}
