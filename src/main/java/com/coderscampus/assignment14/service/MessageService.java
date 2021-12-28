package com.coderscampus.assignment14.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.dto.MessageDto;



@Service
public class MessageService {
@Autowired
private ChannelService channelService;
@Autowired
private MessageRepository messageRepo;
@Autowired
private UserService userService;

//	public Message createMessage(Long channelId, String messageContent) {
//		Message message = new Message();
//		message.setChannel(channelService.findById(channelId));
//		message.setMessageContent(messageContent);
//		return messageRepo.save(message);
//	}

	public Message createAndAddMessageToChannel(Long channelId, Message message) {
//		Optional<Channel> channelOpt = channelService.findById(channelId);
//	
//		channelOpt.ifPresentOrElse(channel -> channel.getMessages().add(newMessage), () -> 
//		 System.out.println( "Value is empty"));
		return null;
	}

	public Message createAndAddMessageToChannel(MessageDto message) {
			Message newMessage = new Message();
		Optional<Channel> channelOpt = channelService.findById(message.getChannelId());
		String messageContent = message.getMessageContent();
		Optional<User> user = userService.findById(message.getUserId());
		newMessage.setUser(user);
		newMessage.setMessageContent(messageContent);
		newMessage.setChannel(channelOpt);
		return messageRepo.save(newMessage);
		
	}

//	public List<Message> findByChannelId(Long channelId) {
//		
//		return messageRepo.findAllByChannel(channelId);
//	}

	public List<Message> findAll() {
		
		return messageRepo.findAll();
	}

	
}
