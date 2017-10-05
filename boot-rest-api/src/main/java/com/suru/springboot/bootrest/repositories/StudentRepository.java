package com.suru.springboot.bootrest.repositories;

import org.springframework.data.repository.CrudRepository;

import com.suru.springboot.bootrest.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
