package com.mindworx.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mindworx.dao.AdminDao;
import com.mindworx.model.Admin;
@Service
public class AdminDetailsService implements UserDetailsService{
	
	@Autowired
	private AdminDao adminDao;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminDao.getByLoginId(username);
        if (admin == null) {
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
        grantList.add(authority);
                
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(admin.getUserid(), admin.getPassword(),grantList);
        return userDetails;
		
		
	}

}
