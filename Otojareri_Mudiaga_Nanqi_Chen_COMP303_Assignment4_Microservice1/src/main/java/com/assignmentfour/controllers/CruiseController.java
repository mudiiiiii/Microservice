package com.assignmentfour.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignmentfour.repositories.CruiseRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CruiseController {
	@Autowired 
	private CruiseRepository cRepository;

	//takes us to the main page
	
	@GetMapping("/cruises/{custId}")
    public String showCruises(@PathVariable("custId") int custId, Model model)
    {
		model.addAttribute("customerId", custId);
		model.addAttribute("cruises", cRepository.findAll());
        return "cruisesDetails";
    }
}
