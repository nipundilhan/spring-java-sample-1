package com.example.intercepfil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.intercepfil.filter.SpecificUrlPatterFilter;

@SpringBootApplication
public class IntercepFilApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntercepFilApplication.class, args);
	}

	
	@Bean
	FilterRegistrationBean<SpecificUrlPatterFilter> SpecificUrlPatternFilterRegistrationBean(){
		
		final FilterRegistrationBean<SpecificUrlPatterFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new SpecificUrlPatterFilter());
		filterRegistrationBean.addUrlPatterns("/filter/specific-url-pattern/*");
		return filterRegistrationBean;
	}
}
