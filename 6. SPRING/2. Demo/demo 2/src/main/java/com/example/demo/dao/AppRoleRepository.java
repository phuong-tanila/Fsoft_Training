package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
	@Query()
	List<String> findByRoleNames(Long userId);
}
