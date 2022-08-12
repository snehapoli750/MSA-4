package com.mindtree.student;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import com.mindtree.student.entity.Student;
import com.mindtree.student.repository.StudentRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StudentApplicationTests {

	private static final String CSE = null;

	@Autowired
    private MockMvc mockMvc; 
	
	@Autowired
    private StudentRepository studentRepository;
	
	@BeforeEach
    void setup(){
       studentRepository.deleteAll();
    }

	@Test
    public void givenListOfStudent_whenGetAllStudent_thenReturnstudentList() throws Exception{
        // given - precondition or setup
        List<Student> listOfstudent = new ArrayList<>();
        listOfstudent.add(new Student(3,23,"F","rani",CSE,3);
       
       studentRepository.saveAll(listOfstudent);
        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("http://localhost:9091/student"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfstudent.size())));

    }
}
