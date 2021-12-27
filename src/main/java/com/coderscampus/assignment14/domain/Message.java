package com.coderscampus.assignment14.domain;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {
	private Long messageId;
	private String messageContent;
	private User user;
	private Channel channel;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getMessageId() {
		return messageId;
	}
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name="channel_id")
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel optional) {
		this.channel = optional;
	}
	

}
