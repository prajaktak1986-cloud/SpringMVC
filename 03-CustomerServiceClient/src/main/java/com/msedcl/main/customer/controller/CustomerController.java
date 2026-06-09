package com.msedcl.main.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.msedcl.main.customer.dto.CustomerRequestDTO;
import com.msedcl.main.customer.dto.CustomerResponseDTO;
import com.msedcl.main.customer.service.CustomerService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
public class CustomerController {

	 private final CustomerService customerService;
	 
	 @GetMapping("/")
		public ModelAndView printAllCustomers() {
			System.out.println("printAllCustomers() called.");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("index");
			modelAndView.addObject("customers",customerService.getAllCustomers());
			return modelAndView;
		}
	 
		@PostMapping("savecustomer")
		public String saveCustomer(@Valid CustomerRequestDTO customerRequestDTO, BindingResult bindingResult) {
			System.out.println("saveCustomer() called.");
			//System.out.println("customerRequestDTO received in controller.");
			//System.out.println(customerRequestDTO.toString());
			
			if(bindingResult.hasErrors()) {
				log.info("bindingResult.hasError = true.");
				return "customer-form";
			}
			//empDTOList.add(employeeDTO);
//			ModelAndView modelAndView = new ModelAndView();
//			modelAndView.setViewName("customer-form");
//			modelAndView.addObject("customers",customerService.createNewCustomer(customerRequestDTO));
//			
			customerService.createNewCustomer(customerRequestDTO);
			//return modelAndView;
			
			System.out.println("customerRequestDTO added.");
			return "redirect:/";
		}
		
		@GetMapping("addnew")
		public ModelAndView addNewCustomer() {
			System.out.println("addNewCustomer() called.");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("customer-form");//redirected form name...html file name
			
			// Creating empty object to connect form/view
			//EmployeeDTO employeeDTO = new EmployeeDTO(0,"Text4",100);
			//CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
			CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
			modelAndView.addObject("customerRequestDTO",customerRequestDTO);
			return modelAndView;
		}
	
}
