package com.ac.altimatix.Altimatix.service;

import java.util.ArrayList;
import java.util.List;
 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ac.altimatix.Altimatix.dao.RoleDAO;
import com.ac.altimatix.Altimatix.dao.UserDAO;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserDAO userDAO;
 
    @Autowired
    private RoleDAO roleDAO;
 
    
	@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	System.out.println("^^^^^^^^^^^^^^^^^^^1^^^^^^^^^^^^^^^^^^^^^^^^");
        com.ac.altimatix.Altimatix.model.User appUser = this.userDAO.findUserAccount(userName);
 
        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
 
        System.out.println("Found User: " + appUser);
 
        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.roleDAO.getRoleNames(appUser.getId());
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
 
        UserDetails userDetails = (UserDetails) new User(appUser.getEmail(), //
                appUser.getPassword(), grantList);
 
        return userDetails;
    }
 
}
