package com.crudcraigslist.shitty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crudcraigslist.shitty.model.Category;
import com.crudcraigslist.shitty.service.CategoryService;

@Controller
@RequestMapping("/")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping()
	public String getCategories(Model model) {
		List<Category> categories = categoryService.getCategories();
		
		model.addAttribute("categories", categories);
		return "index.html";
	}
	
}
