package com.suru.springboot.sampledataapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suru.springboot.sampledataapp.model.Author;
import com.suru.springboot.sampledataapp.repositories.AuthorRepository;

@Service
public class AuthorService {

	private AuthorRepository authorRepository;

	@Autowired
	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public void addAuthor(Author author) {
		authorRepository.save(author);
	}

	public List<Author> getAllAuthors() {
		Iterable<Author> all = authorRepository.findAll();
		List<Author> authors = new ArrayList<>();
		all.forEach(authors::add);
		return authors;
	}

}
