package org.yjrc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.yjrc.dao.ActivityDao;
import org.yjrc.domain.Activity;
import org.yjrc.enums.ActivityStatus;
import org.yjrc.models.ActivityModel;
import org.yjrc.models.PagedResult;
import org.yjrc.models.RepairModel;

public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;
	
	@Override
	public void createActivity(Activity activity) {
		this.activityDao.createActivity(activity);
	}
	
	@Override
	public Activity getById(int id) {		
		return this.activityDao.getById(id);
	}

	@Override
	public PagedResult<ActivityModel> getByStatus(int status, int pageIndex, int pageSize) {
		int offset = (pageIndex - 1) * pageSize;
		Integer sum = this.activityDao.getCountByStatus(status);
		if (sum == null) {
			sum = 0;
		}
		List<Activity> list = this.activityDao.getByStatus(status, offset, pageSize);
		List<ActivityModel> modelList = list.stream().map(this::toModel).collect(Collectors.toList());
		return new PagedResult<ActivityModel>(modelList, sum, pageIndex, pageSize);
	}

	private ActivityModel toModel(Activity activity) {
		ActivityModel model = new ActivityModel();
		BeanUtils.copyProperties(activity, model);
		model.setCreateTimeByDate(activity.getCreateTime());
		return model;
	}

	@Override
	public void updateActivity(Activity activity) {
		this.activityDao.updateActivity(activity);
	}

	@Override
	public List<ActivityModel> getTop3Published() {		
		List<Activity> list = this.activityDao.getPublished(ActivityStatus.PUBLISHED.getValue(), 3);
		return list.stream().map(this::toModel).collect(Collectors.toList());
	}

	@Override
	public List<ActivityModel> getRecent() {
		List<Activity> list = this.activityDao.getPublished(ActivityStatus.PUBLISHED.getValue(), 4);
		return list.stream().map(this::toModel).collect(Collectors.toList());
	}

	
}
