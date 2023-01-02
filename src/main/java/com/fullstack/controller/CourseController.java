package com.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.entity.Course;
import com.fullstack.service.CourseService;

@RestController
@RequestMapping("/coursesapi")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/add")
	public Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
	@GetMapping("/{code}")
	public Course findCourseByCode(@PathVariable("code") String code) {
		return courseService.findCourseByCode(code);
	}
	
	@GetMapping("/getAll")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
		
	}
}
