package com.mindtree.student.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mindtree.student.dto.College;
import com.mindtree.student.entity.Student;
import com.mindtree.student.repository.StudentRepository;
import com.mindtree.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	 RestTemplate restTemplate;
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student add(Student std) {
		return studentRepository.save(std);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student assignCollege(long college_id, long roll_No) {
		Student std = studentRepository.findById(roll_No).get();
		College clg = restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+college_id, College.class);
		if(clg==null) return null;
//		if(Long. college_id || roll_No==null)
//		{
//			return null;
//		}
		std.setCollege_id(college_id);
		studentRepository.save(std);
		return std;
	}

	@Override
	public List<Student> getByCollegeId(Long college_id) {
		// TODO Auto-generated method stub
		return studentRepository.getByCollegeId(college_id);
	}

	@Override
	public List<Student> getStudentsByAge(Long college_id) {
		// TODO Auto-generated method stub
		return studentRepository.getStudentByAge(college_id);
	}

	

}
