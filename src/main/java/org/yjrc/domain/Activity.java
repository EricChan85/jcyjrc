package org.yjrc.domain;

import java.util.Date;

/**
 * 活动
 * @author Administrator
 *
 * 
 * @date 2020年4月12日
 */
public class Activity {

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
	
	/*
	 * 创建时间
	 */
	private Date createTime;
	
	/*
	 * 创建者
	 */
	private Integer creatorId;
	
	/*
	 * 状态
	 */
	private int status;

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


	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
