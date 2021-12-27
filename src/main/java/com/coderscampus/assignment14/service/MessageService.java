package com.coderscampus.assignment14.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;



@Service
public class MessageService {
@Autowired
private ChannelService channelService;
@Autowired
private MessageRepository messageRepo;

//	public Message createMessage(Long channelId, String messageContent) {
//		Message message = new Message();
//		message.setChannel(channelService.findById(channelId));
//		message.setMessageContent(messageContent);
//		return messageRepo.save(message);
//	}

	public Message createAndAddMessageToChannel(Long channelId, Message message) {
		Optional<Channel> channelOpt = channelService.findById(channelId);
		Message newMessage = messageRepo.save(message);
		
		channelOpt.ifPresentOrElse(channel -> channel.getMessages().add(newMessage), () -> 
		 System.out.println( "Value is empty"));
		return newMessage;
	}

	
}
