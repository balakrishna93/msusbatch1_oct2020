package com.virtusa.banking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.banking.models.Appointment;
import com.virtusa.banking.repositories.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepo;
	
	public Appointment addAppointment(Appointment appointment) {
		return appointmentRepo.save(appointment);
	}
	
	public List<Appointment> findByAll(){
		return appointmentRepo.findAll();
	}
}
