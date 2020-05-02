package org.yjrc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.yjrc.domain.Activity;

public interface ActivityDao {
	
	Activity getById(int id);
	
	Integer getCountByStatus(@Param("status")int status);
	
	List<Activity> getByStatus(@Param("status")int status, 
			@Param("offset")int offset, @Param("count")int count);
	
	List<Activity> getPublished(@Param("status")int status, 
			@Param("count")int count);

	/*
	 * "新增活动"
	 */
	void createActivity(Activity activity);
	
	/*
	 * "更新"
	 */
	void updateActivity(Activity activity);
}
