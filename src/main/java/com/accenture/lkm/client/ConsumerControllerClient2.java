package com.accenture.lkm.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumerControllerClient2 {
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@RequestMapping(path="/consumer2/getDetails")
	public ResponseEntity<String> getEmployee(){
		
		ServiceInstance serviceInstance=loadBalancer.choose("cst-employee-producer");
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl=baseUrl+"/emp/controller/getDetails";
	
		System.out.println(">>>From Client -> Server Instance Id port number: >>"+serviceInstance.getPort());
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=restTemplate.exchange(baseUrl,HttpMethod.GET,null,String.class);
		
		return response;
	}

	
}