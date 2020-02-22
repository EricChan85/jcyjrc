package org.yjrc.controllers;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.yjrc.domain.Repair;
import org.yjrc.models.RepairModel;

public class RepairControllerTest {

	private ModelMapper modelMapper = new ModelMapper();
	
	@Test
	public void convertToModelTest() throws ParseException {
		Repair domain = new Repair();
		domain.setPersonId(2);
		domain.setAddress("广厦花园5号楼5单元505");
		domain.setPhone("13689451185");
		domain.setDetails("0935jc420559欠费，麻烦处理一下");
		Date date = new Date();		
		domain.setStartTime(date);
		domain.setEndTime(date);
		domain.setCreateTime(date);
		
		RepairModel model = modelMapper.map(domain, RepairModel.class);
		System.out.println(domain.getStartTime());
		System.out.println("--");
		System.out.println(model.getStartTime());
		assertEquals(domain.getPersonId(), model.getPersonId());
		assertEquals(domain.getAddress(), model.getAddress());
		assertEquals(domain.getEndTime(), model.getEndTime());
	}

}
