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
	
	
//	@GetMapping("subcategory/{name}")
//	public String getSubCategory(@PathVariable("name") final String name, Model model) {
//		final List<String> posts = Arrays.asList("post-1","post-2","post-3");
//		
//		model.addAttribute("name", name);
//		model.addAttribute("posts",posts);
//		return "subcategory";
//	}
//	
//	@GetMapping("post/{name}")
//	public String getPost(@PathVariable("name") final String name, Model model) {
//		model.addAttribute("name", name);
//		return "post";
//	}
}
