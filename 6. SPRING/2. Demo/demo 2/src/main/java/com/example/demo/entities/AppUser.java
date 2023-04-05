package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "APP_USER", schema = "training", uniqueConstraints = {

		@UniqueConstraint(columnNames = "USER_NAME", name = "APP_USER_UK") })

public class AppUser {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(name = "USER_NAME", length = 36)
	private String userName;
	@Column(name = "ENCRYTED_PASSWORD", length = 128)
	private String encryptedPassword;
	@Column(name = "ENABLED", columnDefinition = "BIT")
	private boolean enabled;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean b) {
		this.enabled = b;
	}

	@Override
	public String toString() {
		return "AppUser [userId=" + userId + ", userName=" + userName + ", encryptedPassword=" + encryptedPassword
				+ ", enabled=" + enabled + "]";
	}

}
