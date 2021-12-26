package com.example.springsecurity_jwt.all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity_jwt.model.UserOperationDatabaseVirtualService;
import com.example.springsecurity_jwt.util.UserUtil;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserOperationDatabaseVirtualService uodvService;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtUtil jwtutil;
	
	@Autowired
	private UserUtil userUtil;
	
	@GetMapping("/hello1")
	@PreAuthorize("hasAnyAuthority('P_1','P_2')")
	public String hello1() {
		
		String result =  "P_1 , P_2 permission needed to hello1 accessed "+ giveRequest(userUtil.getUserId() , userUtil.getUserName());		
		System.out.println(result);
		return result;
	}
	
	@GetMapping("/hello2")
	@PreAuthorize("hasAnyAuthority('P_2','P_4')")
	public String hello2() {
		String result = "P_2 , P_4 permission needed / hello1 accessed "+ giveRequest(userUtil.getUserId() , userUtil.getUserName());			
		System.out.println(result);
		return result;
	}
	
	@GetMapping("/hello3")
	@PreAuthorize("hasAuthority('P_3')")
	public String hello3() {
		String result = "P_3 permission needed / hello1 accessed "+ giveRequest(userUtil.getUserId() , userUtil.getUserName());			
		System.out.println(result);
		return result;
	}
	
	@GetMapping("/hello4")
	@PreAuthorize("hasAuthority('P_4')")
	public String hello4() {
		String result = "P_4 permission needed / hello1 accessed "+ giveRequest(userUtil.getUserId() , userUtil.getUserName());		
		System.out.println(result);
		return result;
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authentict(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
		}catch(BadCredentialsException	e) {
			throw new Exception("incorrect username and password");
		}
		
		final UserDetails userdetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtutil.generateToken(userdetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	public String giveRequest(Long uid , String uname) {
		return " by userId- "+ uid + " userName - " + uname + " -- permission list --  " + uodvService.findUserByUserNameFromDatabase(uname).getPermissions();
	}

}
