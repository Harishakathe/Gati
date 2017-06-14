package com.mindworx.model;

public class Receiver {
	
	private String receiver_Code;
	private String receiver_Mobile;
	private String receiver_Name;
	private String receiver_Address1;
	private String receiver_Address2;
	private String receiver_Address3;
	private String receiver_Address4;
	private String receiver_City;
	private String receiver_Pin_Code;
	private String receiver_Phone;
	private String receiver_Email;
	private String receiver_VAT_TIN;
	
	public Receiver() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getReceiver_Code() {
		return receiver_Code;
	}
	public void setReceiver_Code(String receiver_Code) {
		this.receiver_Code = receiver_Code;
	}
	public String getReceiver_Mobile() {
		return receiver_Mobile;
	}
	public void setReceiver_Mobile(String receiver_Mobile) {
		this.receiver_Mobile = receiver_Mobile;
	}
	public String getReceiver_Name() {
		return receiver_Name;
	}
	public void setReceiver_Name(String receiver_Name) {
		this.receiver_Name = receiver_Name;
	}
	public String getReceiver_Address1() {
		return receiver_Address1;
	}
	public void setReceiver_Address1(String receiver_Address1) {
		this.receiver_Address1 = receiver_Address1;
	}
	public String getReceiver_Address2() {
		return receiver_Address2;
	}
	public void setReceiver_Address2(String receiver_Address2) {
		this.receiver_Address2 = receiver_Address2;
	}
	public String getReceiver_Address3() {
		return receiver_Address3;
	}
	public void setReceiver_Address3(String receiver_Address3) {
		this.receiver_Address3 = receiver_Address3;
	}
	public String getReceiver_Address4() {
		return receiver_Address4;
	}
	public void setReceiver_Address4(String receiver_Address4) {
		this.receiver_Address4 = receiver_Address4;
	}
	public String getReceiver_City() {
		return receiver_City;
	}
	public void setReceiver_City(String receiver_City) {
		this.receiver_City = receiver_City;
	}
	public String getReceiver_Pin_Code() {
		return receiver_Pin_Code;
	}
	public void setReceiver_Pin_Code(String receiver_Pin_Code) {
		this.receiver_Pin_Code = receiver_Pin_Code;
	}
	public String getReceiver_Phone() {
		return receiver_Phone;
	}
	public void setReceiver_Phone(String receiver_Phone) {
		this.receiver_Phone = receiver_Phone;
	}
	public String getReceiver_Email() {
		return receiver_Email;
	}
	public void setReceiver_Email(String receiver_Email) {
		this.receiver_Email = receiver_Email;
	}
	public String getReceiver_VAT_TIN() {
		return receiver_VAT_TIN;
	}
	public void setReceiver_VAT_TIN(String receiver_VAT_TIN) {
		this.receiver_VAT_TIN = receiver_VAT_TIN;
	}
	
	
	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
	
}
