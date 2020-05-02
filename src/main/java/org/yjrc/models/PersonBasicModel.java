package org.yjrc.models;

public class PersonBasicModel {
	
	private int id;
	
	/*
	 * 姓名
	 */
	private String name;
	
	/*
	 * 用户名
	 */
	private String userName;
	
	/*
	 * 密码
	 */
	private String password;
	
	/*
	 * 身份证号
	 */
	private String numberOfIdCard;		
	
	/*
	 * 角色
	 */
	private String role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getNumberOfIdCard() {
		return numberOfIdCard;
	}

	public void setNumberOfIdCard(String numberOfIdCard) {
		this.numberOfIdCard = numberOfIdCard;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
