package com.atech.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.atech.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	private EntityManager entityManager;
	
	private Session session;

	
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}



	@Override
	public List<Student> findAll() {
		
		session = entityManager.unwrap(Session.class);
	
		List<Student> students = session.createQuery(
				                 "from Student", Student.class).list();
		
		return students;
	}



	@Override
	public Student findById(int studentId) {
		
		session = entityManager.unwrap(Session.class);
		
		Student theStudent = session.get(Student.class, studentId);
		
		return theStudent;
	}


	@Override
	public void save(Student student) {
		
		session = entityManager.unwrap(Session.class);
				
		session.saveOrUpdate(student);
				
	}

	@Override
	public void delete(Student theStudent) {
		
		session = entityManager.unwrap(Session.class);
		
		session.delete(theStudent);
		
	}



	@Override
	public boolean contains(Student student) {
		
		session = entityManager.unwrap(Session.class);
		
		boolean result = session.contains(student);
		
		return result;
	}

}
