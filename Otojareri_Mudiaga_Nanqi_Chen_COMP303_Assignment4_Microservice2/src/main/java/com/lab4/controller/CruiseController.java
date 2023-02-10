package com.lab4.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lab4.model.Cruise;
import com.lab4.repositories.CruiseRepository;

@Controller
public class CruiseController {
	@Autowired
	private CruiseRepository crsRepository;
	
	@GetMapping("/addCruise")
	public String addCruiseGet(Cruise cruise) {
		return "add-cruise";
	}

	@PostMapping("/addCruise")
	public String addCruisePost(@Valid Cruise cruise, BindingResult result, Model model) 
	{
	        if (result.hasErrors()) 
	        {
	            return "add-cruise";
	        }

	        crsRepository.save(cruise);
	        model.addAttribute("cruises", crsRepository.findAll());
	        return "cruises";
   }
		
	//Get the edit request
	@GetMapping("/edit/{crsId}")
	public String edit(@PathVariable("crsId") int crsId, Model model) 
	{
	    Cruise crs = crsRepository.findById(crsId).get();

	    model.addAttribute("cruise", crs);
	    return "update-cruise";
	}
	
	//update existing cruise info
	@PostMapping("/update/{crsId}")
	public String update(@PathVariable("crsId") int crsId, Cruise cruise,
		  BindingResult result, Model model) 
	{
	    if (result.hasErrors()) {
	        cruise.setCruiseID(crsId);
	        return "update-cruise";
	    }

	    crsRepository.save(cruise);
	    model.addAttribute("cruises", crsRepository.findAll());
	    return "cruises";
	}
	//delete cruise info
	@GetMapping("/delete/{crsId}")
	public String delete(@PathVariable("crsId") int crsId, Model model) 
	{
	    Cruise cruise= crsRepository.findById(crsId).get();
	    if (cruise.getDepartureDate().compareTo(new java.util.Date())<0) {
	    	crsRepository.delete(cruise);
	    }
	    model.addAttribute("cruises", crsRepository.findAll());
	    return "cruises";
	    
	}
}
