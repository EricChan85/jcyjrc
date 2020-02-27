package org.yjrc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.yjrc.dao.RepairDao;
import org.yjrc.domain.Repair;
import org.yjrc.models.PagedResult;
import org.yjrc.models.RepairModel;
import org.yjrc.utils.ConstantsUtils;

public class RepairServiceImpl implements RepairService {

	@Autowired
	private RepairDao repairDao;
	
	@Autowired
	private EnumsService enumsService;
	
	public List<Repair> getByPersonId(int personId) {
		
		return this.repairDao.getByPersonId(personId);
	}


	@Override
	@Transactional
	public void createRepair(Repair repair) {
		this.repairDao.insertRepair(repair);
		
	}


	@Override
	public PagedResult<RepairModel> getByStatus(int status, int pageIndex, int pageSize) {
		int offset = (pageIndex - 1) * pageSize;
		Integer sum = this.repairDao.getCountByStatus(status);
		if (sum == null) {
			sum = 0;
		}
		List<Repair> list = this.repairDao.getByStatus(status, offset, pageSize);
		List<RepairModel> modelList = convertToModelList(list);
		return new PagedResult<RepairModel>(modelList, sum, pageIndex, pageSize);
	}
	
	@Override
	public List<RepairModel> convertToModelList(List<Repair> list) {		
		List<RepairModel> modelList = new ArrayList<RepairModel>();
		Map<Integer, String> items = enumsService.getStatusItemsByKey(ConstantsUtils.getRepairStatusKey());
		for (int i = 0; i < list.size(); i++) {
			Repair repair = list.get(i);
			RepairModel model = new RepairModel();
			model.setId(repair.getId());
			model.setDetails(repair.getDetails());		
		    model.setStartTimeByEntity(repair.getStartTime());
		    model.setEndTimeByEntity(repair.getEndTime());
		    model.setAddress(repair.getAddress());
		    model.setPhone(repair.getPhone());
		    model.setCreateTimeByEntity(repair.getCreateTime());	
		    model.setStatus(repair.getStatus());
		    model.setStatusValue(items.get(repair.getStatus()));
		    model.setRepairDescription(repair.getRepairDescription());
		    model.setEvaluation(repair.getEvaluation());
		    modelList.add(model);
		}		
	    return modelList;
	}


	@Override
	public Repair getById(int id) {
		return this.repairDao.getById(id);
	}


	@Override
	@Transactional
	public void updateRepairDescription(Repair repair) {
		this.repairDao.updateRepairDescription(repair);
		
	}


	@Override
	@Transactional
	public void updateEvaluation(Repair repair) {
		this.repairDao.updateEvaluation(repair);
		
	}


	

}
