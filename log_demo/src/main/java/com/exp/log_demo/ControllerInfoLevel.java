package com.exp.log_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class ControllerInfoLevel {
	
	Logger logger = LoggerFactory.getLogger("UpperInfoLevelLogger");
	
	@GetMapping("/getinfo")
	public String getInfo() {
		logger.info("info custom info logger");
		logger.error("info custom error logger");
		logger.debug("info custom debug logger");
		
		//this debug level message wont saved in log file because 'UpperInfoLevelLogger' logger only get higher levels more than.
		return "success";
	}

}
