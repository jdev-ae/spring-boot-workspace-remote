package com.suru.springboot.bootrest.repositories;

import org.springframework.data.repository.CrudRepository;

import com.suru.springboot.bootrest.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

}
