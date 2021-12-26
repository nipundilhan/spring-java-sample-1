package com.example.intercepfil.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class RequestLogginFilter implements Filter{
	
	public static final Logger Log =  LoggerFactory.getLogger(RequestLogginFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Log.info(" In request logging filter .......");
		chain.doFilter(request, response);
		// TODO Auto-generated method stub
		
	}

}
