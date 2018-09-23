package com.ac.altimatix.Altimatix.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ac.altimatix.Altimatix.service.UserDetailsServiceImpl;
import com.ac.altimatix.Altimatix.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;
    
    
    @Autowired
    UserDetailsServiceImpl userDetailsService;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////      http.authorizeRequests().antMatchers("**/User_home**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
////      http.authorizeRequests().antMatchers("/User_home").access("hasAnyRole('ROLE_USER')");
//      // For ADMIN only.
////      http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");
//      
//      // When the user has logged in as XX.
//      // But access a page that requires role YY,
//      // AccessDeniedExc eption will be thrown.
////      http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
//      http.csrf().disable();
//      
//        http
//                .authorizeRequests()
////                .antMatchers("/User_home/**").hasAnyRole("ROLE_ADMIN","ROLE_USER")
//                    .antMatchers(
////                    		"/",
//                            "/registration**",
//                            "/services**",
//                            "/User_profile**",
//                            "/User_home**",
//                            "/forgot-password**",
//                            "/reset-password**").permitAll()
//                            
//                    .antMatchers(
//                            "/js/**",
//                            "/css/**",
//                            "/images/**",
//                            "/webfonts/**",
//                            "/webjars/**").permitAll()
//                    .anyRequest().authenticated()
//                .and()
//                    .formLogin() 
//                        .loginPage("/index").loginProcessingUrl("/j_spring_security_check")
//                        .usernameParameter("username")//
//                .passwordParameter("password")
//                        .defaultSuccessUrl("/User_home")//
//                .failureUrl("/login?error=true")//
//                .and()
//                    .logout()
//                        .invalidateHttpSession(true)
//                        .clearAuthentication(true)
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        .logoutSuccessUrl("/login?logout")
//                        .permitAll();
//
//    }
    
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/User_home/**").permitAll()
		 .antMatchers(
                            "/js/**",
                            "/css/**",
                            "/images/**",
                            "/webfonts/**",
                            "/webjars/**").permitAll()
		.and().formLogin()  
        .loginPage("/")
        .loginProcessingUrl("/j_spring_security_check")
        .usernameParameter("username")
        .passwordParameter("password")
        .defaultSuccessUrl("/User_home")	
		 .failureUrl("/login?error=true")//
                .and()
                    .logout()
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/");
	} 



    
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
 
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
    	System.out.println("-------------- configureGlobal ----------------- " + passwordEncoder());
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
 
    }

}