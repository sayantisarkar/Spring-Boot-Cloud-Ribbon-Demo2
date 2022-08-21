package com.accenture.lkm.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerControllerClient1 {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(path = "/consumer1/getDetails")
	public ResponseEntity<String> getEmployee(){

		String baseUrl = "http://cst-employee-producer";
		baseUrl = baseUrl + "/emp/controller/getDetails";

		ResponseEntity<String> response = null;
		response = restTemplate.exchange(baseUrl, HttpMethod.GET,null, String.class);
		
		return response;
	}
}