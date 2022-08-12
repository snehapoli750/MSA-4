package com.mindtree.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.student.entity.Student;

@Repository
@EnableJpaRepositories 
public interface StudentRepository extends JpaRepository<Student,Long>{
	
	@Query(value="SELECT * FROM college WHERE college_id=:college_id ORDER BY name ASC", nativeQuery = true)
	List<Student> getByCollegeId(@Param("college_id") Long college_id);
	
	@Query(value="SELECT * FROM Stream WHERE Stream=:Stream ORDER BY age DESC", nativeQuery = true)
	List<Student> getStudentByAge(@Param("college_id") Long college_id);

}
