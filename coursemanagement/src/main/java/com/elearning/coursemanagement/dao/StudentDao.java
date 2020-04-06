package com.elearning.coursemanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.elearning.coursemanagement.model.Student;

public interface StudentDao extends CrudRepository<Student,String> {

	//Student findByName(String name);

	public List<Student>  findAll();
	public Student findByName(String name);
	

}
