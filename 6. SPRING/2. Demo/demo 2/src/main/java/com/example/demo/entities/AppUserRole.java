package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "APP_USER_ROLE", schema = "training",

		uniqueConstraints = {

				@UniqueConstraint(name = "USER_ROLE_UK", columnNames = { "USER_ID", "ROLE_ID" }) })

public class AppUserRole {
	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private AppUser appUser;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID", nullable = false)
	private AppRole appRole;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public AppRole getAppRole() {
		return appRole;
	}

	public void setAppRole(AppRole appRole) {
		this.appRole = appRole;
	}

	@Override
	public String toString() {
		return "AppUserRole [id=" + id + ", appUser=" + appUser + ", appRole=" + appRole + "]";
	}

}
