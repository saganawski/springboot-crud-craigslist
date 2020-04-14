package com.crudcraigslist.shitty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crudcraigslist.shitty.dao.CategoryRepository;
import com.crudcraigslist.shitty.model.Category;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository repo;
	
	@Override
	public List<Category> getCategories() {
		return repo.findAll();
	}

}
