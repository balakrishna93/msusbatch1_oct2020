package com.virtusa.banking.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name="Appointment")
@Data
@XmlRootElement
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Appointment_Id")
	private long appointmentId;
	
	@Column(name = "Appointment_Time", nullable = false)
	private LocalDateTime appointmentTime;
	
	@Column(name = "Document", nullable = false, length = 256)
	@ApiModelProperty(example = "This is sample KYC document")
	private String document;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "Customer_Id"), name = "Customer_Id")
	@JsonIgnore
	private Customer customer;

	
}
