package com.mindworx.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Configuration
	@Order(2)
	public static class App1ConfigurationAdapter extends WebSecurityConfigurerAdapter {
	    public App1ConfigurationAdapter() {
	        super();
	    }
	    
	    @Autowired
		private AdminDetailsService userDetailsService;
	    
	    @Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService);
		}
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	
	    	http.antMatcher("/admin*")
	          .authorizeRequests()
	          .anyRequest()
	          .hasRole("ADMIN")
	           
	          .and()
	          .formLogin()
	          .loginPage("/loginAdmin")
	          .loginProcessingUrl("/loginAdmin")
	          .failureUrl("/loginAdmin?error=loginError")
	          .defaultSuccessUrl("/adminDashboard")
	           
	          .and()
	          .logout()
	          .logoutUrl("/admin_logout")
	          .logoutSuccessUrl("/protectedLinks")
	          .deleteCookies("JSESSIONID")
	           
	          .and()
	          .exceptionHandling()
	          .accessDeniedPage("/403")
	           
	          .and()
	          .csrf().disable();
	    }
	}
	
	@Configuration
	@Order(1)
	public static class App2ConfigurationAdapter extends WebSecurityConfigurerAdapter {
	 
	    public App2ConfigurationAdapter() {
	        super();
	    }
	    
	    @Autowired
		private MyUserDetailsService userDetailsService;
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService);
		}
		
	 
	    protected void configure(HttpSecurity http) throws Exception {
	    	
	    	http.authorizeRequests().antMatchers("/login","/loginAdmin").permitAll();
	    	
	    	http.antMatcher("/**")
	          .authorizeRequests()
	          .anyRequest()
	          .hasRole("USER")
	          		         
		        .and()
		        .formLogin()
		        .loginPage("/login")
		        .loginProcessingUrl("/login")
		        .failureUrl("/login?error=loginError")
		        .defaultSuccessUrl("/dashboard")
		         
		        .and()
		        .logout()
		        .logoutUrl("/user_logout")
		        .logoutSuccessUrl("/login?logout")
		        .deleteCookies("JSESSIONID")
		         
		        .and()
		        .exceptionHandling()
		        .accessDeniedPage("/403")       
		        
	    	  	.and()
		        .csrf().disable();	    	
	    }
	    
	    @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers("/resources/**");
	    }
	}	
}
