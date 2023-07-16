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
	
	@Value("${openai.model}")
	private String model;
	
	@Value("${openai.api.url}")
	private String apiUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/chat")
	public String chat(@RequestParam("prompt") String prompt) {
		
		ChatGPTRequestDTO chatGPTRequestDTO = new ChatGPTRequestDTO(model, prompt);
		
		ChatGPTResponseDTO chatGPTResponseDTO = restTemplate.postForObject(apiUrl, chatGPTRequestDTO, ChatGPTResponseDTO.class);
		
		return chatGPTResponseDTO.getChoices().get(0).getMessageDTO().getContent();
	}

}
