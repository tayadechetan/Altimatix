package com.ac.altimatix.Altimatix.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ac.altimatix.Altimatix.controller.dto.PasswordForgotDto;
import com.ac.altimatix.Altimatix.controller.dto.PasswordResetDto;
import com.ac.altimatix.Altimatix.controller.dto.UserRegistrationDto;
import com.ac.altimatix.Altimatix.model.Mail;
import com.ac.altimatix.Altimatix.model.PasswordResetToken;
import com.ac.altimatix.Altimatix.model.User;
import com.ac.altimatix.Altimatix.repository.PasswordResetTokenRepository;
import com.ac.altimatix.Altimatix.service.EmailService;
import com.ac.altimatix.Altimatix.service.UserService;

@Controller
//@RequestMapping("/index")
public class FrontControllerss {
	 @Autowired
	    private UserService userService;

	 @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
//	 @GetMapping
	 public String index() {
	    	System.out.println("############# index ####################");
	        return "index";
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
