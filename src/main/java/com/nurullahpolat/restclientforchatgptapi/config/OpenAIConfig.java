package com.nurullahpolat.restclientforchatgptapi.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Nurullah Polat
 *
 */
@Configuration
public class OpenAIConfig {
	
	/**
	 * We are reading api key values from application 
	 * properties file with <code>@Value<code> annotation
	 * 
	 */
	@Value("${openai.api.key}")
	private String apiKey;
	
	@Bean
	public RestTemplate template() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add((request, body, execution) -> {
			request.getHeaders().add("Authorization", "Bearer " + apiKey);
			return execution.execute(request, body);
		});
		
		return restTemplate;
	}
	
}
