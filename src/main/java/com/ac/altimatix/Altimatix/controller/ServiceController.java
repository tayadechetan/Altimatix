package com.ac.altimatix.Altimatix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServiceController {

	@RequestMapping("/services")
    public String getService(){
    	System.out.println("############# services ####################");
    	return "services";
    }
}
