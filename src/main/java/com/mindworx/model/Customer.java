package com.mindworx.model;

public class Customer {

	private String shipper_Code;	
	private String shipper_Name;
	private String shipper_Address1;
	private String shipper_Address2;
	private String shipper_Address3;
	private String shipper_Address4;
	private String shipper_City;
	private String shipper_Pin_Code;
	private String shipper_Phone;
	private String shipper_Mobile;
	private String shipper_Email;
	private String shipper_VAT_TIN;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getShipper_Code() {
		return shipper_Code;
	}


	public void setShipper_Code(String shipper_Code) {
		this.shipper_Code = shipper_Code;
	}


	public String getShipper_Mobile() {
		return shipper_Mobile;
	}
	public void setShipper_Mobile(String shipper_Mobile) {
		this.shipper_Mobile = shipper_Mobile;
	}
	public String getShipper_Name() {
		return shipper_Name;
	}
	public void setShipper_Name(String shipper_Name) {
		this.shipper_Name = shipper_Name;
	}
	public String getShipper_Address1() {
		return shipper_Address1;
	}
	public void setShipper_Address1(String shipper_Address1) {
		this.shipper_Address1 = shipper_Address1;
	}
	public String getShipper_Address2() {
		return shipper_Address2;
	}
	public void setShipper_Address2(String shipper_Address2) {
		this.shipper_Address2 = shipper_Address2;
	}
	public String getShipper_Address3() {
		return shipper_Address3;
	}
	public void setShipper_Address3(String shipper_Address3) {
		this.shipper_Address3 = shipper_Address3;
	}
	public String getShipper_Address4() {
		return shipper_Address4;
	}
	public void setShipper_Address4(String shipper_Address4) {
		this.shipper_Address4 = shipper_Address4;
	}
	public String getShipper_City() {
		return shipper_City;
	}
	public void setShipper_City(String shipper_City) {
		this.shipper_City = shipper_City;
	}
	public String getShipper_Pin_Code() {
		return shipper_Pin_Code;
	}
	public void setShipper_Pin_Code(String shipper_Pin_Code) {
		this.shipper_Pin_Code = shipper_Pin_Code;
	}
	public String getShipper_Phone() {
		return shipper_Phone;
	}
	public void setShipper_Phone(String shipper_Phone) {
		this.shipper_Phone = shipper_Phone;
	}
	public String getShipper_Email() {
		return shipper_Email;
	}
	public void setShipper_Email(String shipper_Email) {
		this.shipper_Email = shipper_Email;
	}
	public String getShipper_VAT_TIN() {
		return shipper_VAT_TIN;
	}
	public void setShipper_VAT_TIN(String shipper_VAT_TIN) {
		this.shipper_VAT_TIN = shipper_VAT_TIN;
	}
	
	
	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
	
}
