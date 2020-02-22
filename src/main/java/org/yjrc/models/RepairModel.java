package org.yjrc.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.yjrc.utils.DateUtils;

public class RepairModel {
	
	private static final SimpleDateFormat dateFormat
    						= new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
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
	
	/*
	 * 暂时不维修的原因
	 */
	private String unfinishedReason;
	
	/*
	 * 结束时间
	 */
	private Date finishTime;
	
	public String getStartTime() throws ParseException {
        /*return DateUtils.getDateFormat().parse(this.startTime);  */
		return this.startTime;
    }
	
	public Date getStartTimeConverted() throws ParseException {
		return DateUtils.getDateFormat().parse(this.startTime);
    }

    public void setStartTime(Date date) {        
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

	/*public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}*/

	public String getEndTime() {
		return endTime;
	}
	
	public Date getEndTimeConverted() throws ParseException {
		return DateUtils.getDateFormat().parse(this.endTime);
    }

	public void setEndTime(Date endTime) {
		this.endTime = DateUtils.getDateFormat().format(endTime);
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

	public void setCreateTime(Date createTime) {
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

	public String getUnfinishedReason() {
		return unfinishedReason;
	}

	public void setUnfinishedReason(String unfinishedReason) {
		this.unfinishedReason = unfinishedReason;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
}
