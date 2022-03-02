package com.atech.service;

import java.util.List;

import com.atech.entity.Student;

public interface StudentService {
	
	List<Student> getStudents();
	
	Student getStudent(int studentId);
	
	void addStudent(Student student);
	
	void deleteStudent(Student theStudent);
	
	boolean contains(Student student);

}
