package com.suru.springboot.bootrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suru.springboot.bootrest.model.Student;
import com.suru.springboot.bootrest.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Student getStudentDetails(@PathVariable("id") Long id) {
		return studentService.getStudentDetails(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public String addStudent(@RequestBody Student s, Model model) {
		studentService.addStudent(s);
		return "ok";
	}

}
