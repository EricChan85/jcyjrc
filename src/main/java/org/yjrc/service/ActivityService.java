package org.yjrc.service;

import java.util.List;

import org.yjrc.domain.Activity;
import org.yjrc.models.ActivityModel;
import org.yjrc.models.PagedResult;

public interface ActivityService {
	
	void createActivity(Activity activity);
	
	Activity getById(int id);
	
	/*
	 * 通过报修状态获取，分页显示
	 */
	PagedResult<ActivityModel> getByStatus(int status, int pageIndex, int pageSize);
	
	/*
	 * "获取3条最新发布的活动"
	 */
	List<ActivityModel> getTop3Published();
	
	/*
	 * "获取条最新发布的活动"
	 */
	List<ActivityModel> getRecent();
	
	/*
	 * "更新"
	 */
	void updateActivity(Activity activity);
}
