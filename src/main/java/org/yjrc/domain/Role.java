package org.yjrc.domain;

public class Role {
	
	/*
	 * id
	 */
	private int id;
	
	/*
	 * 用户名
	 */
	private String userName;
	
	/*
	 * 角色：ROLE_ADMIN，ROLE_USER
	 */
	private String roleName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
