package com.fullstack.service;

import java.util.List;

import com.fullstack.entity.Course;

public interface CourseService {
	Course addCourse(Course course);
	Course findCourseByCode(String code);
	List<Course> getAllCourses();
	void deleteCourse(Course course);
	
}
