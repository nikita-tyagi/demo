package com.example.springhateosdemo.model;

import org.springframework.hateoas.ResourceSupport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends ResourceSupport {
	
	private int customerId;
    private String customerName;
    private String companyName;
}
