package com.mindworx.dao;

import com.mindworx.model.PickupDetails;

public interface PickupDetailsDao {
	
	public PickupDetails getPickupDetails();
	public long getGEMS_WS_CUST_AUTO_prod_vals();
	public String getBookingStation(String cust_code);
	public String getGoodType();
	public String getCustomerDetails(String customerid);
	public String getPinCodes(String pinCode);
	public String validateXML(PickupDetails pickupDetails);
	
}
