package com.suru.springboot.sampledataapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.suru.springboot.sampledataapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
