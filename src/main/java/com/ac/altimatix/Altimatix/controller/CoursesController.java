package com.ac.altimatix.Altimatix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ac.altimatix.Altimatix.controller.dto.PasswordForgotDto;
import com.ac.altimatix.Altimatix.controller.dto.PasswordResetDto;
import com.ac.altimatix.Altimatix.controller.dto.UserRegistrationDto;

@Controller
public class CoursesController {
	
	@RequestMapping("/course")
	public ModelAndView getCources(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("course");
		return modelAndView;
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
