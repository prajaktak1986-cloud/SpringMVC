package com.msedcl.main.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.customer.client.CustomerRESTClient;
import com.msedcl.main.customer.dto.CustomerRequestDTO;
import com.msedcl.main.customer.dto.CustomerResponseDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
	private final CustomerRESTClient customerRESTClient;
	
	public List<CustomerResponseDTO> getAllCustomers() {
		return customerRESTClient.getAllCustomers();
	}
	
	public CustomerResponseDTO createNewCustomer(CustomerRequestDTO customerRequestDTO) {
		return customerRESTClient.createNewCustomers(customerRequestDTO);
	}
}