package com.suru.springboot.bootrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suru.springboot.bootrest.model.Course;
import com.suru.springboot.bootrest.repositories.CourseRepository;

@Service
public class CourseService {

	private CourseRepository courseRepository;

	@Autowired
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public Course getCourseForId(Long id) {
		return courseRepository.findById(id).get();
	}

	public List<Course> getAllCourses() {
		List<Course> list = new ArrayList<>();
		courseRepository.findAll().forEach(list::add);
		return list;
	}

}
