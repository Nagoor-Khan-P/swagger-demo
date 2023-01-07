package com.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.entity.Course;
import com.fullstack.service.CourseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/coursesapi")
@Api(value = "Courses to get Succeed!",description = "This provides all the details about the available courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/add")
	@ApiOperation(value = "Add your course here!!", notes = "Please add your courses to the list", response = Course.class)
	public Course addCourse(@RequestBody Course course) {
		String code=course.getCourseCode();
		return courseService.addCourse(course);
	}
	
	@GetMapping("/{code}")
	@ApiOperation(value = "Find a course by Code!!", notes = "You can find the course using course code", response = Course.class)
	public Course findCourseByCode(@PathVariable("code") String code) {
		return courseService.findCourseByCode(code);
	}
	
	@GetMapping("/getAll")
	@ApiOperation(value = "Get all the Courses!!", notes = "Fetch all the available courses in the list", response = Course.class)
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
		
	}
	
	@DeleteMapping("/{code}")
	@ApiOperation(value = "Remove a course from the list", notes = "Used to remove the course from the list of the courses",response = Course.class)
	public Course deleteCourse(@PathVariable("code") String code) {
		Course course=courseService.findCourseByCode(code);
		courseService.deleteCourse(course);
		return course;
		
	}
}
