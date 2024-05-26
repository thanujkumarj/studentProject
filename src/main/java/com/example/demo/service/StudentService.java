package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;


@Service
public class StudentService {
	@Autowired
	private StudentRepository stuRepo;
	
	public List<Student> findAll(){
		return stuRepo.findAll();
	}
	
	public Student getById(int id) {
		return stuRepo.findById(id).orElse(null);
	}
	
	public Student getByName(String name) {
		return stuRepo.getByName(name);
	}
	
	public Student saveStudent(Student student) {
		return stuRepo.save(student);
	}
	public Student updateStudent(Student student) {
		Student existingStudent = stuRepo.findById(student.getId()).orElse(null);
		existingStudent.setName(student.getName());
		existingStudent.setMarks(student.getMarks());
		return stuRepo.save(existingStudent);
		
	}
	
	public String deleteStudent(Student student) {
		stuRepo.deleteById(student.getId());
		return "Student Removed:"+ student.getName();
	}

	
	
}

//list of students
//get student by id
//get student by name
//add student
//update student
//delstudent