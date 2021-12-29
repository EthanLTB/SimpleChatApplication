package com.coderscampus.assignment14.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto {
	@Override
	public String toString() {
		return "MessageDto [messageContent=" + messageContent + ", channelId=" + channelId + ", userId=" + userId + "]";
	}
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
	@Override
	public int hashCode() {
		return Objects.hash(channelId, messageContent, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageDto other = (MessageDto) obj;
		return Objects.equals(channelId, other.channelId) && Objects.equals(messageContent, other.messageContent)
				&& Objects.equals(userId, other.userId);
	}
	
}
