package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	AppUser findByUserName(String userName);
}
