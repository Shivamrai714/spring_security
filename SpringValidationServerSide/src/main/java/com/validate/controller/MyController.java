package com.validate.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.validate.entities.LoginData;

@Controller
public class MyController {

	@GetMapping("/form")
	public String myform(Model m)
	{   
		System.out.println("Inside the mail form controller");
		m.addAttribute("loginData", new LoginData());
		return "form";
	}
	
	
	//hannder for processing / submitting the form.
	// @Valid is placed to apply the validataion, also collect the reults in BInding Results
	
	
	@PostMapping("/submit_form")                  //@ModelAttribute is used to receive the data from form submission.
	public String processform(@Valid  @ModelAttribute("loginData") LoginData loginData  , BindingResult result)
	{
//		System.out.println("Submitting your form . to server");
		if(result.hasErrors())
		{	
			System.out.println(result);
			return "form";            //return the same home page with Error on it
		}
		
		
		
		
		System.out.println(loginData);
		return "success";
		
		
		
		}
	
	
}
