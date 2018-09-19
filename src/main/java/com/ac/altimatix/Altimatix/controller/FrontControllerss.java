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
	  
//	 @RequestMapping("/User_home")
//	 @GetMapping("/User_home")
//		public String getUserHome() {
//		 System.out.println("############# User home #################### " );
//		 return "User_home";
//	 }
	 
	    @ModelAttribute("user")
	    public UserRegistrationDto userRegistrationDto() {
	        return new UserRegistrationDto();
	    }

	    
//	    @GetMapping("modalReg")
//	    
//	    public String showRegistrationForm(Model model) {
//	        return "registration";
//	    }

//	    @PostMapping
//	    @RequestMapping("/registration")
//	    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
//	                                      BindingResult result){
//	    	System.out.println("+++++++++++++++++++++++++successful++++++++++++++++++++++++++++++++++++++");
////	        User existing = userService.findByEmail(userDto.getEmail());
////	        if (existing != null){
////	            result.rejectValue("email", null, "There is already an account registered with that email");
////	        }
////
////	        if (result.hasErrors()){
////	            return "registration";
////	        }
////
////	        userService.save(userDto);
//	        return "redirect:/login";
//	    }
	    
//	    @Autowired private PasswordResetTokenRepository tokenRepository;
//	    @Autowired private BCryptPasswordEncoder passwordEncoder;

	    @ModelAttribute("passwordResetForm")
	    public PasswordResetDto passwordReset() {
	        return new PasswordResetDto();
	    }

//	    @GetMapping("modalReset")
//	    public String displayResetPasswordPage(@RequestParam(required = false) String token,
//	                                           Model model) {
//
//	        PasswordResetToken resetToken = tokenRepository.findByToken(token);
//	        if (resetToken == null){
//	            model.addAttribute("error", "Could not find password reset token.");
//	        } else if (resetToken.isExpired()){
//	            model.addAttribute("error", "Token has expired, please request a new password reset.");
//	        } else {
//	            model.addAttribute("token", resetToken.getToken());
//	        }
//
//	        return "reset-password";
//	    }
//
//	    @PostMapping
//	    @Transactional
//	    @RequestMapping("/reset-password")
//	    public String handlePasswordReset(@ModelAttribute("passwordResetForm") @Valid PasswordResetDto form,
//	                                      BindingResult result,
//	                                      RedirectAttributes redirectAttributes) {
//
//	        if (result.hasErrors()){
//	            redirectAttributes.addFlashAttribute(BindingResult.class.getName() + ".passwordResetForm", result);
//	            redirectAttributes.addFlashAttribute("passwordResetForm", form);
//	            return "redirect:/reset-password?token=" + form.getToken();
//	        }
//
//	        PasswordResetToken token = tokenRepository.findByToken(form.getToken());
//	        User user = token.getUser();
//	        String updatedPassword = passwordEncoder.encode(form.getPassword());
//	        userService.updatePassword(updatedPassword, user.getId());
//	        tokenRepository.delete(token);
//
//	        return "redirect:/login?resetSuccess";
//	    }
//	    
//	    @Autowired private EmailService emailService;

	    @ModelAttribute("forgotPasswordForm")
	    public PasswordForgotDto forgotPasswordDto() {
	        return new PasswordForgotDto();
	    }

//	    @GetMapping("modalforgot")
//	    public String displayForgotPasswordPage() {
//	        return "forgot-password";
//	    }
//
//	    @PostMapping()
//	    @RequestMapping("/forgot-password")
//	    public String processForgotPasswordForm(@ModelAttribute("forgotPasswordForm") @Valid PasswordForgotDto form,
//	                                            BindingResult result,
//	                                            HttpServletRequest request) {
//	    	System.out.println("$$$$$$$$$$$$$$$$$$$$$$$ forgot password");
//	        if (result.hasErrors()){
//	            return "forgot-password";
//	        }
//
//	        User user = userService.findByEmail(form.getEmail());
//	        if (user == null){
//	            result.rejectValue("email", null, "We could not find an account for that e-mail address.");
//	            return "forgot-password";
//	        }
//
//	        PasswordResetToken token = new PasswordResetToken();
//	        token.setToken(UUID.randomUUID().toString());
//	        token.setUser(user);
//	        token.setExpiryDate(30);
//	        tokenRepository.save(token);
//
//	        Mail mail = new Mail();
//	        mail.setFrom("no-reply@memorynotfound.com");
//	        mail.setTo(user.getEmail());
//	        mail.setSubject("Password reset request");
//
//	        Map<String, Object> model = new HashMap<>();
//	        model.put("token", token);
//	        model.put("user", user);
//	        model.put("signature", "https://memorynotfound.com");
//	        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
//	        model.put("resetUrl", url + "/reset-password?token=" + token.getToken());
//	        mail.setModel(model);
//	        emailService.sendEmail(mail);
//
//	        return "redirect:/forgot-password?success";
//
//	    }
	
}
