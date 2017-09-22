package com.suru.h2demo.repositories;

import com.suru.h2demo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
