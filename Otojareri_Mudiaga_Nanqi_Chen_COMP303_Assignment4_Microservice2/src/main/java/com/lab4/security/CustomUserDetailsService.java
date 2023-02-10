package com.lab4.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lab4.model.Employee;
import com.lab4.repositories.EmployeeRepository;


public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Employee employee = empRepo.findByUserName(userName);
		if (employee == null) {
			throw new UsernameNotFoundException("Employee Not Found!");
		}
		return new CustomUserDetails(employee);
	}
}
