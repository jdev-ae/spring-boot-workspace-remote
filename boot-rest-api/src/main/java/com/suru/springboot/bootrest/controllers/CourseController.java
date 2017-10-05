package com.suru.springboot.bootrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suru.springboot.bootrest.model.Course;
import com.suru.springboot.bootrest.services.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	private CourseService courseService;

	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Course getCourseForId(@PathVariable("id") Long id) {
		return courseService.getCourseForId(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public String addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
		return "ok";
	}

}
