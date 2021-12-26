package com.example.intercepfil.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpecificUrlPatterFilter  implements Filter{
	
	public static final Logger Log =  LoggerFactory.getLogger(SpecificUrlPatterFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Log.info(" specific url patter filter applied .......");
		chain.doFilter(request, response);
		// TODO Auto-generated method stub
		
	}

}
