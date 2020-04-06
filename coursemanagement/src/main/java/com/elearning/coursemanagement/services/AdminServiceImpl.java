package com.elearning.coursemanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.elearning.coursemanagement.dao.AdminDao;
import com.elearning.coursemanagement.dao.CourseDao;
import com.elearning.coursemanagement.dao.StudentDao;
import com.elearning.coursemanagement.model.Admin;
import com.elearning.coursemanagement.model.Course;
import com.elearning.coursemanagement.model.Student;
@Service
@Component
public class AdminServiceImpl  implements AdminService
{
     @Autowired
	private AdminDao adminDao;
     @Autowired
     private CourseDao courseDao;
     @Autowired
     private StudentDao dao;
	@Override
	public boolean login(Admin admin) {

             
	Optional<Admin>	 a =adminDao.findById(admin.getUsername());
	Admin ad = a.get();
	
	if(ad.getPassword().equals(admin.getPassword()))
	{
		return true;
	}
		
		return false;
	}

	@Override
	public boolean addCourse(Course coures) {
	    Course c= courseDao.save(coures);
	      if(c!=null)
	      {
	          return true;
	      }
	        return false;
	    }


	@Override
	public List<Course> getAllCourses() {
		
		List<Course> p=(List<Course>)courseDao.findAll();
		return p;
	}

	@Override
	public List<Student> studentsList() {
		
		return dao.findAll();
	}

	

}
