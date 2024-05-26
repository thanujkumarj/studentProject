package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;


@RestController
public class StudentController {
	@Autowired
	private StudentService service;

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return service.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Student showStudentDetailsById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@GetMapping("/student/{name}")
	public Student showStudentDetailsByyName(@PathVariable String name) {
		return service.getByName(name);
	}
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}
	
	@DeleteMapping("/delStudent")
	public String delStudent(@RequestBody Student student) {
		return service.deleteStudent(student);
	}
	

}
// get list of students
//get student by id
//get student by name
//add student
//update student
//delstudent

