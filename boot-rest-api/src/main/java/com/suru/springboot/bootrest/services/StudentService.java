package com.suru.springboot.bootrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suru.springboot.bootrest.model.Course;
import com.suru.springboot.bootrest.model.Student;
import com.suru.springboot.bootrest.repositories.StudentRepository;

@Service
public class StudentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

	private StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public void addStudent(Student s) {
		LOGGER.info("stu save: " + s.toString());
		studentRepository.save(s);
	}

	public Student getStudentDetails(Long id) {
		return studentRepository.findById(id).get();
	}

	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<>();
		studentRepository.findAll().forEach(list::add);
		return list;
	}

	public Set<Course> getCoursesForStudent(Long id) {
		return studentRepository.findById(id).get().getCourses();
	}

}
