package org.yjrc.domain;


public class User {

	/*
	 * 编号
	 */
	private Integer id;
	
	/*
	 * 用户名
	 */
	private String userName;
	
	/*
	 * 密码
	 */
	private String password;
	
	/*
	 * 姓名
	 */
	private String name;
	
	/*
	 * 角色
	 */
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
