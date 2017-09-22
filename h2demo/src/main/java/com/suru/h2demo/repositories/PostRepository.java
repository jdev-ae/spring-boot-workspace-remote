package com.suru.h2demo.repositories;

import com.suru.h2demo.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
