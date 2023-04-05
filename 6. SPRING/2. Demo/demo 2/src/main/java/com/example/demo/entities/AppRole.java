package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "APP_ROLE", schema = "training", uniqueConstraints = {
		@UniqueConstraint(name = "APP_ROLE_UK", columnNames = "ROLE_NAME") })

public class AppRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLE_ID", nullable = false)
	private Long roleId;
	@Column(name = "ROLE_NAME", length = 30, nullable = false)
	private String roleName;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "AppRole [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
