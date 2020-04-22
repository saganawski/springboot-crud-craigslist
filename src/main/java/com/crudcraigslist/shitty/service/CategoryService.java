package com.crudcraigslist.shitty.service;

import java.util.List;
import java.util.Optional;

import com.crudcraigslist.shitty.model.Category;

public interface CategoryService {
	
	List<Category> getCategories();
	
	Optional<Category> findCategoryById(Integer id);

	Boolean save(Category category);

}
