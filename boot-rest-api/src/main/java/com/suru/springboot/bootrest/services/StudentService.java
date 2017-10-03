package com.suru.springboot.bootrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suru.springboot.bootrest.model.Course;
import com.suru.springboot.bootrest.model.Student;
import com.suru.springboot.bootrest.repositories.StudentRepository;

@Service
public class StudentService {

	private StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public void addStudent(Student s) {
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

}
