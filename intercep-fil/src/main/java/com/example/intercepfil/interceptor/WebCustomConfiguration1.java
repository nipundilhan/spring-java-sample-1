package com.example.intercepfil.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebCustomConfiguration1 implements WebMvcConfigurer{
	
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new GeneralPurposeInterceptor());
        registry.addInterceptor(new SpecificPurposeInterceptor()).addPathPatterns("/intercep/products/**");
    }
}
