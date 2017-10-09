package com.suru.springboot.bootrest.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suru.springboot.bootrest.model.Course;
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
	@ResponseBody
	public Student getStudentDetails(@PathVariable("id") Long id) {
		return studentService.getStudentDetails(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public String addStudent(@RequestBody Student s, Model model) {
		studentService.addStudent(s);
		return "ok";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}/courses")
	@ResponseBody
	public Set<Course> getCoursesForStudent(@PathVariable("id") Long id) {
		return studentService.getCoursesForStudent(id);
	}

	@ExceptionHandler(Exception.class)
	public void handleException(Exception ex, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
	
}
