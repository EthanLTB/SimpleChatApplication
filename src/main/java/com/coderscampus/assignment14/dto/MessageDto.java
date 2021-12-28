package com.coderscampus.assignment14.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto {
	@JsonProperty("messageContent")
	private String messageContent;
	@JsonProperty("channelId")
	private Long channelId;
	@JsonProperty("userId")
	private Long userId;
	 
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
