package com.car.lease.brokerservice.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="CUSTOMER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	@Column(name = "NAME", length = 30, nullable = false)
	private String name;
	@Column(name ="STREET",length = 30)
	private String street;
	@Column(name ="HOUSE_NUMBER",length = 30, nullable =  false)
	private String houseNumber;
	@Column(name = "ZIP_CODE",length = 20, nullable = false)
	private String zipCode;
	@Column(name = "PLACE",length = 200)
	private String place;
	@Column(name = "EMAIL_ADDRESS",nullable =  false, length = 100)
	private String emailAddress;
	@Column(name = "PHONE_NUMBER",length = 50)
	private String phoneNumber;
	@Column(name = "CREATED_BY")
	private Long createdBy;
	@Column(name = "UPDATED_BY")
	private Long updatedBy;
	@Column(name = "CREATED_DATE")
	private Timestamp cretaedDate;
	@Column(name = "MODIFIED_DATE")
	private Timestamp modifiedDate;
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", street=" + street + ", houseNumber=" + houseNumber
				+ ", zipCode=" + zipCode + ", place=" + place + ", emailAddress=" + emailAddress + ", phoneNumber="
				+ phoneNumber + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", cretaedDate=" + cretaedDate
				+ ", modifiedDate=" + modifiedDate + "]";
	}


}
