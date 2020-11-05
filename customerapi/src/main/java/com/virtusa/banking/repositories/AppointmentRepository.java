package com.virtusa.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.banking.models.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
