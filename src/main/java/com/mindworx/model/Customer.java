package com.mindworx.model;

public class Customer {

	private String custCode;	
	private String custName;
	private String custAdd1;
	private String custAdd2;
	private String custAdd3;
	private String custAdd4;
	private String custCity;
	private String custPincode;
	private String custPhone;
	private String custMobile;
	private String custEmail;
	private String custTIN;
	private String custOU;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAdd1() {
		return custAdd1;
	}

	public void setCustAdd1(String custAdd1) {
		this.custAdd1 = custAdd1;
	}

	public String getCustAdd2() {
		return custAdd2;
	}

	public void setCustAdd2(String custAdd2) {
		this.custAdd2 = custAdd2;
	}

	public String getCustAdd3() {
		return custAdd3;
	}

	public void setCustAdd3(String custAdd3) {
		this.custAdd3 = custAdd3;
	}

	public String getCustAdd4() {
		return custAdd4;
	}

	public void setCustAdd4(String custAdd4) {
		this.custAdd4 = custAdd4;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

	public String getCustPincode() {
		return custPincode;
	}

	public void setCustPincode(String custPincode) {
		this.custPincode = custPincode;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustTIN() {
		return custTIN;
	}

	public void setCustTIN(String custTIN) {
		this.custTIN = custTIN;
	}	
	
	public String getCustOU() {
		return custOU;
	}
	
	public void setCustOU(String custOU) {
		this.custOU = custOU;
	}
	
	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}

	
	
}
