package com.ac.altimatix.Altimatix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ac.altimatix.Altimatix.controller.dto.PasswordForgotDto;
import com.ac.altimatix.Altimatix.controller.dto.PasswordResetDto;
import com.ac.altimatix.Altimatix.controller.dto.UserRegistrationDto;

@Controller
public class ServiceController {

	@RequestMapping("/services")
    public String getService(){
    	System.out.println("############# services ####################");
    	return "services";
    }
	
	   @ModelAttribute("user")
	    public UserRegistrationDto userRegistrationDto() {
	        return new UserRegistrationDto();
	    }

	    
	    @ModelAttribute("passwordResetForm")
	    public PasswordResetDto passwordReset() {
	        return new PasswordResetDto();
	    }

	    @ModelAttribute("forgotPasswordForm")
	    public PasswordForgotDto forgotPasswordDto() {
	        return new PasswordForgotDto();
	    }
}
