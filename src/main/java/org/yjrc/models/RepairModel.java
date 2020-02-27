package org.yjrc.models;

import java.text.ParseException;
import java.util.Date;

import org.yjrc.utils.DateUtils;

public class RepairModel {
	
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
	private String startTime;
	
	/*
	 * 协议维修结束时间
	 */
	private String endTime;
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/*
	 * 详情
	 */
	private String details;
	
	/*
	 * 创建时间
	 */
	private String createTime;
	
	/*
	 * 维修人员
	 */
	private int repairmanId;
	
	/*
	 * 维修时间
	 */
	private Date repairTime;
	
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
	
	/*
	 * 状态值
	 */
	private String statusValue;
	
	/*
	 * 对维修的评价
	 */
	private String evaluation;	
	
	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	
	
	public Date getStartTimeConverted() throws ParseException {
		return DateUtils.getDateFormat().parse(this.startTime);
    }

    public void setStartTimeByEntity(Date date) {        
        this.startTime = DateUtils.getDateFormat().format(date);
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


	public Date getEndTimeConverted() throws ParseException {
		return DateUtils.getDateFormat().parse(this.endTime);
    }

	public void setEndTimeByEntity(Date date) {
		this.endTime = DateUtils.getDateFormat().format(date);
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getCreateTime() {
		return createTime;
	}
	
	public Date getCreateTimeConverted() throws ParseException {
		return DateUtils.getDateFormat().parse(this.createTime);
    }

	public void setCreateTimeByEntity(Date createTime) {
		this.createTime = DateUtils.getDateFormat().format(createTime);
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
