package com.mindworx.model;

public class AjaxResponseBody {
	private String msg;
	private String code;
	private PickupDetails pickupDetails;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public PickupDetails getPickupDetails() {
		return pickupDetails;
	}
	public void setPickupDetails(PickupDetails pickupDetails) {
		this.pickupDetails = pickupDetails;
	}
}
