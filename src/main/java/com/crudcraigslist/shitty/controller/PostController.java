package com.crudcraigslist.shitty.controller;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crudcraigslist.shitty.model.Category;
import com.crudcraigslist.shitty.model.Post;
import com.crudcraigslist.shitty.service.CategoryService;

@Controller
@RequestMapping("categories/{categoryId}/")
public class PostController {
	@Autowired
	CategoryService categoryService;
	
	
	@GetMapping("post")
	public String getPosts(@PathVariable("categoryId") Integer categoryId, Model model) {
		final Optional<Category> category = categoryService.findCategoryById(categoryId);
		
		final Set<Post> posts = category.map(c -> c.getPosts()).orElse(Collections.emptySet());
		
		model.addAttribute("posts", posts);
		model.addAttribute("category", category.get());
		return "post";
	}
}
