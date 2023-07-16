package com.nurullahpolat.restclientforchatgptapi.dto;

public class MessageDTO {
	
	private String role;
	private String content;
	
	public MessageDTO(String role, String content) {
		super();
		this.role = role;
		this.content = content;
	}
	
	public MessageDTO() {
		
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
