package com.elearning.coursemanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.elearning.coursemanagement.dao.CourseDao;
import com.elearning.coursemanagement.dao.StudentDao;
import com.elearning.coursemanagement.model.Course;
import com.elearning.coursemanagement.model.Student;
import com.elearning.coursemanagement.model.StudentLogin;

@Service
@Component
public class StudentServicesImpl implements StudentServices {
	
	@Autowired
	private StudentDao studentdao;

	@Autowired
	private CourseDao dao;
	@Override
	public boolean login(StudentLogin student) {
		
		Student a =studentdao.findByName(student.getName());
		
		if(a!=null && a.getPassword().equals(student.getPassword()))
		{
			return true;
		}
			
			return false;
	
	}

	@Override
	public int register(Student student) {
		
		Student stud=studentdao.findByName(student.getName());
		
		if(stud!=null)
		{
			return 1;
		}else
		{
			Student s1=studentdao.save(student);
			if(s1!=null) {
				return 2;
			}
		}
		return 3;
	}

	@Override
	public List<Course> getAllCourses() {
		
		
		return dao.findAll();
	}

	@Override
	public Student getStudent(String name) {
		
		return studentdao.findByName(name);
	}

	@Override
	public Course getCourse(int id) {
		
		return dao.findById(id).get();
	}

	@Override
	public boolean updateStudent(Student student) {
		
		Student s =studentdao.save(student);
		if(s!=null)
		{
			return true;
		}
				return false;

	}
}
