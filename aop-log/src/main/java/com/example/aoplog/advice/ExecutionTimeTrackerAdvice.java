package com.example.aoplog.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeTrackerAdvice {
	
	//Logger logger=LoggerFactory.getLogger(ExecutionTimeTrackerAdvice.class);
	Logger logger = LoggerFactory.getLogger("UpperDebugLevelLogger");
	
	@Around("@annotation(com.example.aoplog.advice.TrackExecutionTime)")
	public Object trackTime(ProceedingJoinPoint pjp) throws Throwable {
		long stratTime=System.currentTimeMillis();
		Object obj=pjp.proceed();
		long endTime=System.currentTimeMillis();
		logger.info("Method name"+pjp.getSignature()+" time taken to execute : "+(endTime-stratTime));
		return obj;
	}

}