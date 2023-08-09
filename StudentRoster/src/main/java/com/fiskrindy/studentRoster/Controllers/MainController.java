package com.fiskrindy.studentRoster.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fiskrindy.studentRoster.Models.Dorm;
import com.fiskrindy.studentRoster.Models.Student;
import com.fiskrindy.studentRoster.Services.DormService;
import com.fiskrindy.studentRoster.Services.StudentService;

@Controller
public class MainController {
	@Autowired
	private DormService dormService;
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String dashboard(Model model) {
		model.addAttribute("dorms", dormService.allDorms());
		return "dorms.jsp";
	}
	
	@GetMapping("/dorm/new")
	public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
		return "newDorm.jsp";
	}
	
	@PostMapping("/dorm/new")
	public String addDorm(@ModelAttribute("dorm") Dorm dorm) {
		dormService.addDorm(dorm);
		return "redirect:/";
	}
	
	@GetMapping("/student/new")
	public String newStudent(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("dorms", dormService.allDorms());
		return "newStudent.jsp";
	}
	
	@PostMapping("/student/new")
	public String addStudent(@ModelAttribute("student") Student student) {
		studentService.addStudent(student);
		return "redirect:/";
	}
	
	@GetMapping("/dorms/{id}")
	public String viewDorms(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dorm", dormService.findDorm(id));
		model.addAttribute("students", studentService.dormStudents(id));
		return "viewDorm.jsp";
	}
	
	@GetMapping("/students/remove/{id}")
	public String removeStudent(@PathVariable("id") Long id) {
		studentService.removeStudentFromDorm(studentService.findStudentId(id));
		return "redirect:/";
	}
}
