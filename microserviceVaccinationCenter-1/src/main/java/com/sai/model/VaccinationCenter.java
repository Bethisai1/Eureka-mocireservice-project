package com.sai.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class VaccinationCenter {
	
	@Id
	private int id;
	private String centerName;
	private String CenterAddress;
	
	
	public VaccinationCenter() {
		super();
	}
	public VaccinationCenter(int id, String centerName, String centerAddress) {
		super();
		this.id = id;
		this.centerName = centerName;
		CenterAddress = centerAddress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterAddress() {
		return CenterAddress;
	}
	public void setCenterAddress(String centerAddress) {
		CenterAddress = centerAddress;
	}
	@Override
	public String toString() {
		return "VaccinationCenter [id=" + id + ", centerName=" + centerName + ", CenterAddress=" + CenterAddress + "]";
	}
	
	

}
