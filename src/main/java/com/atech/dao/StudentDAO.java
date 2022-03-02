package com.atech.dao;

import java.util.List;

import com.atech.entity.Student;

public interface StudentDAO {
	
	List<Student> findAll();
	
	Student findById(int studentId); 
	
	void save(Student student);
	
	void delete(Student theStudent);
	
	boolean contains(Student student);

}
