package com.fullstack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.entity.Course;
import com.fullstack.exceptions.CourseNotFoundException;
import com.fullstack.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepository.save(course);
		return course;
	}

	@Override
	public Course findCourseByCode(String code) throws CourseNotFoundException{
		// TODO Auto-generated method stub
		Optional<Course> courses=courseRepository.findById(code);
		if(courses.isPresent())
			return courses.get();
		throw new CourseNotFoundException(); 
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		List<Course> courses=courseRepository.findAll();
		return courses;
	}

	@Override
	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepository.delete(course);
	}

}
