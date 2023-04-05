package com.example.demo.services.impl;

import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AppRoleRepository;
import com.example.demo.dao.AppUserRepository;
import com.example.demo.entities.AppUser;
import com.example.demo.entities.CustomUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private AppRoleRepository appRoleRepository;

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		AppUser appUser = appUserRepository.findByUserName(userName);
		if (appUser == null) {
			logger.error("User not found! " + userName);
			throw new UsernameNotFoundException("User " + userName + " was not found in the database");

		}
		logger.info("Found: " + appUser);
//[ROLE_USER, ROLE_ADMIN,..]
		List<String> roleNames = appRoleRepository.findByRoleNames(appUser.getUserId());
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roleNames != null) {
			for (String role : roleNames) {
//ROLE_USER, ROLE_ADMIN,..
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}
		UserDetails userDetails = (UserDetails) new CustomUserDetails(appUser.getUserName(),
				appUser.getEncryptedPassword(), grantList);
		return userDetails;
	}
}