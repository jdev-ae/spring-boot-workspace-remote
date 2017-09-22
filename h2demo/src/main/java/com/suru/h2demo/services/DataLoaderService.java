package com.suru.h2demo.services;

import com.suru.h2demo.H2demoApplication;
import com.suru.h2demo.model.Author;
import com.suru.h2demo.model.Post;
import com.suru.h2demo.repositories.AuthorRepository;
import com.suru.h2demo.repositories.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DataLoaderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataLoaderService.class);
    private PostRepository postRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public DataLoaderService(PostRepository postRepository, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }


    public void addData() {
        Author author = new Author();
        author.setName("Jane");
        author.setEmail("jane@email.com");
        authorRepository.save(author);

        Post post = new Post();
        post.setAuthor(author);
        post.setPost("jane post");
        post.setPostedOn(new Date());
        postRepository.save(post);
    }

    public void printAuthors() {
        Iterable<Author> authors = authorRepository.findAll();
        for (Author author : authors) {
            LOGGER.info(author.toString());
        }
    }

}
