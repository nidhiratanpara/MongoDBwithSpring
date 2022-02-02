package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentService studentservice;

	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return studentservice.createStudent(student);

	}

	@GetMapping("/getById/{id}")
	public Student getStudentById(@PathVariable String id) {
		return studentservice.getStudentById(id);

	}

	@GetMapping("/all")
	public List<Student> getAllStudent() {
		return studentservice.getAllStudent();
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		return studentservice.deleteStudent(id);
	}

	@GetMapping("/studentByName/{name}")
	public List<Student> studentsByName(@PathVariable String name) {
		return studentservice.studentsByName(name);
	}

	@GetMapping("/studentByNameAndEmail")
	public List<Student> studentByNameAndEmail(@RequestParam String name, @RequestParam String email) {
		return studentservice.studentByNameAndEmail(name, email);
	}

	@GetMapping("/studentByNameOrEmail")
	public List<Student> studentByNameOrEmail(@RequestParam String name, @RequestParam String email) {
		return studentservice.studentByNameOrEmail(name, email);

	}

	@GetMapping("/allWithPagination")
	public List<Student> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
		return studentservice.getAllWithPagination(pageNo, pageSize);
	}

	@GetMapping("/allWithSorting")
	public List<Student> allWithSorting() {
		return studentservice.allWithSorting();
	}

	@GetMapping("/byDepartmentName")
	public List<Student> byDepartmentName(@RequestParam String deptName) {
		return studentservice.byDepartmentName(deptName);
	}

	@GetMapping("/bySujectName")
	public List<Student> bySujectName(@RequestParam String subName) {
		return studentservice.bySujectName(subName);
	}

	@GetMapping("/emailLike")
	public List<Student> emailLike(@RequestParam String email) {
		return studentservice.emailLike(email);
	}

	@GetMapping("/nameStartWith")
	public List<Student> nameStartWith(@RequestParam String name) {
		return studentservice.nameStartWith(name);
	}

}
