package com.elearning.coursemanagement.services;

import java.util.List;

import com.elearning.coursemanagement.model.Admin;
import com.elearning.coursemanagement.model.Course;
import com.elearning.coursemanagement.model.Student;

public interface AdminService {
	
	public boolean login(Admin admin);
	public boolean addCourse(Course coures);
	public List<Course>  getAllCourses();
	public List<Student> studentsList();


}
