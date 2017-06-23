package com.mindworx.dao;

import java.util.List;

import com.mindworx.model.Customer;
import com.mindworx.model.PickupDetails;

public interface PickupDetailsDao {
	
	public PickupDetails getPickupDetails();
	public long getGEMS_WS_CUST_AUTO_prod_vals();
	public String getBookingStation(String cust_code);
	public String getGoodType();
	public List<Customer> getCustomerDetails(String customerid);
	public String getPinCodes(String pinCode);
	public String validateXML(PickupDetails pickupDetails);
	public String updateDocket(PickupDetails p);
	public String getEsscode(String pinCode);
	public String getContractNo(String cust_code);
	public String generateDocketNo(PickupDetails p);
	public String insertDocket(PickupDetails p);
}
