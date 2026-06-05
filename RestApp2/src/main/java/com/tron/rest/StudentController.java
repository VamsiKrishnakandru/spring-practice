package com.tron.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tron.model.Student;

@RestController
public class StudentController 
{
	@GetMapping("/stu-info")
	public ResponseEntity<Student> getStudentInfo()
	{
		Student stu = new Student(1, "Tron", "Hyderabad", 17);
		return new ResponseEntity<Student>(stu, HttpStatus.OK);
	}
	
	//even if we do not give ResponseEntity the obj is convert to JSON
	//we use responseEntity to add additional headers/status
	@GetMapping("/stu-info2")
	public Student getStudentInfo2()
	{
		Student stu = new Student(1, "Tron", "Hyderabad", 17);
		return stu;
	}
	
	@PostMapping("/add-stu")
	public ResponseEntity<String> addStudentInfo(@RequestBody Student stu)
	{
		String res="Student added successfully";
		return new ResponseEntity<String>(res, HttpStatus.CREATED);
	}
}
