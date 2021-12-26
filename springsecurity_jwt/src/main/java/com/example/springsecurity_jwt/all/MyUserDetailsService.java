package com.example.springsecurity_jwt.all;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springsecurity_jwt.model.UserOperationDatabaseVirtualService;
import com.example.springsecurity_jwt.model.UserTemp;

@Service
public class MyUserDetailsService  implements UserDetailsService {
	
	@Autowired
	private UserOperationDatabaseVirtualService uodvService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		UserTemp user = uodvService.findUserByUserNameFromDatabase(username);
		
		List<GrantedAuthority> createAuthorityList = AuthorityUtils.createAuthorityList(user.getPermissions());
		
	    return new User(user.getUsername(), user.getPassword(), createAuthorityList);

	}

}
