package com.mindtree.student.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.mindtree.student.entity.Student;


@Service
public interface StudentService {
	
	Student add(Student std);
	List<Student> getAllStudents();
	List<Student> getByCollegeId(Long college_id);
	List<Student> getStudentsByAge(Long college_id );
	Student assignCollege(long college_id, long roll_No);

}
