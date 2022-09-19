package com.mindtree.orchard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.orchard.entity.CollectionOfStudents;
import com.mindtree.orchard.entity.Student;
import com.mindtree.orchard.implementation.StudentImplementation;

@Component
@RestController
@RequestMapping
public class StudentController 
{
	@Autowired
	private StudentImplementation studentservice;
	
	@GetMapping("/students")
	public List<Student> getAllStudents()
	{
		return studentservice.getAllStudents();
	}
	
	@GetMapping("/students/{studentid}")
	public Student getStudentDetails(@PathVariable Integer studentid)
	{
		return studentservice.getStudent(studentid);
	}
	
	@GetMapping("/college/{collegeid}")
	public CollectionOfStudents getAllStudents(@PathVariable Integer collegeid)
	{
		return studentservice.getStudentByCollege(collegeid);
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student stu)
	{
		return studentservice.addStudent(stu);
	}
}
