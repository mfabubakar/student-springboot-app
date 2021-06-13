package com.abu.sms.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.abu.sms.entity.Student;
import com.abu.sms.service.StudentService;

@Controller
public class StudentController {

//	Constuctor based dependency injection 

	private StudentService studentService;

	public StudentController(StudentService studentServide) {
		super();
		this.studentService = studentServide;
	}

	// Handlemethod to handle list of student and return model and view

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("Students", studentService.getAllStudents());
		return "Students";

	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {

//		create student object to create student data
		Student student = new Student();
		model.addAttribute("Student", student);
		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";

	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("Student", studentService.getStudentById(id));
		return "edit_student";

	}

	@PostMapping("/students/{id}")
	public String updateStudentForm(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

		// get student from database
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		// save student	
		studentService.updateStudent(existingStudent);

		return "redirect:/students";

	}

}
