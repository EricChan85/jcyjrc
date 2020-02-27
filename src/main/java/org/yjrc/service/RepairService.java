package org.yjrc.service;

import java.util.List;

import org.yjrc.domain.Repair;
import org.yjrc.models.PagedResult;
import org.yjrc.models.RepairModel;

public interface RepairService {
	
	/*
	 * 获取人员提交的报修信息
	 */
	List<Repair> getByPersonId(int personId);
	
	/*
	 * 创建报修信息
	 */
	void createRepair(Repair repair);
	
	/*
	 * 通过报修状态获取，分页显示
	 */
	PagedResult<RepairModel> getByStatus(int status, int pageIndex, int pageSize);
	
	List<RepairModel> convertToModelList(List<Repair> list);
	
	/*
	 * 通过id获取报修信息
	 */
	Repair getById(int id);
	
	/*
	 * 维修人员更新维修情况
	 */
	void updateRepairDescription(Repair repair);
	
	/*
	 * 对维修进行评价
	 */
	void updateEvaluation(Repair repair);
}
