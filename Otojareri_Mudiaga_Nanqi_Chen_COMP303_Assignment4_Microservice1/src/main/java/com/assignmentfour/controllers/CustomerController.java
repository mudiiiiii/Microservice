package com.assignmentfour.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import com.assignmentfour.Customer;
import com.assignmentfour.repositories.CustomerRepository;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class CustomerController {
	@Autowired 
	private CustomerRepository cusRepository;
	
	@GetMapping("/")
    public String indexPage(Customer customer)
    {
        return "register";
    }
	@GetMapping("/register")
    public String register(Customer customer)
    {
        return "register";
    }
	@PostMapping("/register")
	public String createCustomer(@Valid Customer customer, BindingResult result, Model model, HttpServletResponse response) throws IOException
	{
	        if (result.hasErrors()) 
	        {
	            return "register";
	        }
//	        if (cusRepository.findByusername(customer.getUsername()).size()>0) {
//	        	// if the user name is repeated:
//	        	
//				//https://www.codetd.com/en/article/10179465
//				//use PrintWriter to write a javascript to pop-up a little window
//	        	response.setContentType("text/html;charset=utf-8");
//				PrintWriter htmlEditer = response.getWriter();
//				htmlEditer.print("<script type='text/javascript'>alert('Please change your username. It is repeated with existing user.');</script>");
//	        }
	        cusRepository.save(customer);
	        return "login";
    }
	
	@GetMapping("/login")
    public String login(Customer customer)
    {
        return "login";
    }
	
	@PostMapping("/login")
    public String loginPost(@Valid Customer customer, BindingResult result, Model model, HttpServletResponse response) throws IOException
    {
		if (result.hasErrors()) 
        {
            return "login";
        }
		//only one customer should return
		List<Customer> customerSearched = cusRepository.findByusername(customer.getUsername());
		if (customerSearched.size() == 0) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter htmlEditer = response.getWriter();
			htmlEditer.print("<script type='text/javascript'>alert('Your username not found.');</script>");
			return "login";
		}
		//compare password
		else if (!customerSearched.get(0).getPassword().equals(customer.getPassword())) {
			//if password is wrong
        	response.setContentType("text/html;charset=utf-8");
			PrintWriter htmlEditer = response.getWriter();
			htmlEditer.print("<script type='text/javascript'>alert('Your password does not match.');</script>");
			return "login";
		} else {
			//redirect is from this website: https://zetcode.com/spring/redirect/
			
			return "redirect:customerDetails/"+customerSearched.get(0).getCustID();
		}
    }
	@GetMapping("/customerDetails/{id}")
    public String cusDetail(@PathVariable("id") int custId, Model model)
    {
		Customer cus = cusRepository.findById(custId).get();
		model.addAttribute("customer", cus);
        return "customerDetails";
    }
	
	@GetMapping("/cusEdit/{id}")
    public String cusEdit(@PathVariable("id") int custId, Model model)
    {
		Customer cus = cusRepository.findById(custId).get();
		model.addAttribute("customer", cus);
        return "customerEdit";
    }
	
	@PostMapping("/cusUpdate/{id}")
    public String cusEditPost(@PathVariable("id") int custId, @Valid Customer customerEdit, BindingResult result, Model model)
    {
		Customer cus = cusRepository.findById(custId).get();
		// fill the missing values that customer should not change
		customerEdit.setCustID(custId);
		customerEdit.setUsername(cus.getUsername());
		customerEdit.setPassword(cus.getPassword());
		// Else it will not pass the server side validation
		
		cusRepository.save(customerEdit);
		model.addAttribute("customer", customerEdit);
        return "customerDetails";
    }
	
}
