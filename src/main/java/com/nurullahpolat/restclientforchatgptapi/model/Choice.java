package com.nurullahpolat.restclientforchatgptapi.model;

import com.nurullahpolat.restclientforchatgptapi.dto.MessageDTO;

public class Choice {
	
	private int index;
	
	private MessageDTO messageDTO;

	public Choice(int index, MessageDTO messageDTO) {
		super();
		this.index = index;
		this.messageDTO = messageDTO;
	}

	public Choice() {
		super();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public MessageDTO getMessageDTO() {
		return messageDTO;
	}

	public void setMessageDTO(MessageDTO messageDTO) {
		this.messageDTO = messageDTO;
	}
	
	

}
