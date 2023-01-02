package com.fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullstack.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String>{

}
