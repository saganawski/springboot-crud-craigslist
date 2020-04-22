package com.crudcraigslist.shitty.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudcraigslist.shitty.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
