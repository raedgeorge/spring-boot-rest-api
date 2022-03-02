package com.atech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atech.dao.StudentDAO;
import com.atech.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	private final StudentDAO studentDAO;
	
	@Autowired
	public StudentServiceImpl(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}


	@Override
	@Transactional
	public List<Student> getStudents() {
		
		return studentDAO.findAll();
	}


	@Override
	@Transactional
	public Student getStudent(int studentId) {
		
		return studentDAO.findById(studentId);
	}


	@Override
	@Transactional
	public void addStudent(Student student) {
		
		studentDAO.save(student);
		
	}

	@Override
	@Transactional
	public void deleteStudent(Student theStudent) {
		
		studentDAO.delete(theStudent);
		
	}


	@Override
	public boolean contains(Student student) {
		
		return studentDAO.contains(student);
	}

}
