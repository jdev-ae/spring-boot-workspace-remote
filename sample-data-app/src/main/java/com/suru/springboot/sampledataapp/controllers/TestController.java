package com.suru.springboot.sampledataapp.controllers;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 

import com.suru.springboot.sampledataapp.model.Author;
import com.suru.springboot.sampledataapp.model.Post;
import com.suru.springboot.sampledataapp.services.AuthorService;
import com.suru.springboot.sampledataapp.services.PostService;

@Controller
public class TestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	private AuthorService authorService;
	private PostService postService;

	@Autowired
	public TestController(AuthorService authorService, PostService postService) {
		this.authorService = authorService;
		this.postService = postService;
	}

	@PostConstruct
	public void test() {
		LOGGER.info("in test controller");

		authorService.addAuthor(new Author("SuRu", "suru@gmail.com"));
		authorService.addAuthor(new Author("Nani", "nani@gmail.com"));
		authorService.addAuthor(new Author("John", "jh0083@gmail.com"));
		authorService.addAuthor(new Author("Tim", "tm_001@gmail.com"));
		LOGGER.info("authorService done!");

		List<Author> authors = authorService.getAllAuthors();
		for (Author a : authors) {
			LOGGER.info(a.toString());
			postService.addPost(new Post(null, UUID.randomUUID().toString().substring(0, 8), UUID.randomUUID().toString(), new Date(), a));
			postService.addPost(new Post(null, UUID.randomUUID().toString().substring(0, 8), UUID.randomUUID().toString(), new Date(), a));
			postService.addPost(new Post(null, UUID.randomUUID().toString().substring(0, 8), UUID.randomUUID().toString(), new Date(), a));
			postService.addPost(new Post(null, UUID.randomUUID().toString().substring(0, 8), UUID.randomUUID().toString(), new Date(), a));
		}
		LOGGER.info("postService done!");

		List<Post> postsForAuthor = postService.getPostsForAuthor(2L);
		for (Post post : postsForAuthor) {
			LOGGER.info(post.toString());
		}

		LOGGER.info("posts done!");
	}

}
