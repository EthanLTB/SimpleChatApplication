package com.coderscampus.assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.service.ChannelService;

@Controller
public class ChatController {
	@Autowired
	private ChannelService channelService;

	@GetMapping("/welcome")
	public String getCreateUser(ModelMap model) {
		
		List<Channel> channels = channelService.findAll();
		model.put("channels", channels);
        model.put("channel", new Channel());
		return "welcome";
	}
	
	@PostMapping("/welcome")
	public String createNewChannel(Channel channel) {
		channelService.save(channel);
		return "redirect:/welcome";
	}
}
