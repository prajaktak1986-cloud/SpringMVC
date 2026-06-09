package com.msedcl.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.msedcl.main.dto.EmployeeDTO;

@Controller
public class HelloWorldController {
	
	private List<EmployeeDTO> empDTOList = new ArrayList<>();
	
	public HelloWorldController() {
		empDTOList.add(new EmployeeDTO(101,"Test 1",1000));
		empDTOList.add(new EmployeeDTO(102,"Test 2",2000));
		empDTOList.add(new EmployeeDTO(103,"Test 3",3000));
	}
	
	@PostMapping("saveemp")
	public String saveEmployee(EmployeeDTO employeeDTO) {
		System.out.println("saveEmployee() called.");
		System.out.println("EmployeeDTO received in controller.");
		System.out.println(employeeDTO.toString());
		empDTOList.add(employeeDTO);
		System.out.println("EmployeeDTO added into empDTOList .");
		return "redirect:/employees";
	}
	
	@GetMapping("addnew")
	public ModelAndView showAddNewEmployee() {
		System.out.println("showAddNewEmployee() called.");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("employee-form");//redirected form name...html file name
		
		// Creating empty object to connect form/view
		//EmployeeDTO employeeDTO = new EmployeeDTO(0,"Text4",100);
		EmployeeDTO employeeDTO = new EmployeeDTO();
		modelAndView.addObject("employee",employeeDTO);
		return modelAndView;
	}
	
	@GetMapping("employees")
	public ModelAndView printAllEmployees() {
		System.out.println("printAllEmployees() called.");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("employee-list");
		modelAndView.addObject("employeeList",empDTOList);
		return modelAndView;
	}
	
	@GetMapping("/")
	public String showHomePage() {
		return "index";
	}
	
	@GetMapping("next")
	public String showNextPage() {
		return "second";
	}
	
//	@GetMapping("process")
//	public String printMessage(String message) {
//		System.out.println(message);
//		return "index";
//	}
	
	@GetMapping("process")
	public ModelAndView printMessage(String message) {
		System.out.println(message);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("third");
		modelAndView.addObject("msg",message);
		return modelAndView;
	}
	
}
