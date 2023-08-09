package com.fiskrindy.studentRoster.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fiskrindy.studentRoster.Models.Student;
import com.fiskrindy.studentRoster.Repositories.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepo;
	
	public StudentService(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	public List<Student> allStudents() {
		return studentRepo.findAll();
	}
	
	public List<Student> dormStudents(Long dormId) {
		return studentRepo.findByDormId(dormId);
	}
	
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public void removeStudentFromDorm(Student student) {
		student.setDorm(null);
		studentRepo.save(student);
	}
	
	public Student findStudentId(Long id) {
		Optional<Student> optionalStudent = studentRepo.findById(id);
		if(optionalStudent.isPresent()) {
			return optionalStudent.get();
		}
		else {
			return null;
		}
	}
}
