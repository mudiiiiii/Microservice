package com.assignmentfour.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignmentfour.Booking;
import com.assignmentfour.Cruise;
import com.assignmentfour.Customer;
import com.assignmentfour.repositories.BookingRepository;
import com.assignmentfour.repositories.CruiseRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class BookingController {
	@Autowired 
	private BookingRepository bookRepository;
	@Autowired
	private CruiseRepository crsRepository;

	
	//seems like the model.addAttribute containalize a int into a object
	//and later when we try to get it, it turns into a String
	//so we have to do some conversion
	@PostMapping("/history/{custId}/{crsId}")
    public String addBookings(@PathVariable("custId") String custIDstring, @PathVariable("crsId") String crsIDstring, Model model, @RequestParam("numberOfGuests") Integer numberOfGuests, HttpServletResponse response) throws IOException
    {
//		Booking booking = new Booking(1,1,crsID,currentNumOfGuests,"Good");	
		//transform string back to int
		int custID = Integer.parseInt(custIDstring);
		int crsID = Integer.parseInt(crsIDstring);
		
		//get corresponding instance(s)
		Cruise cruise = crsRepository.findById(crsID).get();
		List<Booking> bookingListByCustId = bookRepository.findAllBycustID(custID);
		
		//check the departure dates
		//Only check if the list is not empty
		if (bookingListByCustId.size()>0) {
			for (int i = 0; i < bookingListByCustId.size(); i++) {
				Booking booking = bookingListByCustId.get(i);
				Cruise cruiseToCompare = crsRepository.findById(booking.getCruiseID()).get();
				if (booking.getStatus().equals("Cancel")) {
					//ignore Cancel bookings
					continue;
				}
				else if (cruiseToCompare.getDepartureDate().compareTo(cruise.getDepartureDate())==0) {
					//return "There is overlap on your booking schedule! Please check!";
					
					response.setContentType("text/html;charset=utf-8");
					PrintWriter htmlEditer = response.getWriter();
					htmlEditer.print("<script type='text/javascript'>alert('There is overlap on your booking schedule! Please check!');</script>");
					model.addAttribute("bookings", bookRepository.findAllBycustID(custID));
			        return "bookingDetails";
				}
			}
		}
		
		double priceOfCruise = cruise.getPrice();
		double totalAmount = numberOfGuests * priceOfCruise;
		
		Booking booking = new Booking(custID,crsID,numberOfGuests,totalAmount,"Reserved");
		bookRepository.save(booking);

		model.addAttribute("bookings", bookRepository.findAllBycustID(custID));
        return "bookingDetails";
    }
	
	@GetMapping("/guestNum/{custId}/{crsId}")
	public String guestsNumCalculate(@PathVariable("custId") String custIDstring, @PathVariable("crsId") String crsIDstring, Model model) throws IOException
    {
		model.addAttribute("customerId", custIDstring);
		model.addAttribute("cruiseId", crsIDstring);
		return "guestNumber";
    }
	
	@GetMapping("/cancel/{bookId}/{cusId}")
    public String cancelBookings(@PathVariable("bookId") int bookingID, @PathVariable("cusId") int custID, Model model, HttpServletResponse response) throws IOException
    {
		Booking booking = bookRepository.findById(bookingID).get();
		Cruise cruise = crsRepository.findById(booking.getCruiseID()).get();
		
		//only delete booking which its cruise departure time is 7 days later or more
		Date sevenDaysAfterCurrentDate = DateUtils.addDays(new Date(),7); 
		if (cruise.getDepartureDate().after(sevenDaysAfterCurrentDate)) {
			Booking bookingNeedToCancel = bookRepository.findById(bookingID).get();
			bookingNeedToCancel.setStatus("Cancel");
			bookRepository.save(bookingNeedToCancel);
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter htmlEditer = response.getWriter();
			htmlEditer.print("<script type='text/javascript'>alert('Sorry, cancel only works on cruises that departs at 7 days or more.');</script>");
		}
		
		model.addAttribute("bookings", bookRepository.findAllBycustID(custID));
        return "bookingDetails";
    }
}
