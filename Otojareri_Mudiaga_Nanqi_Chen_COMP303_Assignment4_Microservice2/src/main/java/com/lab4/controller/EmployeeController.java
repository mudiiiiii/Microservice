package com.lab4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lab4.model.*;
import com.lab4.repositories.*;


@Controller
public class EmployeeController {
	@Autowired
	private EmployeeRepository empRepository;
	
	@GetMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("employee", new Employee());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processingRegister(Employee employee) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(employee.getPassword());
		employee.setPassword(encodedPassword);
		
		empRepository.save(employee);
		
		return "register_success";
	}
	
	@GetMapping("/users")
	public String listAllEmployees(Model model) {
		List<Employee> employeesList = empRepository.findAll();
		model.addAttribute("listEmployees", employeesList);
		
		return "indexhome";
	}
}
