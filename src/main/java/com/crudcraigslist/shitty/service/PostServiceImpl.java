package com.crudcraigslist.shitty.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crudcraigslist.shitty.dao.PostRepository;
import com.crudcraigslist.shitty.model.Post;
@Service
@Transactional
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostRepository repo;
	
	@Override
	public void delete(Post post) {
		repo.delete(post);
	}

	@Override
	public Optional<Post> findPostById(Integer postId) {
		return repo.findById(postId);
	}

	@Override
	public void updatePost(Post post) {
		repo.save(post);
		
	}

}
