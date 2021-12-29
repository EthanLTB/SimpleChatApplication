package com.coderscampus.assignment14.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.dto.MessageDto;
import com.coderscampus.assignment14.service.ChannelService;
import com.coderscampus.assignment14.service.MessageService;
import com.coderscampus.assignment14.service.UserService;

@Controller
public class ChatController {
	@Autowired
	private ChannelService channelService;
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/")
public String directToWelcome() {
		return "redirect:/welcome";
	}
	@GetMapping("/welcome")
	public String getWelcomePage(ModelMap model) {
		
		List<Channel> channels = channelService.findAll();
		model.put("channels", channels);
        model.put("channel", new Channel());
        
		return "welcome";
	}
	
	@GetMapping("/channels/{channelId}")
	public String getOneChannel(@PathVariable Long channelId) {
//		List<Message> messages = messageService.findAll();
//		model.put("messages", messages);
		return "channel";
	}
	
	@PostMapping("/channels/{channelId}/getMessages")
	@ResponseBody
	public List<Message> getMessages(@PathVariable Long channelId){
		
		List<Message> messages = messageService.findAll();
		
		messages.stream().forEach(message -> System.out.println(message.getUser()));
		return null;
		
	}
	
	@PostMapping("/channels/{channelId}/createMessage")
	@ResponseBody
	public void createMessage( @RequestBody MessageDto message ) {
		System.out.println("making new message");
		messageService.createAndAddMessageToChannel(message);
		
	}
	
	@PostMapping("/welcome/createChannel")
	public String createNewChannel(Channel channel) {
		channelService.save(channel);
		return "redirect:/welcome";
	}
	
	@PostMapping("/welcome/createUser")
	@ResponseBody
	public User createUser(@RequestBody String username) {	
		return userService.createUser(username);
		
	}
}
