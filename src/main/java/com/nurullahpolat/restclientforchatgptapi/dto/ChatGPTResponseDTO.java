package com.nurullahpolat.restclientforchatgptapi.dto;

import java.util.List;

import com.nurullahpolat.restclientforchatgptapi.model.Choice;

/**
 * @author Nurullah Polat
 * 
 * Data Transfer Object class for api response
 *
 */
public class ChatGPTResponseDTO {

	private List<Choice> choices;

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}
	
}
