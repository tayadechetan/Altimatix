package com.ac.altimatix.Altimatix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ac.altimatix.Altimatix.controller.dto.UserRegistrationDto;
import com.ac.altimatix.Altimatix.model.User;
import com.ac.altimatix.Altimatix.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result){
    	System.out.println("+++++++++++++++++++++++++chetan++++++++++++++++++++++++++++++++++++++++ " + userDto.getCurrentYear());
    	System.out.println("+++++++++++++++++++++++++chetan++++++++++++++++++++++++++++++++++++++++" + userDto.getMobileNumber());
    	System.out.println("+++++++++++++++++++++++++chetan++++++++++++++++++++++++++++++++++++++++ " + userDto.getFirstName());
    	System.out.println("+++++++++++++++++++++++++chetan++++++++++++++++++++++++++++++++++++++++ " + userDto.getLastName());
    	System.out.println("+++++++++++++++++++++++++chetan++++++++++++++++++++++++++++++++++++++++ " + userDto.getEmail());
    	System.out.println("+++++++++++++++++++++++++chetan++++++++++++++++++++++++++++++++++++++++ " + userDto.getPassword());
    	
        User existing = userService.findByEmail(userDto.getEmail());
//        System.out.println("+++++++++++++++++++++++++chetan++++++++++++++++++++++++++++++++++++++++ " + existing.getMobileNumber());
        if (existing != null){
        	System.out.println("+++++++++++++++++++++++++check   4 ++++++++++++++++++++++++++++++++++++++++ ");
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
        	System.out.println("+++++++++++++++++++++++++check   1 ++++++++++++++++++++++++++++++++++++++++ ");
            return "registration";
        }
        System.out.println("+++++++++++++++++++++++++check   2 ++++++++++++++++++++++++++++++++++++++++ ");
        userService.save(userDto);
        System.out.println("--------------------------------------- final");
        return "redirect:/index";
    }

}
