package com.suru.springboot.sampledataapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suru.springboot.sampledataapp.model.Post;
import com.suru.springboot.sampledataapp.repositories.PostRepository;

@Service
public class PostService {
	private PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public void addPost(Post post) {
		postRepository.save(post);
	}
	
	public List<Post> getPostsForAuthor(Long id) {
		return postRepository.findByAuthorId(id);
	}
	
}
