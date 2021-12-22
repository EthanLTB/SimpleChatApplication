package com.coderscampus.assignment14.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.assignment14.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);

}
