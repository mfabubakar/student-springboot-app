package com.abu.sms.service;

import java.util.List;

import com.abu.sms.entity.Student;

public interface StudentService {

	List<Student> getAllStudents();

	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);

}
