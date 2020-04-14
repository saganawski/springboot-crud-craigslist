package com.crudcraigslist.shitty.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudcraigslist.shitty.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
