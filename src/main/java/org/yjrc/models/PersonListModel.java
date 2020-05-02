package org.yjrc.models;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.yjrc.service.EnumsService;
import org.yjrc.utils.ConstantsUtils;
import org.yjrc.utils.MyStrings;

public class PersonListModel {
	
	/*
	 * 编号
	 */
	private Integer id;
	
	/*
	 * 姓名
	 */
	private String name;	
	
	/*
	 * 性别
	 */
	private String gender;
	
	/*
	 * 出生日期
	 */
	private String dateOfBirth;
	
	/*
	 * 名族
	 */
	private String nationality;
	
	/*
	 * 籍贯
	 */
	private String nativePlace;
	
	/*
	 * 政治面貌
	 */
	private String politicalStatus;
	
	/*
	 * 学历学位
	 */
	private String education;	
	
	/*
	 * 引进时间
	 */
	private String dateOfEntering;
	
	/*
	 * 身份证号
	 */
	private String numberOfIdCard;		
	
	/*
	 * 电话
	 */
	private String phone;
	
	/*
	 * 工作单位
	 */
	private String institution;	
	
	/*
	 * 住址
	 */
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(char gen) {
		switch(gen) {
		case 'M':
			this.gender = "男";
			break;
		case 'F':
			this.gender = "女";
			break;
		default:
			this.gender = "";
			break;
		}
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirthFromEntity(String date) {
		if (MyStrings.isEmpty(date)) {
			this.dateOfBirth = "";
		} else {
			this.dateOfBirth = date.substring(0, 7);
		}		
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(int intNationality, Map<Integer, String> items) {
		if (intNationality <= 0) {
			this.nationality = "";
		} else {
			this.nationality = items.get(intNationality);
		}		
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(int intPoliticalStatus, Map<Integer, String> items) {
		if (intPoliticalStatus <= 0) {
			this.politicalStatus = "";
		} else {
			this.politicalStatus = items.get(intPoliticalStatus);
		}	
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDateOfEntering() {
		return dateOfEntering;
	}

	public void setDateOfEnteringFromEntity(String dateOfEntering) {
		if (MyStrings.isEmpty(dateOfEntering)) {
			this.dateOfEntering = "";
		} else {
			this.dateOfEntering = dateOfEntering.substring(0, 7);
		}
	}

	public String getNumberOfIdCard() {
		return numberOfIdCard;
	}

	public void setNumberOfIdCard(String numberOfIdCard) {
		this.numberOfIdCard = numberOfIdCard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
