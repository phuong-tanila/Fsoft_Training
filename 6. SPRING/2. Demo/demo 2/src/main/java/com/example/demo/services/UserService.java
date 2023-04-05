package com.example.demo.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AppRoleRepository;
import com.example.demo.dao.AppUserRepository;
import com.example.demo.entities.AppUser;
import com.example.demo.request.AppUserDTO;

@Service
public class UserService {
	private Logger logger = Logger.getLogger(UserService.class);

	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public AppUser registerUserAccount(AppUserDTO userDto) throws Exception {
		AppUser user = new AppUser();

		user.setUserName(userDto.getUserName());
		user.setEnabled(true);
		user.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		appUserRepository.save(user);
		return user;

	}

}
