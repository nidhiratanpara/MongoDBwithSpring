package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	
	/*
	 * @Autowired DepartmentRepository departmentRepository;
	 * 
	 * @Autowired SubjectRepository subjectRepository;
	 * 
	 * public Student createStudent (Student student) { if (student.getDepartment()
	 * != null) { departmentRepository.save(student.getDepartment()); } if
	 * (student.getSubjects() != null && student.getSubjects().size() > 0) {
	 * subjectRepository.saveAll(student.getSubjects()); } return
	 * studentRepository.save(student); }
	 */
	public Student createStudent(Student student) {
		return studentRepository.save(student);

	}

	public Student getStudentById(String id) {
		return studentRepository.findById(id).get();
	}

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public String deleteStudent(String id) {
		studentRepository.deleteById(id);
		return "Student Deleted.";
	}

	public List<Student> studentsByName(String name) {
		return studentRepository.findByNameList(name);
	}

	public List<Student> studentByNameAndEmail(String name, String email) {
		return studentRepository.findByNameAndEmail(name, email);
	}

	public List<Student> studentByNameOrEmail(String name, String email) {
		return studentRepository.findByNameOrEmail(name, email);
	}

	public List<Student> getAllWithPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return studentRepository.findAll(pageable).getContent();
	}

	public List<Student> allWithSorting() {
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		return studentRepository.findAll(sort);
	}

	public List<Student> byDepartmentName(String deptName) {
		return studentRepository.findByDeparmentDepartmentName(deptName);
	}

	public List<Student> bySujectName(String subName) {
		return studentRepository.findBySubjectsSubjectName(subName);
	}

	public List<Student> emailLike(String email) {
		return studentRepository.findByEmailIsLike(email);
	}

	public List<Student> nameStartWith(String name) {
		return studentRepository.findByNameStartsWith(name);
	}

}
