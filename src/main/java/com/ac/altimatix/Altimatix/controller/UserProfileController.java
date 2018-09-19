package com.ac.altimatix.Altimatix.controller;

import java.security.Principal;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ac.altimatix.Altimatix.util.WebUtils;

@Controller
public class UserProfileController {
//	@RequestMapping("/User_home")
//    public String getUserHome(Model model){
//    	System.out.println("############# User home #################### " + model.toString());
//    	return "User_home";
//    }
	
	@RequestMapping("/User_home/User_profile")
    public ModelAndView getUserProfile(){
		System.out.println("############# User profile ####################");
		 ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("User_profile");
		    return modelAndView;
//    	return "User_profile";
    }
	
	
	@RequestMapping("/skills")
    public String getUserProfileSkill(){
    	System.out.println("############# User profile skill ####################");
    	return "skills";
    }
	
    @RequestMapping("/User_home")
    public String userInfo() {
    	System.out.println("############# User home #################### " );
        // (1) (en)
        // After user login successfully.
        // (vi)
        // Sau khi user login thanh cong se co principal
//        String userName = principal.getName();
// 
//        System.out.println("User Name: " + userName);
// 
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
// 
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
 
        return "User_home";
    }
}
