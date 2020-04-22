package com.crudcraigslist.shitty.service;

import java.util.Optional;

import com.crudcraigslist.shitty.model.Post;

public interface PostService {

	void delete(Post post);

	Optional<Post> findPostById(Integer postId);

	void updatePost(Post post);

}
