package com.atech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atech.entity.Student;
import com.atech.entity.StudentNotFoundException;
import com.atech.service.StudentService;

@RestController
public class StudentRestController {

	private final StudentService studentService;
	
	@Autowired
	public StudentRestController(StudentService studentService) {
		this.studentService = studentService;
	}

	
	@GetMapping("/students")
	public List<Student> findAll() {
						
		return studentService.getStudents();
	}
	
	@GetMapping("/students/{studentId}")
	public Student findById(@PathVariable int studentId) throws Exception {
		
			
		Student theStudent = studentService.getStudent(studentId);
		
		if (theStudent == null) {
			throw new StudentNotFoundException("student not found @Id >> " + studentId);
			
		}
		
		return theStudent;
		
	}
	
	@PostMapping("/students")
	public Student saveStudent(@RequestBody Student theStudent) {
		
		theStudent.setId(0);
		
		studentService.addStudent(theStudent);
		
		return theStudent;
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student theStudent) throws Exception {
				
		if (!studentService.contains(theStudent)) {
			
			throw new StudentNotFoundException("@Put this student do not exist");
		}
		
		studentService.addStudent(theStudent);
		
		return theStudent;
	}
	
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int studentId) throws Exception {
		
		Student theStudent = studentService.getStudent(studentId);
		
		if (theStudent == null) {
			throw new StudentNotFoundException("student not found @Id >> " + studentId);
			
		}
		
		System.out.println(theStudent);
		
		studentService.deleteStudent(theStudent);
		
		return "student deleted with id :" + studentId;
		
	}
	
	
}
