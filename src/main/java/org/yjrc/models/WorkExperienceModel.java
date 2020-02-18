package org.yjrc.models;

public class WorkExperienceModel {

	/*
	 * 编号
	 */
	private int id;
	
	/*
	 * 用户编号
	 */
	private int personId;
	
	/*
	 * 开始日期
	 */
	private String startDate;
	
	/*
	 * 结束日期
	 */
	private String endDate;
	
	/*
	 * 详情
	 */
	private String details;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
