package com.abu.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abu.sms.entity.Student;
import com.abu.sms.repository.StudentRepository;
import com.abu.sms.service.StudentService;

@Service
public class StudentSeriveImpl implements StudentService {

	private StudentRepository studentRepository;

	public StudentSeriveImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {		
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {		
		return studentRepository.save(student);
	}
}
