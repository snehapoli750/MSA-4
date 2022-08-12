package com.mindtree.student.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.student.entity.Student;
import com.mindtree.student.serviceImpl.StudentServiceImpl;


@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@PostMapping("/add")
	public Student add(@RequestBody Student std)
	{
		return studentServiceImpl.add(std);
	}
	
	@GetMapping("/getallstudents")
	public List<Student> getStudentList(){
		return studentServiceImpl.getAllStudents();
	}
	
	@GetMapping("/Student-with-ascname/{collegeId}")
	public List<Student> getStudentsByCollegeId(@PathVariable Long collegeId)
	{
		return studentServiceImpl.getByCollegeId(collegeId);
	}
	
	@GetMapping("/Student-with-descage/{collegeId}")
	public List<Student> getDocInfo(@PathVariable Long collegeId)
	{
		return studentServiceImpl.getStudentsByAge(collegeId);
	}

}
