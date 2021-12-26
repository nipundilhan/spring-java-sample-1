package com.example.EmailTest1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest-client")
@CrossOrigin(origins = "*")
public class RestClientTestController {
	
	@GetMapping("/test1")
	public String getResponse() {
		String resp= "0";
		RestTemplate restTemplate = new RestTemplate();
		String url= "http://132.145.228.83/comn-common/comn-bank/AnRkr/";
		url= "http://localhost:8080/lending-product/repayment-frequency/AnRkr/"
				;
		for(int i = 1; i<1000 ; i++) {

			url= "http://132.145.228.83/casa-transaction/banktransactionsubcode/AnRkr/subcode/"+i;
			int valid = 0;
			try {	
				ResponseEntity<?> response= restTemplate.getForEntity(url , Object.class);
				
				if(response.getBody() != null) {
					valid = 2;
				}
			} catch (Exception e) {
				valid = 1;
			}
			
			if(valid == 2) {
				System.out.println(i);
				resp = String.valueOf(i);
				break;
			}
		}
		
		return resp;
	}

}
