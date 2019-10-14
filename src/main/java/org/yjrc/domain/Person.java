package org.yjrc.domain;

import java.util.Date;

public class Person {
	/*
	 * 编号
	 */
	private Integer id;
	
	/*
	 * 姓名
	 */
	private String name;
	
	/*
	 * 生日
	 */
	private Date birthday;
	
	public Integer getId() {
		return this.id;		
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthday() {
		return this.birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
