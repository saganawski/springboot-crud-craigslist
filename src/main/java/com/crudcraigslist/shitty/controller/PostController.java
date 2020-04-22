package com.crudcraigslist.shitty.controller;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crudcraigslist.shitty.model.Category;
import com.crudcraigslist.shitty.model.Post;
import com.crudcraigslist.shitty.service.CategoryService;
import com.crudcraigslist.shitty.service.PostService;

@Controller
@RequestMapping("categories/{categoryId}/")
public class PostController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	PostService postService;
	
	
	@GetMapping("posts")
	public String getPosts(@PathVariable("categoryId") Integer categoryId, Model model) {
		final Optional<Category> category = categoryService.findCategoryById(categoryId);
		
		final Set<Post> posts = category.map(c -> c.getPosts()).orElse(Collections.emptySet());
		
		model.addAttribute("posts", posts);
		model.addAttribute("category", category.get());
		return "post";
	}
	
	@GetMapping("posts/new")
	public String createPost(@PathVariable("categoryId") Integer categoryId, Model model) {
		final Post post = new Post("Enter Name");
		
		model.addAttribute("post", post);
		model.addAttribute("categoryId", categoryId);
		
		return "new_post";
	}
	
	@PostMapping("posts")
	public String setNewPost(@PathVariable("categoryId") Integer categoryId,@ModelAttribute("post") Post post) {
		final Optional<Category> category = categoryService.findCategoryById(categoryId);
		post.setCategory(category.get());
		category.ifPresent(c -> c.getPosts().add(post));
		
		final Boolean saved = categoryService.save(category.get());
		
		
		return "redirect:/categories/"+ String.valueOf(categoryId)+"/posts";
	}
	
	@GetMapping("posts/{postId}/edit")
	public String updatePost(@PathVariable("categoryId") Integer categoryId,@PathVariable("postId") Integer postId, Model model) {
		final Post post = postService.findPostById(postId).orElse(null);
		model.addAttribute(post);
		return "edit_post";
	}
	
	
	@PostMapping("posts/{postId}/update")
	public String updatePost(@PathVariable("postId") Integer postId,@ModelAttribute("post") Post updatePost) {
		final Post post = postService.findPostById(postId).orElse(null);
		post.setName(updatePost.getName());
		postService.updatePost(post);
		
		return "redirect:/categories/"+ String.valueOf(post.getCategory().getId())+"/posts";
	}

	
	@PostMapping("posts/{postId}")
	public String deletePost(@PathVariable("categoryId") Integer categoryId,@PathVariable("postId") Integer postId) {
		final Post post = postService.findPostById(postId).orElse(null);
		postService.delete(post);
		
		return "redirect:/categories/"+ String.valueOf(categoryId)+"/posts";
	}
	
	
}
