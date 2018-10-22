package com.ac.altimatix.Altimatix.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ac.altimatix.Altimatix.dao.UserDetailsDAO;
import com.ac.altimatix.Altimatix.mapper.UserDetailMapper;
import com.ac.altimatix.Altimatix.model.User;
import com.ac.altimatix.Altimatix.util.WebUtils;

@Controller
public class UserProfileController {
//	@RequestMapping("/User_home")
//    public String getUserHome(Model model){
//    	System.out.println("############# User home #################### " + model.toString());
//    	return "User_home";
//    }
	
	 @Autowired
	 private UserDetailsDAO userDetailDAO;
	    
//	@RequestMapping("/User_profile")
//    public ModelAndView getUserProfile(){
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//		if (!(auth instanceof AnonymousAuthenticationToken)) {
//
//			System.out.println("############# User profile ####################");
//			 ModelAndView modelAndView = new ModelAndView();
//			 modelAndView.addObject("userdetails", userDetailDAO.findUserAccountDetail("c2@gmail.com"));
//			    modelAndView.setViewName("User_profile");
//			    return modelAndView;
//		}else{
//			ModelAndView modelAndView = new ModelAndView();
//			modelAndView.setViewName("error");
//			return modelAndView;
//		}
//    }
	
	 @RequestMapping("/User_profile")
   public ModelAndView getUserProfile(){
		 System.out.println("############# User profile ####################");
		 User user = new User();
		 user.setFirstName("Person's name");
      Gson gson = new Gson();

      ModelAndView modelAndView = new ModelAndView("User_profile");
//      ModelAndView modelAndView = new ModelAndView();
//      modelAndView.setViewName("demo");
      modelAndView.addObject("user", gson.toJson(user));
//      modelAndView.addObject("name", "chetan");
//      return "User_profile";
      return modelAndView;
	 }
	 
	@RequestMapping("/skills")
    public String getUserProfileSkill(){
    	System.out.println("############# User profile skill ####################");
    	return "skills";
    }
	
    @RequestMapping("/User_home")
    public ModelAndView userInfo() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
    	System.out.println("############# User home #################### " );
    	ModelAndView model = new ModelAndView();
    	model.addObject("users", getUsers());
    	model.setViewName("User_home");
    	return model;
        }else{
        	ModelAndView model = new ModelAndView();
        	model.setViewName("error");
        	return model;
        }
    }
    private List<User> getUsers() {
		User user = new User();
		user.setEmail("johndoe123@gmail.com");
		user.setFirstName("John Doe");
		User user1 = new User();
		user1.setEmail("amitsingh@yahoo.com");
		user1.setFirstName("Amit Singh");
		User user2 = new User();
		user2.setEmail("bipulkumar@gmail.com");
		user2.setFirstName("Bipul Kumar");
		User user3 = new User();
		user3.setEmail("prakashranjan@gmail.com");
		user3.setFirstName("Prakash Ranjan");
		return Arrays.asList(user, user1, user2, user3);
	}
    
    @RequestMapping("/project")
    public String userProject() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (!(auth instanceof AnonymousAuthenticationToken)) {
    	System.out.println("############# User Project #################### " );
        return "project";
//        }else{
//        	return "error";
//        }
    }
}
