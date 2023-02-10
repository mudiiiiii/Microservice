package com.assignmentfour.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignmentfour.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	//learn the method here
	//https://bushansirgur.in/spring-data-jpa-finder-query-methods-by-multiple-field-names-with-examples/
	
	List<Booking> findAllBycruiseID(int cruiseId);
	
	int countAllBycruiseID(int cruiseId);
	
	List<Booking> findAllBycustID(int custId);

}
