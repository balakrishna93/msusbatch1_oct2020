package com.virtusa.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.banking.models.Appointment;
import com.virtusa.banking.services.AppointmentService;

@RestController
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;

	@PostMapping("/appointments")
	@CrossOrigin("*")
	public ResponseEntity<?> addAppointment(@RequestBody Appointment appointment){
		Appointment result = appointmentService.addAppointment(appointment);
		if(result != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Appointment Not booked");
		}
	}
	
	@RequestMapping(value="/appointments", 
			produces = {"application/json", "applicaiton/xml"}, 
			method=RequestMethod.GET)
	@CrossOrigin("*")
	public List<Appointment> findAllAppointments(){
		return appointmentService.findByAll();
	}
}
