package com.nurullahpolat.restclientforchatgptapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nurullahpolat.restclientforchatgptapi.dto.ChatGPTRequestDTO;
import com.nurullahpolat.restclientforchatgptapi.dto.ChatGPTResponseDTO;

@RestController
@RequestMapping("/custombot")
public class CustomPromptController {
	
	/**
	 * We are reading chatgpt model values from application 
	 * properties file with <code>@Value<code> annotation
	 * 
	 */
	@Value("${openai.model}")
	private String model;
	
	@Value("${openai.api.url}")
	private String apiUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * The @GetMapping annotation is a composed version of @RequestMapping 
	 * annotation that acts as a shortcut for @RequestMapping(method = RequestMethod. GET) . 
	 * The @GetMapping annotated methods handle the HTTP GET requests 
	 * matched with the given URI expression.
	 * 
	 */
	@GetMapping("/chat")
	public String chat(@RequestParam("prompt") String prompt) {
		
		ChatGPTRequestDTO chatGPTRequestDTO = new ChatGPTRequestDTO(model, prompt);
		
		ChatGPTResponseDTO chatGPTResponseDTO = restTemplate.postForObject(apiUrl, chatGPTRequestDTO, ChatGPTResponseDTO.class);
		
		return chatGPTResponseDTO.getChoices().get(0).getMessageDTO().getContent();
	}

}
