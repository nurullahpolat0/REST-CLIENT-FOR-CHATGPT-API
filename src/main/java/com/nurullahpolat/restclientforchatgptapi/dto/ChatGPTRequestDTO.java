package com.nurullahpolat.restclientforchatgptapi.dto;

import java.util.ArrayList;
import java.util.List;

public class ChatGPTRequestDTO {
	
	private String model;
	
	private List<MessageDTO> messages;

	public ChatGPTRequestDTO(String model, String prompt) {
		super();
		this.model = model;
		this.messages = new ArrayList<>();
		this.messages.add(new MessageDTO("user",prompt));
	}

	public ChatGPTRequestDTO() {
		super();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<MessageDTO> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageDTO> messages) {
		this.messages = messages;
	}
	
	

}
