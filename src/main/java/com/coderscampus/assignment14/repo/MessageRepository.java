package com.coderscampus.assignment14.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coderscampus.assignment14.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
//@Query("select u from messages u where u.channelId = :channelId")
//	List<Message> findAllByChannel(Long channelId);
	
}
