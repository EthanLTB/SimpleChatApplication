package com.coderscampus.assignment14.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.dto.MessageDto;
import com.coderscampus.assignment14.repo.MessageRepository;



@Service
public class MessageService {
@Autowired
private ChannelService channelService;
@Autowired
private MessageRepository messageRepo;
@Autowired
private UserService userService;
	

	public Message createMessage(MessageDto message) {
			Message newMessage = new Message();
		Optional<Channel> channelOpt = channelService.findById(message.getChannelId());
		String messageContent = message.getMessageContent();
		Optional<User> user = userService.findById(message.getUserId());
		newMessage.setUser(user);
		newMessage.setMessageContent(messageContent);
		newMessage.setChannel(channelOpt);
		messageRepo.save(newMessage);
		System.out.println(newMessage);
		return null;
				
		
	}



	public List<MessageDto> findAllByChannelId( Long channelId) {
		List<Message> messages = messageRepo.findAllByChannelId(channelId);
		List<MessageDto> newMessages = new ArrayList<MessageDto>();
		for(Message message : messages) {
			MessageDto newMessage = new MessageDto();
			newMessage.setMessageName(userService.findName(message.getUser().getUserId()));
			newMessage.setChannelId(message.getChannel().getChannelId());
			newMessage.setMessageContent(message.getMessageContent());
			newMessage.setUserId(message.getUser().getUserId());
			newMessages.add(newMessage);
		}
		return newMessages;
	}

	
}
