package com.mindworx.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mindworx.dao.UserDao;
import com.mindworx.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	private static final Logger log = Logger.getLogger(MyUserDetailsService.class);
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getByLoginId(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        grantList.add(authority);
        log.info("CustLogin:"+user.getCustLogin()+ "CusPword:"+user.getCusPword());
        
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getCustLogin(), user.getCusPword(),grantList);
        return userDetails;
		
	}
	
	

}
