package org.yjrc.domain;

import java.util.Date;

public class Repair {
	
	/*
	 * 编号
	 */
	private int id;
	
	/*
	 * 提交人编号
	 */
	private int personId;
	
	/*
	 * 维修地点
	 */
	private String address;
	
	/*
	 * 联系电话
	 */
	private String phone;
	
	/*
	 * 协议维修开始时间
	 */
	private Date startTime;
	
	/*
	 * 协议维修结束时间
	 */
	private Date endTime;
	
	/*
	 * 详情
	 */
	private String details;
	
	/*
	 * 创建时间
	 */
	private Date createTime;
	
	/*
	 * 维修人员
	 */
	private int repairmanId;
	
	/*
	 * 维修时间
	 */
	private Date repairTime;
	
	/*
	 * 维修工作描述
	 */
	private String repairDescription;
	
	public String getRepairDescription() {
		return repairDescription;
	}

	public void setRepairDescription(String repairDescription) {
		this.repairDescription = repairDescription;
	}

	/*
	 * 状态
	 */
	private int status;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}	
	
	/*
	 * 对维修的评价
	 */
	private String evaluation;
	
	/*
	 * 评价时间
	 */
	private Date evaluationTime;

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}


	public Date getEvaluationTime() {
		return evaluationTime;
	}

	public void setEvaluationTime(Date evaluationTime) {
		this.evaluationTime = evaluationTime;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getRepairmanId() {
		return repairmanId;
	}

	public void setRepairmanId(int repairmanId) {
		this.repairmanId = repairmanId;
	}

	public Date getRepairTime() {
		return repairTime;
	}

	public void setRepairTime(Date repairTime) {
		this.repairTime = repairTime;
	}
}
