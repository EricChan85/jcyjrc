package org.yjrc.models;

public class PasswordModel {
	
	/*
	 * 旧密码
	 */
	private String oldPassword;
	
	/*
	 * 新密码
	 */
	private String newPassword;
	
	/*
	 * 确认密码
	 */
	private String confirmedPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
}
