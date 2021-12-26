package com.exp.log_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/debug")
public class ControllerDebugLevel {
	
	Logger logger = LoggerFactory.getLogger("UpperDebugLevelLogger");
	
	@GetMapping("/getdebug")
	public String getDebug() {
		logger.info("debug custom info logger");
		logger.error("debug custom error logger");
		logger.debug("debug custom debug logger");
		return "success";
	}

}
