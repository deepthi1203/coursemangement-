package com.elearning.coursemanagement.services;

import java.util.List;

import javax.validation.Valid;

import com.elearning.coursemanagement.model.Course;
import com.elearning.coursemanagement.model.Student;
import com.elearning.coursemanagement.model.StudentLogin;

public interface StudentServices {

	public boolean login(StudentLogin student);
	public int register(Student student);
	public List<Course> getAllCourses();
	public Student getStudent(String name);
	public Course getCourse(int id);
	public boolean updateStudent(Student student);

	

}
