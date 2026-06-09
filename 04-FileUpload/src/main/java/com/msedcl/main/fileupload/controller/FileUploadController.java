package com.msedcl.main.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileUploadController {

	@Value("${file.upload-dir}")
	private String uploadDir;
	
//	@org.springframework.beans.factory.annotation.Value("${file.upload-dir}")
//	private String uploadDir;
	
	@GetMapping("upload")
	public String showUploadPage() {
		return "file-upload";
	}
	
//	@PostMapping("upload")
//	public ModelAndView uploadFile(MultipartFile file, Model model) {
//		ModelAndView modelAndView = new ModelAndView();
//		if(file.isEmpty()) {
//			model.addAttribute("error", "Please select file");
//			modelAndView.setViewName("file-upload");
//			modelAndView.addObject(model);
//		}
//		MultipartFile multipartFile = file.g
//	}
	
	@PostMapping("upload")
	public String uploadFile(MultipartFile file, Model model) {
		System.out.println("----------uploadFile");
		if(file.isEmpty()) {
			model.addAttribute("error", "File is empty");
			System.out.println("File is empty");
			log.info("File is empty");
			return "file-upload";			
		}
		
		try {
			String newName =   LocalDate.now().toString() + file.getOriginalFilename();
			System.out.println("newName :- " + newName);
			log.info("newName :- " + newName);
			File destination = new File(uploadDir + newName);
			file.transferTo(destination);
			model.addAttribute("success", "File uploaded successfully.");
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			model.addAttribute("error", "Failed to upload file");
		}
		
		return "file-upload";	
	}
}
