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
public class Order extends ResourceSupport {
	
	private int orderId;
    private double price;
    private int quantity;

}
