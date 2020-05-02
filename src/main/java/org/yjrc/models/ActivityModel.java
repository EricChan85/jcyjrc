package org.yjrc.models;

import java.util.Date;

import org.yjrc.utils.DateUtils;

public class ActivityModel {

	/*
	 * 编号
	 */
	private Integer id;
	
	/*
	 * 标题
	 */
	private String title;
	
	/*
	 * 简述
	 */
	private String sketch;
	
	public String getSketch() {
		return sketch;
	}

	public void setSketch(String sketch) {
		this.sketch = sketch;
	}
	
	/*
	 * 详情
	 */
	private String detail;
	
	private String createTime;
	
	

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTimeByDate(Date createTime) {
		this.createTime = DateUtils.getDateFormat().format(createTime);;
	}
	
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
