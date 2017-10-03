package com.suru.springboot.bootrest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.suru.springboot.bootrest.model.Course;
import com.suru.springboot.bootrest.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
//	public List<Course> findAllCoursesForStudentId(Long id);
}
