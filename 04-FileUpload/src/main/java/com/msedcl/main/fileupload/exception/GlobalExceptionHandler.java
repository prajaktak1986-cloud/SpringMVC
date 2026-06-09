package com.msedcl.main.fileupload.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice 
public class GlobalExceptionHandler {	
	@ExceptionHandler(MaxUploadSizeExceededException.class)		
		public String handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e, Model model) {
		System.out.println("----------In GlobalExceptionHandler File Size exceeds---------");
		log.info("In GlobalExceptionHandler File Size exceeds");	
		model.addAttribute("error", "File Size exceeds");			
			return "file-upload";
		}
	}

//@Slf4j
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(MultipartException.class)
//    public String handleMultipartException(
//            MultipartException ex,
//            Model model) {
//
//    	System.out.println("----------In GlobalExceptionHandler File Size exceeds---------");
//		log.info("In GlobalExceptionHandler File Size exceeds");	
//        model.addAttribute("error", "File size exceeds");
//
//        return "file-upload";
//    }
//}
